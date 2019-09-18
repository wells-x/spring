package com.wells.account.controller;

import com.wells.account.service.UserService;
import com.wells.common.User;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void login() throws Exception {
//        String userName = "wells";
//        String password = "123456";
//        User user = userService.findByAccount(userName);
//        System.out.println(user);
//        Assert.assertTrue(user.checkPassword(password));
//    }

    @Test
    public void index() {
    }
}