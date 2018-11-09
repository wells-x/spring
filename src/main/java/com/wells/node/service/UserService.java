package com.wells.node.service;

import com.wells.common.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}
