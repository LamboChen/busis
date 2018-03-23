package com.grad.vo;

import com.grad.entity.Location;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: busis
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-22 18:53
 **/

@Component(value = "locationListApiVo")
public class LocationListApiVo {

    private int code;
    private String message;
    private List<Location> locationList;

    public LocationListApiVo(){

    }

    public int getCode() {
        return code;
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

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }
}
