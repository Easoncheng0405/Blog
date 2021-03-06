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
    public User register(User user) {
        return userRepository.save(user);
    }


    @Override
    public User loginByEmail(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public User loginByPhone(String phone, String password) {
        return userRepository.findByPhoneAndPassword(phone, password);
    }

    @Override
    public User findOneByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findOneByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
