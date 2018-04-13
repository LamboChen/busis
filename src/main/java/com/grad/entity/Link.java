package com.grad.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description: 友情链接实体类
 * @author: Mr.Chen
 * @create: 2018-04-13 21:27
 **/
@Scope(value = "prototype")
@Component(value = "link")
public class Link {

    private int link_id;        //友情链接ID
    private String name;        //链接名称
    private String url;         //链接URL
    private int flag;           //是否使用
    private String type;        //链接类型

    public Link(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getFlag() {
        return flag;
    }

    public int getLink_id() {
        return link_id;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setLink_id(int link_id) {
        this.link_id = link_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
