package com.jlu.blog.form;

import com.jlu.blog.model.User;
import com.jlu.blog.utils.RegexUtil;

import javax.validation.constraints.Size;
import java.util.regex.Pattern;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/21
 * github:Easoncheng0405
 */
public class UserForm {

    @Size(min = 6, max = 25)
    private String info;

    @Size(min = 6, max = 25)
    private String password;

    @Size(min = 6, max = 25)
    private String confirm;

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
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
        if (confirm == null || confirm.equals(password)) {
            User user = new User();
            user.setPassword(password);
            if (Pattern.matches(RegexUtil.PHONE, info))
                user.setEmail(info);
            else if (Pattern.matches(RegexUtil.EMAIL, info))
                user.setPhone(info);
            return user;
        }
        return null;
    }
}
