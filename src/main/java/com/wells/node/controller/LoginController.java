package com.wells.node.controller;

import com.wells.common.User;
import com.wells.node.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


@Controller
@RequestMapping(value = "/login")
public class LoginController {
    public final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    @ResponseBody
    public Map index(@RequestBody Map request) throws IOException {

        System.out.println(request);
        return request;
    }

    @RequestMapping("/{account}")
    @ResponseBody
    public String account(@PathVariable("account") String account) throws Exception {
        System.out.println(account);
        return account;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}