package com.exam.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.mapper.Exam_RoomMapper;
import com.exam.pojo.entity.Exam_Room;
import com.exam.service.impl.Exam_RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Exam_RoomController {
    @Autowired

    private Exam_RoomServiceImpl exam_roomService;
//查
    @RequestMapping("examRoom.html")
    public String examRoom (Model model){
        List<Exam_Room> exam_room =exam_roomService.findAll();
        System.out.println(exam_room);
        model.addAttribute("exam_room",exam_room);
        return "examRoom";
    }
//增
    @RequestMapping("addExamRoom")
    @ResponseBody
    public void addExamRoom(@RequestBody Exam_Room exam_room) {
        exam_roomService.addExamRoom(exam_room);
    }


//分页
    @RequestMapping("/examRoom/selectAllByPage/{pageNum}/{pageSize}")
    @ResponseBody
    public ModelAndView selectAllByPage(@PathVariable("pageNum") Integer pageNum,
                                        @PathVariable("pageSize") Integer pageSize){
//        通过modelanview取值
        ModelAndView modelAndView = new ModelAndView();

        IPage<Exam_Room> exam_roomIPage = exam_roomService.selectAllByPage(pageNum,pageSize);

//        验证返回分页数据是否合理

        if(exam_roomIPage.getRecords().size() > 0){
            modelAndView.setViewName("examRoom");
            modelAndView.addObject("exam_roomIPage",exam_roomIPage);

        }else {
//            modelAndView.setViewName("error");
            modelAndView.addObject("msg","not found");
        }
    return modelAndView;
    }

}
