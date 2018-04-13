package com.grad.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description: 秒滴短信验证码请求返回数据
 * @author: Mr.Chen
 * @create: 2018-04-13 07:01
 **/

@Scope(value = "prototype")
@Component(value = "miaoDiReturn")
public class MiaoDiReturn {

    private String respCode;        //请求状态码
    private String respDesc;        //对状态吗的描述
    private String failCount;       //表示验证码通过短信发送失败的条数
    private Object failList;        //失败列表，包含失败号码、失败原因
    private String smsId;           //短信标示符，一个由32个字符组成的短信唯一标志符

    public MiaoDiReturn(){

    }

    public String getFailCount() {
        return failCount;
    }

    public Object getFailList() {
        return failList;
    }

    public String getRespCode() {
        return respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public String getSmsId() {
        return smsId;
    }

    public void setFailCount(String failCount) {
        this.failCount = failCount;
    }

    public void setFailList(Object failList) {
        this.failList = failList;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }
}
