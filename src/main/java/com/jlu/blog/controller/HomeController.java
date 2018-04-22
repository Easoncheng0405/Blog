package com.jlu.blog.controller;

import com.jlu.blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/22
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    @ResponseBody
    public String get(HttpSession session){
        User user=(User)session.getAttribute("CURRENT_USER");
        return user.toString();
    }
}
