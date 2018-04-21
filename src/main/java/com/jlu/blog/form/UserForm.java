package com.jlu.blog.form;

import com.jlu.blog.model.User;

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
            if (Pattern.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", info))
                user.setEmail(info);
            else if (Pattern.matches("^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", info))
                user.setPhone(info);
            return user;
        }
        return null;
    }
}
