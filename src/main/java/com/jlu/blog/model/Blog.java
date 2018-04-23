package com.jlu.blog.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/23
 * github:Easoncheng0405
 */
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 25,nullable = false)
    private String title;

    @Column(length = 150,nullable = false)
    private String description;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false,length = 1500)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", content='" + content + '\'' + ", user=" + user + '}';
    }
}
