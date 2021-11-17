package com.exam.service.impl;



import com.exam.mapper.TestMapper;
import com.exam.pojo.entity.Test;
import com.exam.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAll(){
        return testMapper.findAll();
    }
}
