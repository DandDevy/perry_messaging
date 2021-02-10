package com.perrysummervacationmessaging.services;

import com.perrysummervacationmessaging.entities.User;
import com.perrysummervacationmessaging.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public User create(){
        User newUser = new User();
        return userDao.save(newUser);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


}
