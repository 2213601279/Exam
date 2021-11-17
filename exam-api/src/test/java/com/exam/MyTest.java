package com.exam;

import com.exam.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test(){
        System.out.println(userMapper.findUserAndRoleByUsername("test"));
//        System.out.println(userMapper.findAll());
    }
}
