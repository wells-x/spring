package com.wells.node.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FailedController {
    @RequestMapping("/failed")
    public Map<String, String> requestFailed() {

        Map<String, String> map = new HashMap<>();
        map.put("code", "404");
        map.put("msg", "请求错误");
        return map;
    }
}
