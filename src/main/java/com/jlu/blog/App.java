package com.jlu.blog;

import com.jlu.blog.model.Blog;
import com.jlu.blog.service.BlogService;
import com.jlu.blog.utils.CreateRandomField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/20
 * github:Easoncheng0405
 */
@SpringBootApplication
@Controller
public class App {

    private final BlogService blogService;

    @Autowired
    public App(BlogService blogService) {
        this.blogService = blogService;
    }

    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }

    @GetMapping("/")
    public String get(Model model){
        Blog one=blogService.findOne(2L);
        Blog two=blogService.findOne(3L);
        Blog three=blogService.findOne(4L);
        model.addAttribute("one",one);
        model.addAttribute("two",two);
        model.addAttribute("three",three);
        model.addAttribute("href1","/blog?id=2");
        model.addAttribute("href2","/blog?id=3");
        model.addAttribute("href3","/blog?id=4");
        return "index";
    }

    @PostMapping("/")
    public String post(){
        return "index";
    }
}
