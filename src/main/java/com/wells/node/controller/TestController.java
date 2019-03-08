package com.wells.node.controller;

import com.wells.common.result.AbstractResult;
import com.wells.common.result.Success;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: node
 * @author: wells
 * @create: 2019/3/8
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/one")
    @ResponseBody
    public AbstractResult one(@RequestBody HashMap request) throws Exception {
        System.out.println(request.get("token"));
        System.out.println("TestController");
        Map<String, String> data = new HashMap<>();
        data.put("user", "TEST");
        data.put("new", "New");
        return new Success<>(data);
    }

    @RequestMapping("/two")
    @ResponseBody
    public String two(@RequestBody HashMap request) {
        System.out.println(request.get("token") + "TestController");
        System.out.println("TestController");
        return "";
    }
}
