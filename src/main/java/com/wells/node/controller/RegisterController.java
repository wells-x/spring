package com.wells.node.controller;

import com.wells.common.User;
import com.wells.common.exception.BusinessException;
import com.wells.node.dao.UserDao;
import com.wells.node.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService){
        this.userService = userService;
    }
    @RequestMapping(value = "")
    @ResponseBody
    public HashMap registers(HttpServletRequest request) throws Exception {
        System.out.println(request);
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        HashMap data = new HashMap();
        if (password == null || account == null) {
            data.put("code", 400);
            data.put("msg", "必填项");
            return data;
        }
        System.out.println(account);
        User findUser = userService.findByAccount(account);
        System.out.println("------------------");
        System.out.println(findUser);
        System.out.println("------------------");
        if (findUser != null) {
            data.put("code", 400);
            data.put("msg", "账号已存在");
            return data;
        }
        User user = new User(account, password);
        userService.insertUser(user);
        System.out.println(user);
        return data;
    }
}
