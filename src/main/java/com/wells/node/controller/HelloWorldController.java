package com.wells.node.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/demo")
public class HelloWorldController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(
            HttpServletRequest request, @RequestBody HashMap request2) {
        System.out.println(request.getAttribute("user_id"));
        return "hello";
    }
}