package com.jlu.blog.service.impl;

import com.jlu.blog.model.Blog;
import com.jlu.blog.model.User;
import com.jlu.blog.repository.BlogRepository;
import com.jlu.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/23
 * github:Easoncheng0405
 */
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository){
        this.blogRepository=blogRepository;
    }


    @Override
    public Blog findOne(long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> findBlogsByUser(User user) {
        return blogRepository.findByUser(user);
    }
}
