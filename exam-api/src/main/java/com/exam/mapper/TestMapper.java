package com.exam.mapper;

import com.exam.pojo.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {
    @Select("select * from test")
    List<Test> findAll();
}
