package com.exam.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.exam.pojo.entity.User;
import org.apache.catalina.Manager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("loginUser")
public class LoginController {

    /**
     * 用户登录
     * @param user
     * @param model
     * @return
     */
    @PostMapping
    public ModelAndView test(User user, ModelAndView model){
        //1、
        Subject subject = SecurityUtils.getSubject();
        String username = user.getName();
        UsernamePasswordToken token = new UsernamePasswordToken(username, user.getPassword());
        //2、
        try {
            subject.login(token);
            model.addObject("username",username);
            model.setViewName("index");
        } catch (UnknownAccountException e) { //用户名错误！
            e.printStackTrace();
            model.addObject("msg","用户名或密码错误！");// 用户名或密码错误！
            model.setViewName("login");
        } catch (IncorrectCredentialsException e){ //密码错误！
            e.printStackTrace();
            model.addObject("msg","用户名或密码错误！");// 用户名或密码错误！
            model.setViewName("login");
        }finally {
            return model;
        }
    }



}
