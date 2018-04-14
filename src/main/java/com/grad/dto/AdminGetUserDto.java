package com.grad.dto;

/**
 * @program: busis
 * @description: 管理员获取用户列表dto
 * @author: Mr.Chen
 * @create: 2018-04-14 18:17
 **/
public class AdminGetUserDto {

    private int admin_id;        //管理员ID
    private char authority;     //用户权限

    public AdminGetUserDto(){

    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAuthority(char authority) {
        this.authority = authority;
    }

    public char getAuthority() {
        return authority;
    }
}
