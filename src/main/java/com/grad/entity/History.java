package com.grad.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: busis
 * @description: 历史路线表所对应的实体类
 * @author: Mr.Chen
 * @create: 2018-03-14 07:25
 **/
@Component(value = "history")
@Scope(value = "prototype")
public class History {

    private int history_id;     //历史路线ID
    private String start_point;     //起点名称
    private String end_point;       //终点名称
    private String start_longitude;     //起点经度
    private String start_latitude;      //起点纬度
    private String end_longitude;       //终点经度
    private String end_latitude;        //终点纬度
    private Date history_time;          //使用路线时间
    private String area;            //区域
    private String route_information;       //路线信息
    private int user_id;        //用户ID

    public History(){

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRoute_information() {
        return route_information;
    }

    public void setRoute_information(String route_information) {
        this.route_information = route_information;
    }

    public Date getHistory_time() {
        return history_time;
    }

    public int getHistory_id() {
        return history_id;
    }

    public String getArea() {
        return area;
    }

    public String getEnd_latitude() {
        return end_latitude;
    }

    public String getEnd_longitude() {
        return end_longitude;
    }

    public String getEnd_point() {
        return end_point;
    }

    public String getStart_latitude() {
        return start_latitude;
    }

    public String getStart_longitude() {
        return start_longitude;
    }

    public String getStart_point() {
        return start_point;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setEnd_latitude(String end_latitude) {
        this.end_latitude = end_latitude;
    }

    public void setEnd_longitude(String end_longitude) {
        this.end_longitude = end_longitude;
    }

    public void setEnd_point(String end_point) {
        this.end_point = end_point;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public void setHistory_time(Date history_time) {
        this.history_time = history_time;
    }

    public void setStart_latitude(String start_latitude) {
        this.start_latitude = start_latitude;
    }

    public void setStart_longitude(String start_longitude) {
        this.start_longitude = start_longitude;
    }

    public void setStart_point(String start_point) {
        this.start_point = start_point;
    }
}
