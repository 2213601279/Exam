package com.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.pojo.entity.Exam_Room;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Exam_RoomMapper extends BaseMapper<Exam_Room> {
    //查
    @Select("select * from exam_room")
    List<Exam_Room> findAll();
    //增
    @Insert("insert into exam_room(name,method,score,time,statime,endtime)"+
            "values(#{name},#{method},#{score},#{time},#{statime},#{endtime})")
    int addExamRoom(Exam_Room exam_room);



}
