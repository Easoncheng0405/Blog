package com.jlu.blog.service;

import com.jlu.blog.model.Blog;
import com.jlu.blog.model.User;

import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/23
 * github:Easoncheng0405
 */
public interface BlogService {

    Blog findOne(long id);

    Blog save(Blog blog);

    List<Blog> findBlogsByUser(User user);
}
