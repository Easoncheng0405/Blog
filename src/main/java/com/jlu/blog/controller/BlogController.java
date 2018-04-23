package com.jlu.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/22
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @GetMapping
    public String get(){
        return "blog";
    }
}
