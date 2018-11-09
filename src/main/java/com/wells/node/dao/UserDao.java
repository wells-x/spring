package com.wells.node.dao;

import com.wells.common.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> findAll();

    User findById(int id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
