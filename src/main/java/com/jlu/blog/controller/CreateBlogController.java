package com.jlu.blog.controller;

import com.jlu.blog.form.BlogForm;
import com.jlu.blog.model.Blog;
import com.jlu.blog.model.User;
import com.jlu.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/22
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/createBlog")
public class CreateBlogController {


    private final BlogService blogService;

    @Autowired
    public CreateBlogController(BlogService blogService){
        this.blogService=blogService;
    }

    @GetMapping
    public String get(Model model){
        model.addAttribute("blog",new Blog());
        return "edit";
    }

    @PostMapping
    public String post(HttpSession session, @ModelAttribute("blog")@Validated BlogForm form,
                       BindingResult result, Model model){
        if(result.hasErrors()){
            for(ObjectError error:result.getAllErrors()){
                System.out.println(form.getContent().length());
                System.out.println(form.getDescription().length());
                System.out.println(error.toString());
            }
            model.addAttribute("message","标题为1~25字符，描述为10~150字符，内容大于50字符少于1500字符");
            return "edit";
        }
        Blog blog=form.getBlog();
        blog.setUser((User)session.getAttribute("CURRENT_USER"));
        blog.setDate(new Date());
        blogService.save(blog);
        return "index";
    }
}
