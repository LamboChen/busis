package com.grad.entity;

import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description: 位置收藏表对应的实体类
 * @author: Mr.Chen
 * @create: 2018-03-14 07:40
 **/
@Component(value = "location")
public class Location {

    private int location_id;        //位置ID
    private String location_name;       //位置名称
    private String location_longitude;      //经度
    private String location_latitude;       //纬度
    private String location_type;       //位置类型
    private String area;            //区域
    private int user_id;        //用户ID

    public Location(){

    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public int getLocation_id() {
        return location_id;
    }

    public String getLocation_latitude() {
        return location_latitude;
    }

    public String getLocation_longitude() {
        return location_longitude;
    }

    public String getLocation_name() {
        return location_name;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public void setLocation_latitude(String location_latitude) {
        this.location_latitude = location_latitude;
    }

    public void setLocation_longitude(String location_longitude) {
        this.location_longitude = location_longitude;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }
}
