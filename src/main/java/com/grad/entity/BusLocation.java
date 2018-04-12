package com.grad.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description: 公交地点表对应的实体类
 * @author: Mr.Chen
 * @create: 2018-03-14 07:43
 **/
@Scope(value = "prototype")
@Component(value = "busLocation")
public class BusLocation {

    private int bus_location_id;        //公交地点ID
    private String bus_location_name;       //位置名称
    private String bus_location_longitude;       //经度
    private String bus_location_latitude;       //纬度
    private String area;        //区域

    public BusLocation(){

    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getBus_location_id() {
        return bus_location_id;
    }

    public String getBus_location_latitude() {
        return bus_location_latitude;
    }

    public String getBus_location_longitude() {
        return bus_location_longitude;
    }

    public String getBus_location_name() {
        return bus_location_name;
    }

    public void setBus_location_id(int bus_location_id) {
        this.bus_location_id = bus_location_id;
    }

    public void setBus_location_latitude(String bus_location_latitude) {
        this.bus_location_latitude = bus_location_latitude;
    }

    public void setBus_location_longitude(String bus_location_longitude) {
        this.bus_location_longitude = bus_location_longitude;
    }

    public void setBus_location_name(String bus_location_name) {
        this.bus_location_name = bus_location_name;
    }
}
