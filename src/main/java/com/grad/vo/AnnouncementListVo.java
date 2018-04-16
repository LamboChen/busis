package com.grad.vo;

import com.grad.entity.Announcement;

import java.util.ArrayList;

/**
 * @program: busis
 * @description: 用于公告业务逻辑层传输数据
 * @author: Mr.Chen
 * @create: 2018-04-16 13:56
 **/
public class AnnouncementListVo {

    private int code;       //返回状态码
    private String message;         //状态码说明
    private ArrayList<Announcement> announcementArrayList;      //公告信息

    public AnnouncementListVo(){

    }

    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<Announcement> getAnnouncementArrayList() {
        return announcementArrayList;
    }

    public void setAnnouncementArrayList(ArrayList<Announcement> announcementArrayList) {
        this.announcementArrayList = announcementArrayList;
    }
}
