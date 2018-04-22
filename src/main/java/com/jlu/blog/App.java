package com.jlu.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/20
 * github:Easoncheng0405
 */
@SpringBootApplication
@Controller
public class App {

    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
