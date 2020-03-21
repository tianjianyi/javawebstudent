package com.yifeng.service.impl;

import com.yifeng.dao.UserDao;
import com.yifeng.dao.impl.UserDaoImpl;
import com.yifeng.domain.User;
import com.yifeng.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User checkUser(String userId) {
        return userDao.checkUser(userId);
    }
}
