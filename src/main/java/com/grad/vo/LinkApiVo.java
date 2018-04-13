package com.grad.vo;

import com.grad.entity.Link;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @program: busis
 * @description: 友情链接Vo，用于业务逻辑层，主要对应API接口
 * @author: Mr.Chen
 * @create: 2018-04-13 21:44
 **/

@Scope(value = "prototype")
@Component(value = "linkApiVo")
public class LinkApiVo {

    private int code;       //返回码
    private String message;     //返回码说明
    private ArrayList<Link> linkArrayList;      //友情链接

    public LinkApiVo(){

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

    public int getCode() {
        return code;
    }

    public ArrayList<Link> getLinkArrayList() {
        return linkArrayList;
    }

    public void setLinkArrayList(ArrayList<Link> linkArrayList) {
        this.linkArrayList = linkArrayList;
    }
}
