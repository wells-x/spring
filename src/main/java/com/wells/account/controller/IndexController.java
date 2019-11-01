package com.wells.account.controller;

import com.wells.common.result.Success;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")

public class IndexController {
    @ResponseBody
    @RequestMapping("/")
    public Success index(){
        return new Success();
    }
}
