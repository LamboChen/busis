package com.grad.vo;

import com.grad.entity.Location;
import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-22 18:49
 **/

@Component(value = "locationApiVo")
public class LocationApiVo {

    private int code;
    private String message;
    private Location location;

    public LocationApiVo(){

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
