package com.wells.account.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wells.common.User;
import com.wells.account.service.UserService;
import com.wells.common.result.AbstractResult;
import com.wells.common.result.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/all")
    public AbstractResult findAll(@RequestBody HashMap requestData) {
        int pageNum = 1, pageSize = 2;
        System.out.println(requestData);
        try {
            pageNum = (int) requestData.get("current");
            pageSize = (int) requestData.get("pageSize");
        } catch (Exception ignored) {
        }

        System.out.println("查询所有");
        Page<Object> pageHelper = PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println("用户： " + user);
        }

        System.out.println("========================");

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> page = new HashMap<>();

        page.put("pageNum", pageNum);
        page.put("pageSize", pageSize);
        page.put("total", pageHelper.getTotal());

        map.put("users", users);
        map.put("page", page);

        return new Success<>(map);
    }

    @RequestMapping(value = "/id/{id}")
    public AbstractResult find(@PathVariable("id") int id) {
        System.out.println("用户 index： " + id);
        User user = userService.findById(id);
        System.out.println("用户： " + user);
        return new Success<>(user);
    }

    @RequestMapping(value = "/account/{account}")
    public AbstractResult findByAccount(@PathVariable("account") String account) throws Exception {
        System.out.println("用户 index： " + account);
        User user = userService.findByAccount(account);
        System.out.println("用户： " + user);
        return new Success<>(user);
    }

    @RequestMapping(value = "/add")
    public String insertUser(@RequestBody User user) {
        System.out.println("新增用户");
        int result = userService.insertUser(user);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/modify")
    public String updateUser(@RequestBody User user) {
        System.out.println("修改用户");
        int result = userService.updateUser(user);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }


    @RequestMapping(value = "/delete")
    public String deleteUser(@RequestParam("id") int id) {
        System.out.println("根据用户ID删除用户" + id);
        int result = userService.deleteUser(id);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/*")
    public String noChoose() {
        System.out.println("lll");
        return "";
    }

}
