package com.wells.node.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/success")
public class TestMe {
    @RequestMapping("/info")
    public String info() {
        return "info";
    }
}
