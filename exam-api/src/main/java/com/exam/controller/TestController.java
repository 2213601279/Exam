package com.exam.controller;

import com.exam.pojo.entity.Exam_Room;
import com.exam.pojo.entity.Test;
import com.exam.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private TestServiceImpl testService;
    @RequestMapping("/test.html")
    public String test (Model model){

        List<Test> tests =testService.findAll();
//        List<Exam_Room> exam_room1 = (List<Exam_Room>) exam_room;
        //取数据
//        model.addAttribute("id",id);
//        model.addAttribute("job",job);
//        model.addAttribute("begintime",begintime);
//        model.addAttribute("endtime",endtime);
//        model.addAttribute("deptno",deptno);
//        model.addAttribute("url",url);
//        model.addAttribute("emps",emps);
//        model.addAttribute("depts",depts);
        System.out.println(tests);
//        System.out.println(exam_room1);

        model.addAttribute("tests",tests);

        return "test";
    }
}
