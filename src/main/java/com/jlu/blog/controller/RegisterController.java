package com.jlu.blog.controller;

import com.jlu.blog.form.UserForm;
import com.jlu.blog.model.User;
import com.jlu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;

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
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String get() {
        return "register";
    }

    @PostMapping
    @ResponseBody
    public String post(@Valid UserForm form, BindingResult result) {
        User user = form.getUser();
        if (user == null||result.hasErrors())
            return "输入的信息有误！";
        if (user.getEmail() != null && userService.findOneByEmail(user.getEmail()) != null)
            return "邮箱已经被使用了！";
        if (user.getPhone() != null && userService.findOneByPhone(user.getPhone()) != null)
            return "电话号已经被使用了！";
        user.setCreateTime(new Date());
        return userService.register(user).toString();

    }
}
