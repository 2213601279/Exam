package com.exam.controller;

import com.exam.pojo.entity.User;
import com.exam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("registerUser")
public class RegisterController {
    @Resource
    private UserService userService;

    /**
     * 注册用户
     * @param user
     * @param model
     * @return
     */
    @PostMapping
    public String register(User user, Model model){
        try {
            userService.register(user);
            model.addAttribute("username",user.getName());
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg","注册失败");
            return "register";
        }
    }

}
