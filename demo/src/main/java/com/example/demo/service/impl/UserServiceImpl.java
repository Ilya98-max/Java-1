package com.example.demo.service.impl;

import com.example.demo.service.UserService;
import dao.impl.UserDaoImpl;

public class UserServiceImpl implements UserService {
private  static final UserServiceImpl instance = new UserServiceImpl();

    public UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
}


    @Override
    public boolean authenticate(String login, String password) {
        // validate login , pass + md5
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        boolean match = userDao.authenticate(login , password);

return match;
    }
  }
