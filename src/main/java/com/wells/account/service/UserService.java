package com.wells.account.service;

import com.wells.account.dao.UserDao;
import com.wells.common.User;

import java.util.List;

public interface UserService extends UserDao {
    List<User> findAll();

    User findById(int id);

    User findByAccount(String account) throws Exception;

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}