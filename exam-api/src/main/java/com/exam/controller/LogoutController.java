package com.exam.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    /**
     * 用户登出
     * @return
     */
    @RequestMapping
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:login.html";
    }
}
