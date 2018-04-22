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
    public String get(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String post(Model model, @ModelAttribute("user") @Valid UserForm form,
                       BindingResult result, HttpSession session,
                       @RequestParam(value = "next", required = false) String next) {
        if (result.hasErrors()) {
            model.addAttribute("fields", result);
            return "login";
        }
        User user = userService.loginByEmail(form.getEmail(), form.getPassword());
        if (user == null) {
            model.addAttribute("message", "用户名或密码错误");
            return "login";
        }
        session.setAttribute("CURRENT_USER", user);
        if (next == null || next.trim().equals(""))
            return "redirect:/";
        else
            return "redirect:" + next;
    }

}
