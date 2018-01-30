package com.illia.dao;

import com.illia.model.User;

public interface UserDao {

    User addUser(User user);

    User findById(Long id);
}
