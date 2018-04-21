package com.jlu.blog.service.impl;

import com.jlu.blog.model.User;
import com.jlu.blog.repository.UserRepository;
import com.jlu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/20
 * github:Easoncheng0405
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findOne(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findOneByEmail(String email) {
        return null;
    }

    @Override
    public User findOneByPhone(long phone) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
