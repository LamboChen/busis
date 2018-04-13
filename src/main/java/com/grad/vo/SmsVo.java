package com.grad.vo;

import com.grad.entity.MiaoDiReturn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description: 短信验证码Vo
 * @author: Mr.Chen
 * @create: 2018-04-12 15:37
 **/

@Scope(value = "prototype")
@Component(value = "smsVo")
public class SmsVo {

    private String statusCode;
    private String verificationCode;
    private MiaoDiReturn miaoDiReturn;

    public SmsVo(){

    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public MiaoDiReturn getMiaoDiReturn() {
        return miaoDiReturn;
    }

    public void setMiaoDiReturn(MiaoDiReturn miaoDiReturn) {
        this.miaoDiReturn = miaoDiReturn;
    }
}

