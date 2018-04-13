package com.grad.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description: 用户找回密码Dto
 * @author: Mr.Chen
 * @create: 2018-04-13 18:13
 **/
@Scope(value = "prototype")
@Component(value = "recoverPasswordDto")
public class RecoverPasswordDto {

    private String code;        //短信验证码
    private String password;        //用户新密码

    public RecoverPasswordDto(){

    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
