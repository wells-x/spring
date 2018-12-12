package com.wells.node.controller;

import com.wells.common.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")

public class IndexController {
    @ResponseBody
    @RequestMapping("/")
    public User index(){
        User user = new User();
        System.out.println("index, /");
        return user;
    }
}
