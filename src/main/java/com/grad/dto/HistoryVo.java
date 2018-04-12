package com.grad.dto;

/**
 * @program: busis
 * @description: HistoryVo 主要用于接收参数使用，字符串化
 * @author: Mr.Chen
 * @create: 2018-03-14 11:03
 **/

public class HistoryVo {

    private String start_point;     //起点名称
    private String end_point;       //终点名称
    private String start_longitude;     //起点经度
    private String start_latitude;      //起点纬度
    private String end_longitude;       //终点经度
    private String end_latitude;        //终点纬度
    private String history_time;          //使用路线时间
    private String area;            //区域
    private int user_id;        //用户ID
    private String route_information;       //路线信息

    public HistoryVo(){

    }

    public void setRoute_information(String route_information) {
        this.route_information = route_information;
    }

    public String getRoute_information() {
        return route_information;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setHistory_time(String history_time) {
        this.history_time = history_time;
    }

    public String getHistory_time() {
        return history_time;
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
