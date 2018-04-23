package com.jlu.blog.form;

import com.jlu.blog.model.Blog;

import javax.validation.constraints.Size;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/23
 * github:Easoncheng0405
 */
public class BlogForm {

    @Size(min = 1, max = 25)
    private String title;

    @Size(min = 15, max = 150)
    private String description;

    @Size(min = 50,max = 1500)
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog getBlog(){
        Blog blog=new Blog();
        blog.setTitle(title);
        blog.setDescription(description);
        blog.setContent(content);
        return blog;
    }
}
