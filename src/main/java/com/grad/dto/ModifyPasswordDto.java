package com.grad.dto;

/**
 * @program: busis
 * @description: 用户修改密码使用
 * @author: Mr.Chen
 * @create: 2018-04-16 18:34
 **/
public class ModifyPasswordDto {

    private int user_id;        //用户ID
    private String old_password;        //原始密码
    private String new_password;        //新密码

    public ModifyPasswordDto(){

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNew_password() {
        return new_password;
    }

    public String getOld_password() {
        return old_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }
}
