package com.jlu.blog.repository;

import com.jlu.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/20
 * github:Easoncheng0405
 */
@Component
public interface UserRepository extends JpaRepository<User,Long> {

}
