package com.jlu.blog.controller;

import com.jlu.blog.form.UserForm;
import com.jlu.blog.model.User;
import com.jlu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    public String get(Model model) {
        model.addAttribute("user", new UserForm());
        return "register";
    }

    @PostMapping
    public String post(Model model, @ModelAttribute("user") @Valid UserForm form,
                       BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            model.addAttribute("fields", result);
            return "register";
        }else if (!form.getPassword().equals(form.getConfirm())) {
            result.rejectValue("confirm","两次密码不一致");
            model.addAttribute("fields", result);
            return "register";
        }else if(userService.findOneByEmail(form.getEmail())!=null){
            model.addAttribute("message","这个邮箱地址已被注册了");
            return "register";
        }
        User user = form.getUser();
        user.setEmail(user.getEmail());
        user.setCreateTime(new Date());
        session.setAttribute("CURRENT_USER",userService.register(user));
        return "redirect:/";

    }
}
