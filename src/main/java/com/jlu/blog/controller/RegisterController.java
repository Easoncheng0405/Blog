package com.jlu.blog.controller;

import com.jlu.blog.model.User;
import com.jlu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/20
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    @ResponseBody
    public List<User> get(){
        User user=new User();
        user.setCreateTime(new Date());
        user.setEmail("597021782@qq.com");
        user.setPassword("cc123456");
        user.setPhone("15843132084");
        userService.save(user);
        return userService.findAll();
    }

    @PostMapping
    public String post(){
        return "";
    }
}
