package com.wells.node.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/demo")
public class HelloWorldController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestBody HashMap request) {
        System.out.println("----->");
        System.out.println(request);
        return "hello";
    }
}