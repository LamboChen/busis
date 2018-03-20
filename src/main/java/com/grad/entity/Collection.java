package com.grad.entity;

import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description: 收藏路线表所对应的实体类
 * @author: Mr.Chen
 * @create: 2018-03-14 07:32
 **/
@Component(value = "collection")
public class Collection {

    private int collection_id;      //收藏路线ID
    private String start_point;     //起点名称
    private String end_point;       //终点名称
    private String start_longitude;     //起点经度
    private String start_latitude;      //起点纬度
    private String end_longitude;       //终点经度
    private String end_latitude;        //终点纬度
    private String area;            //区域
    private String route_information;       //路线信息
    private int user_id;            //用户ID

    public Collection(){

    }

    public int getUser_id() {
        return user_id;
    }

    public String getRoute_information() {
        return route_information;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setRoute_information(String route_information) {
        this.route_information = route_information;
    }

    public int getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
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
