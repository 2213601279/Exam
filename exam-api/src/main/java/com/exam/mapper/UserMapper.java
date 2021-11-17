package com.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.pojo.entity.Role;
import com.exam.pojo.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    User findUserAndRoleByUsername(String primaryPrincipal);
}
