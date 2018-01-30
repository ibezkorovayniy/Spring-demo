package com.illia.services;

import com.illia.dao.UserDao;
import com.illia.model.ProductOrder;
import com.illia.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public User addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRegisterDate(LocalDateTime.now());
        userDao.addUser(user);
        user = userDao.findById(user.getId());
        return user;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
