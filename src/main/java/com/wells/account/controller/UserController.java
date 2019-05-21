package com.wells.account.controller;

import com.wells.common.User;
import com.wells.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/all")
    public List findAll() {
        System.out.println("查询所有");
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println("用户： " + user);
        }
        return users;
    }

    @RequestMapping(value = "/{id}")
    public User find(@PathVariable("id") int id) {
        System.out.println("用户 index： " + id);
        User user = userService.findById(id);
        System.out.println("用户： " + user);
        return user;
    }

    @RequestMapping(value = "/{account}")
    public User findByAccount(@PathVariable("account") String account) {
        System.out.println("用户 index： " + account);
        User user = userService.findByAccount(account);
        System.out.println("用户： " + user);
        return user;
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
