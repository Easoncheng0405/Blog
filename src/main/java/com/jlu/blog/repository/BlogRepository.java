package com.jlu.blog.repository;

import com.jlu.blog.model.Blog;
import com.jlu.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/23
 * github:Easoncheng0405
 */
@Component
public interface BlogRepository extends JpaRepository<Blog,Long> {



    List<Blog> findByUser(User user);

}
