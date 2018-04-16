package com.grad.entity;

import java.util.Date;

/**
 * @program: busis
 * @description: 公告实体类
 * @author: Mr.Chen
 * @create: 2018-04-16 13:27
 **/
public class Announcement {

    private int announce_id;        //公告id
    private String title;           //标题
    private String content;     //内容
    private char delete_or;         //是否删除
    private Date time;          //发布时间
    private int user_id;        //用户ID

    public Announcement(){

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    public Date getTime() {
        return time;
    }


    public char getDelete_or() {
        return delete_or;
    }

    public void setDelete_or(char delete_or) {
        this.delete_or = delete_or;
    }

    public void setAnnounce_id(int announcement_id) {
        this.announce_id = announcement_id;
    }

    public int getAnnounce_id() {
        return announce_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public void setTime(Date time) {
        this.time = time;
    }
}
