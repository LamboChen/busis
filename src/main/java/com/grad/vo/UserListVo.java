package com.grad.vo;

import com.grad.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @program: busis
 * @description: 用户列表、状态码、状态信息说明Vo
 * @author: Mr.Chen
 * @create: 2018-04-13 06:12
 **/
@Scope(value = "prototype")
@Component(value = "userListVo")
public class UserListVo {

    private ArrayList<User> userArrayList;
    private int statusCode;     //状态码
    private String message;     //状态信息说明

    public UserListVo(){

    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
