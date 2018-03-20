package com.grad.entity;

import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description: 公交信息表所对应的实体类
 * @author: Mr.Chen
 * @create: 2018-03-14 07:46
 **/
@Component(value = "bus")
public class Bus {

    private int bus_id;     //公交ID
    private String bus_via_station;         //途经站点
    private String area;        //区域

    public Bus(){

    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public int getBus_id() {
        return bus_id;
    }

    public String getBus_via_station() {
        return bus_via_station;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    public void setBus_via_station(String bus_via_station) {
        this.bus_via_station = bus_via_station;
    }
}
