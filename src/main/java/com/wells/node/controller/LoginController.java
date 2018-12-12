package com.wells.node.controller;

import com.wells.node.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    public final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    @ResponseBody
    public String index(HttpServletRequest request) throws Exception {
//        Map<String, String> returnMap = new HashMap<String, String>();
        System.out.println(request);

        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

//        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request).getParameterMap();
//        System.out.println(request.toString());
//        String ss = request.getParameter("ss");
//        System.out.println(eventId);
//        System.out.println(ss);
//        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
//        System.out.println(params);


        /*String account = user.getAccount();
        User loginUser = userService.findByAccount(account);
        System.out.println(loginUser);
        System.out.println("LoginController.index");*/
        return request.toString();
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