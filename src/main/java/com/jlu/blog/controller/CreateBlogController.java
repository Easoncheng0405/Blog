package com.jlu.blog.controller;

import com.jlu.blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/createBlog")
public class CreateBlogController {

    @GetMapping
    public String get(Model model,HttpSession session){

        User user=(User)session.getAttribute("CURRENT_USER");
        return "edit";
    }

    @PostMapping
    @ResponseBody
    public String post(){
        return "createBlog";
    }
}
