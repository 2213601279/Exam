package com.exam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //首页
        registry.addViewController("index").setViewName("index");
        registry.addViewController("index.html").setViewName("index");
        registry.addViewController("/").setViewName("index");

        //考前准备
        //题库管理
        registry.addViewController("questionBank.html").setViewName("questionBank");
        registry.addViewController("questionBank-add.html").setViewName("questionBank-add");
        registry.addViewController("questionBank-edit.html").setViewName("questionBank-edit");
        //试卷管理
        registry.addViewController("question.html").setViewName("question");
        registry.addViewController("question-add.html").setViewName("question-add");
        registry.addViewController("question-edit.html").setViewName("question-edit");
        registry.addViewController("question-password.html").setViewName("question-password");
        //考场安排
        registry.addViewController("examInfo.html").setViewName("examInfo");
        registry.addViewController("examInfo-add.html").setViewName("examInfo-add");
        registry.addViewController("examInfo-edit.html").setViewName("examInfo-edit");

        //考试过程
        //考试监控
        registry.addViewController("examRoom.html").setViewName("examRoom");
        registry.addViewController("monitor-exam.html").setViewName("monitor-exam");

        //考后成绩
        //在线阅卷
        registry.addViewController("question-review.html").setViewName("question-review");
        //成绩管理
        registry.addViewController("score-students.html").setViewName("score-students");

        //练习管理
        //我的练习
        registry.addViewController("test.html").setViewName("test");
        //错题集
        registry.addViewController("test-error.html").setViewName("test-error");

        //我的考试
        //参加考试
        registry.addViewController("question-join.html").setViewName("question-join");
        //我的成绩
        registry.addViewController("score-student.html").setViewName("score-student");

        //我的练习
        //参加练习
        registry.addViewController("test-join.html").setViewName("test-join");
        //我的成绩
        registry.addViewController("test-score-student.html").setViewName("test-score-student");

        //报表中心
        //成绩报表
        registry.addViewController("score.html").setViewName("score");
        registry.addViewController("score-echarts1.html").setViewName("score-echarts1");
        registry.addViewController("score-echarts2.html").setViewName("score-echarts2");
        registry.addViewController("score-echarts3.html").setViewName("score-echarts3");
        //题库报表
        registry.addViewController("questionBank2.html").setViewName("questionBank2");
        //部门报表
        registry.addViewController("department.html").setViewName("department");
        //岗位报表
        registry.addViewController("position.html").setViewName("position");

        //系统设置
        //人员管理
        registry.addViewController("user.html").setViewName("user");
        registry.addViewController("user-add.html").setViewName("user-add");
        registry.addViewController("user-edit.html").setViewName("user-edit");

        //角色管理
        registry.addViewController("role.html").setViewName("role");
        registry.addViewController("role-add.html").setViewName("role-add");

        registry.addViewController("welcome.html").setViewName("welcome");
        registry.addViewController("login.html").setViewName("login");
        registry.addViewController("register.html").setViewName("register");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyHandlerInterceptor())
//                .addPathPatterns("/*").excludePathPatterns("/","");
//    }
}
