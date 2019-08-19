package com.wells.account.controller;

import com.wells.account.service.UserService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class LoginControllerTest {

    @Autowired
    private UserService userService;

    @Test
    public void login() throws Exception {
        String mockResult = "{\"number\":20}";

       /* Mockito.when(

        )*/
    }

    @Test
    public void index() {
    }
}