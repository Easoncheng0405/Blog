package com.jlu.blog.controller;

import com.jlu.blog.form.UserForm;
import com.jlu.blog.model.User;
import com.jlu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/21
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String get() {
        return "login";
    }

    @PostMapping
    @ResponseBody
    public String post(UserForm form) {
        User user = form.getUser();
        if (user == null)
            return "输入的信息有误！";
        if (user.getPhone() != null)
            user = userService.loginByPhone(user.getPhone(), user.getPassword());
        else
            user = userService.loginByEmail(user.getEmail(), user.getPassword());
        if(user==null)
            return "用户名或密码错误";
        else
            return user.toString();
    }

}
