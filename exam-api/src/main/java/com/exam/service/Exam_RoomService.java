package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.pojo.entity.Exam_Room;

import java.util.List;

public interface Exam_RoomService {
    
    List<Exam_Room> findAll();


    int addExamRoom(Exam_Room exam_room);

    IPage<Exam_Room> selectAllByPage(Integer pageNum,Integer pageSize);
}
