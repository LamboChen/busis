package com.grad.vo;

/**
 * @program: busis
 * @description: 用于删除公告vo
 * @author: Mr.Chen
 * @create: 2018-04-16 13:49
 **/
public class AnnounceDeleteVo {

    private int announce_id;        //公告ID
    private char delete_or = '1';       //删除字段

    public AnnounceDeleteVo(){

    }

    public void setDelete_or(char delete_or) {
        this.delete_or = delete_or;
    }

    public char getDelete_or() {
        return delete_or;
    }

    public int getAnnounce_id() {
        return announce_id;
    }

    public void setAnnounce_id(int announce_id) {
        this.announce_id = announce_id;
    }
}
