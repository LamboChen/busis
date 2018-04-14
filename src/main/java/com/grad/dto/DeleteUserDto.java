package com.grad.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description: 用于删除用户API接口
 * @author: Mr.Chen
 * @create: 2018-04-14 14:18
 **/

@Scope(value = "prototype")
@Component(value = "deleteUserDto")
public class DeleteUserDto {

    private int admin_id;
    private int user_id;

    public DeleteUserDto(){

    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
}
