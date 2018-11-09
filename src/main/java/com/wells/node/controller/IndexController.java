package com.wells.node.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")

public class IndexController {
    @ResponseBody
    @RequestMapping("/")
    public String index(){
        System.out.println("index, /");
        return "首页";
    }
}
