package com.jlu.blog.service;

import com.jlu.blog.model.User;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/20
 * github:Easoncheng0405
 */
public interface UserService {

    User save(User user);

    User findOne(long id);

    User findOneByEmail(String email);

    User findOneByPhone(long phone);


}
