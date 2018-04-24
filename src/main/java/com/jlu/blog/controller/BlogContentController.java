package com.jlu.blog.controller;

import com.jlu.blog.model.Blog;
import com.jlu.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/24
 * github:Easoncheng0405
 */
@Controller
public class BlogContentController {

    private final BlogService blogService;

    @Autowired
    public BlogContentController(BlogService blogService){
        this.blogService=blogService;
    }


    @PostMapping("/getContent")
    @ResponseBody
    public Map getContent(long id){
        Blog blog=blogService.findOne(id);
        Map map=new HashMap<String,String>();
        map.put("content",blog.getContent());
        return map;
    }
}
