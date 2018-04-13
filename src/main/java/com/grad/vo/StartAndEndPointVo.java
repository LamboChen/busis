package com.grad.vo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description: 公交线路起点、终点经纬度Vo
 * @author: Mr.Chen
 * @create: 2018-03-14 12:00
 **/
@Scope(value = "prototype")
@Component(value = "startAndEndPointVo")
public class StartAndEndPointVo {

    private String start_longitude;     //起点经度
    private String start_latitude;      //起点纬度
    private String end_longitude;       //终点经度
    private String end_latitude;        //终点纬度

    public StartAndEndPointVo(){

    }

    public void setStart_longitude(String start_longitude) {
        this.start_longitude = start_longitude;
    }

    public void setStart_latitude(String start_latitude) {
        this.start_latitude = start_latitude;
    }

    public void setEnd_longitude(String end_longitude) {
        this.end_longitude = end_longitude;
    }

    public void setEnd_latitude(String end_latitude) {
        this.end_latitude = end_latitude;
    }

    public String getStart_longitude() {
        return start_longitude;
    }

    public String getStart_latitude() {
        return start_latitude;
    }

    public String getEnd_longitude() {
        return end_longitude;
    }

    public String getEnd_latitude() {
        return end_latitude;
    }
}
