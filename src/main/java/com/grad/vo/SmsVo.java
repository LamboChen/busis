package com.grad.vo;

/**
 * @program: busis
 * @description: 短信验证码Vo
 * @author: Mr.Chen
 * @create: 2018-04-12 15:37
 **/

public class SmsVo {

    private String statusCode;
    private String verificationCode;

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
}

