package com.wells.node.controller;

import com.wells.common.JwtToken;
import com.wells.common.User;
import com.wells.common.exception.BizExceptionEnum;
import com.wells.common.result.AbstractResult;
import com.wells.common.result.Error;
import com.wells.common.result.Success;
import com.wells.node.service.UserService;
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
    public AbstractResult login(@RequestBody HashMap request) throws Exception {
        Object account = request.get("account"), password = request.get("password");
        System.out.println(account);
        System.out.println(password);
        System.out.println(account);
        if (account == "" || account == null || password == "" || password == null) {
            return new Error(BizExceptionEnum.LOGIN_EMPTY);
        }

        User user = userService.findByAccount((String) account);
        if (user == null || !user.checkPassword((String) password)) {
            return new Error(BizExceptionEnum.LOGIN_ERROR);
        }

        String token = JwtToken.createToken(user.getId());
        Map data = new HashMap<>();
        data.put("user", user);
        data.put("token", token);
        System.out.println(data);

        return new Success<>(data);
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
    public String index(@RequestBody HashMap request) throws Exception {
        String token = (String) request.get("token");
        if (token == null) return request.toString();
        Long user_id = JwtToken.getAppUID(token);
        System.out.println(user_id);

        return request.toString();
    }

}