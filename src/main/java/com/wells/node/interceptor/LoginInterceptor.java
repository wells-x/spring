package com.wells.node.interceptor;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.wells.common.JwtToken;
import com.wells.common.exception.BizExceptionEnum;
import com.wells.common.result.Error;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: node
 * @author: wells
 * @create: 2018/12/14
 */
public class LoginInterceptor implements HandlerInterceptor {
    long start = System.currentTimeMillis();

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse httpServletResponse, Object o) throws Exception {
        start = System.currentTimeMillis();
        String requestURI = req.getRequestURI();
        System.out.println("LoginInterceptor");
        System.out.println(requestURI);
        String token = req.getHeader("token");
        if (token == null) {
            /*httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            try (PrintWriter writer = httpServletResponse.getWriter()) {
                Error error = new Error(BizExceptionEnum.ERROR_CREATE_DICT);
                writer.print(error);
                return false;

            } catch (IOException e) {
            }*/
            Error error = new Error(BizExceptionEnum.NO_LOGIN);
            this.returnJson(httpServletResponse, JSON.toJSONString(error));

            return false;
        }
        Long user_id = JwtToken.getAppUID(token);
        System.out.println(user_id);
//        req.
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor cost=" + (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }


    private void returnJson(HttpServletResponse response, String json) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
        } finally {
            if (writer != null)
                writer.close();
        }
    }

}
