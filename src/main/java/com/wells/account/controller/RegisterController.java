package com.wells.account.controller;

import com.wells.common.User;
import com.wells.account.service.UserService;
import com.wells.common.exception.BizExceptionEnum;
import com.wells.common.result.AbstractResult;
import com.wells.common.result.Error;
import com.wells.common.result.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/register", method = RequestMethod.POST)
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "")
    @ResponseBody
    public AbstractResult registers(@RequestBody HashMap request) throws Exception {
        System.out.println(request);
        Object account = request.get("account"),
                password = request.get("password"),
                age = request.get("age"),
                email = request.get("email"),
                name = request.get("nickname");
        System.out.println(account);
        HashMap<String, Object> data = new HashMap<>();
        if (password == null || account == null || password.equals("") || account.equals("")) {
            data.put("code", 400);
            data.put("msg", "必填项");
            return new Error(BizExceptionEnum.REQUEST_NULL);
        }
        System.out.println(account);
        User findUser = userService.findByAccount((String) account);
        System.out.println("------------------");
        System.out.println(findUser);
        System.out.println("------------------");
        if (findUser != null) {
            data.put("code", 400);
            data.put("msg", "账号已存在");
            return new Error(BizExceptionEnum.USER_ALREADY_REG);
        }
        User user = new User((String) account, (String) password);
        user.setAge(Integer.parseInt((String) age));
        user.setEmail((String) email);
        user.setName((String) name);
        userService.insertUser(user);
        System.out.println(user);
        data.put("msg", "注册成功");
        return new Success<>(data);
    }
}

