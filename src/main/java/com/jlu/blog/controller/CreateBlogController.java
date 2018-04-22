package com.jlu.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public String get(){
        return "createBlog";
    }

    @PostMapping
    @ResponseBody
    public String post(){
        return "createBlog";
    }
}
