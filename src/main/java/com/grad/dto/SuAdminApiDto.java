package com.grad.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description: 超级管理员操作普通管理员所需Dto
 * @author: Mr.Chen
 * @create: 2018-04-14 10:11
 **/
@Scope(value = "prototype")
@Component(value = "suAdminApiDto")
public class SuAdminApiDto {

    private int su_id;      //超级管理员ID
    private String username;        //新增管理员用户名
    private String password;        //新增管理员密码
    private String introduce;       //新增管理员介绍
    private String telphone;        //新增管理员电话号码

    public SuAdminApiDto(){

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getSu_id() {
        return su_id;
    }

    public void setSu_id(int su_id) {
        this.su_id = su_id;
    }
}
