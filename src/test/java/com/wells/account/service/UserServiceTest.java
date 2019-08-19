package com.wells.account.service;

import com.wells.account.service.impl.UserServiceImpl;
import com.wells.common.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

//    public UserServiceTest(UserService userService) {
//        this.userService = userService;
//    }
//    @Test
//    public void index(){}

    @Test
    public void findAll() throws Exception {
        System.out.println(userService);
        List<User> list = null;
        try {
            list = userService.findAll();
            System.out.println(list);
            System.out.println(list.size());
        } catch (Exception e) {
            System.out.println(e);
        }
        Assert.assertEquals(list.size(), 5);
    }

    @Test
    public void findById() {
        User user = userService.findById(1);
        Assert.assertEquals(user.getAccount(), "wells");
    }

    @Test
    public void findByAccount() {

    }

    @Test
    public void insertUser() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
    }
}