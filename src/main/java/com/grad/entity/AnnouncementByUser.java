package com.grad.entity;

/**
 * @program: busis
 * @description: 公告实体类，用于用户使用
 * @author: Mr.Chen
 * @create: 2018-04-16 18:09
 **/
public class AnnouncementByUser {

    private String title;
    private String content;

    public AnnouncementByUser(){

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
