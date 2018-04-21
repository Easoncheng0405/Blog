package com.jlu.blog.service;

import com.jlu.blog.model.User;

import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/20
 * github:Easoncheng0405
 */
public interface UserService {

    User register(User user);


    User loginByEmail(String email,String password);

    User loginByPhone(String phone,String password);

    User findOneByEmail(String email);

    User findOneByPhone(String phone);

    List<User> findAll();

}
