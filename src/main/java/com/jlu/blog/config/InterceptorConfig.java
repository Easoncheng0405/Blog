package com.jlu.blog.config;

import com.jlu.blog.fifter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/22
 * github:Easoncheng0405
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //.addPathPatterns("/createBlog")
                .addPathPatterns("/home");
    }
}
