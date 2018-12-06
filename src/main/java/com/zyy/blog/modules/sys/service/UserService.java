package com.zyy.blog.modules.sys.service;

import com.zyy.blog.modules.sys.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 数据插入
     */


    int insert(User user);

    User login(User user);

    List<User> selectAllUser(User user);


    void updateUser(User user);
}
