package com.jlu.blog.form;

import com.jlu.blog.model.User;
import com.jlu.blog.utils.RegexUtil;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.regex.Pattern;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/21
 * github:Easoncheng0405
 */
public class UserForm {

    @Email
    private String email;

    @Size(min = 6, max = 25)
    private String password;

    @Size(min = 6, max = 25)
    private String confirm;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public User getUser() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return user;

    }
}
