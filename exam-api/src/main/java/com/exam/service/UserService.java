package com.exam.service;

import com.exam.pojo.entity.User;

public interface UserService {
    User findUserAndRoleByUsername(String primaryPrincipal);

    User findUserByName(String principal);

    void register(User user);
}
