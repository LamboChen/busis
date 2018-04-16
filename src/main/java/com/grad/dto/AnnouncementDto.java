package com.grad.dto;

/**
 * @program: busis
 * @description: 公告Dto
 * @author: Mr.Chen
 * @create: 2018-04-16 17:44
 **/
public class AnnouncementDto {

    private String title;       //公告标题
    private String content;     //公告内容
    private int user_id;        //发布者ID

    public AnnouncementDto(){

    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
