package com.exam.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.mapper.Exam_RoomMapper;
import com.exam.pojo.entity.Exam_Room;
import com.exam.service.Exam_RoomService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Exam_RoomServiceImpl implements Exam_RoomService {
    @Autowired
    private Exam_RoomMapper exam_roomMapper;
//    查
    @Override
    public List<Exam_Room> findAll() {
        return exam_roomMapper.findAll();
    }

//    增
    @Override
    public int addExamRoom(Exam_Room exam_room){
        int add=exam_roomMapper.addExamRoom(exam_room);
        if (add < 0 ){
            System.out.println("插入失败");
        }else {
            System.out.println("插入cg");
        }
        return add;
    }
//分页
    @Override
    public  IPage<Exam_Room> selectAllByPage(Integer pageNum,Integer pageSize){

        Page<Exam_Room> exam_roomPage = new Page<>(pageNum,pageSize);
        //返回
//        <E extends IPage<T>> E selectPage(E page, @Param(Constants.WRAPPER)
//        Wrapper<T> queryWrapper);
        return exam_roomMapper.selectPage(exam_roomPage,null);
    }
}
