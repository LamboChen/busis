package com.grad.vo;

import com.grad.entity.User;

/**
 * @program: busis
 * @description: 用户相关接口调用所需Vo
 * @author: Mr.Chen
 * @create: 2018-03-22 15:21
 **/
//@Scope(value = "prototype")
//@Component(value = "userApiVo")
public class UserApiVo {

    private User user;      //用户基本信息
    private int code;       //状态返回码
    private String message;     //状态信息说明

    public UserApiVo(){

    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
