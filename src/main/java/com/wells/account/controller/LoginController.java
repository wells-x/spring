package com.wells.account.controller;

import com.wells.common.JwtToken;
import com.wells.common.User;
import com.wells.common.exception.BizExceptionEnum;
import com.wells.common.result.AbstractResult;
import com.wells.common.result.Error;
import com.wells.common.result.Success;
import com.wells.account.service.UserService;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 登录操作
     *
     * @param request 请求
     * @return 判断登录状态
     * @author wells
     */
    @RequestMapping(value = "")
    @ResponseBody
    public AbstractResult login(@RequestBody HashMap request) {
        Object account = request.get("account"), password = request.get("password");
        Error error;
        try {
            Map data = this.doLogin(account, password);
            return new Success<>(data);
        } catch (MyBatisSystemException e) {
            error = new Error(BizExceptionEnum.DB_CONNECT_EXCEPTION);
            error.setDetails(e.toString());
        } catch (Exception e) {
            error = new Error(BizExceptionEnum.LOGIN_ERROR);
            error.setMsg(e.toString());
        }
        return error;
    }

    private Map doLogin(Object account, Object password) throws Exception {
        System.out.println("account: " + account + "--- password: " + password);
        if (account == "" || account == null || password == "" || password == null) {
            new Error(BizExceptionEnum.LOGIN_EMPTY);
        }

        User user = userService.findByAccount((String) account);

        String token = JwtToken.createToken(user.getId());
        Map<String, Object> data = new HashMap<>();
        data.put("user", user);
        data.put("token", token);
        return data;
    }

    /**
     * 登录操作
     *
     * @param request 请求
     * @return 判断登录状态
     * @author wells
     */
    @RequestMapping(value = "/check")
    @ResponseBody
    public String index(@RequestBody HashMap request) {
        String token = (String) request.get("token");
        if (token == null) return request.toString();
        Long user_id = JwtToken.getAppUID(token);
        System.out.println(user_id);

        return request.toString();
    }

}