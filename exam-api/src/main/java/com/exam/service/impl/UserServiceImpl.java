package com.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.exam.mapper.UserMapper;
import com.exam.pojo.entity.User;
import com.exam.service.UserService;
import com.exam.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户名找 User和对应的 Roles 信息
     * @param primaryPrincipal
     * @return
     */
    @Override
    public User findUserAndRoleByUsername(String primaryPrincipal) {
        return userMapper.findUserAndRoleByUsername(primaryPrincipal);
    }

    /**
     * 根据用户名找 User
     * @param principal
     * @return
     */
    @Override
    public User findUserByName(String principal) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(User::getId,User::getName,User::getPassword,User::getSalt);
        queryWrapper.eq(User::getName,principal);
        queryWrapper.last("limit 1");
        return userMapper.selectOne(queryWrapper);
    }

    /**
     * 注册用户
     * @param user
     */
    @Override
    public void register(User user) {
        //处理业务
        //明文密码 加密：MD5+salt+hash散列1024

        //1、工具类生成随机位salt
        String salt = SaltUtils.getSalt(8);
        //2、将salt保存对象
        user.setSalt(salt);
        //3、生成 MD5+salt+hash散列1024次 加密后的密码
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1024);
        //4、将密码保存实体对象
        user.setPassword(md5Hash.toHex());
        System.out.println(user);
        userMapper.insert(user);
    }
}
