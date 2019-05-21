package com.wells.account.service;

import com.wells.common.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    User findByAccount(String account);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}