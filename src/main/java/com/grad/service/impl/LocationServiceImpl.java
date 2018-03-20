package com.grad.service.impl;

import com.grad.dao.ILocationDao;
import com.grad.entity.Location;
import com.grad.service.ILocationService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: busis
 * @description: ILocationService接口实现类
 * @author: Mr.Chen
 * @create: 2018-03-14 20:49
 **/
@Component(value = "locationService")
public class LocationServiceImpl implements ILocationService {

    @Resource
    private ILocationDao locationDao;

    public int addLocation(Location location) throws Exception {
        int result = 0;
        String area = "四川成都";

        //数据合法性检查
        if (location.getLocation_name() != "" && location.getLocation_name() != null
                && location.getLocation_name().length() > 20){
            result = -1;
        }
        if (location.getLocation_longitude() == null || location.getLocation_longitude() == ""
                || location.getLocation_longitude().length() > 15){
            result = -1;
        }
        if (location.getLocation_latitude() == null || location.getLocation_latitude() == ""
                || location.getLocation_latitude().length() >15){
            result = -1;
        }
        if (location.getLocation_type() != "" && location.getLocation_type() != null
                && location.getLocation_type().length() > 15){
            result = -1;
        }
        if (location.getArea() == "" || location.getArea() == null){
            location.setArea(area);
        } else if (location.getArea().length() > 20){
            result = -1;
        }
        if (location.getUser_id() <= 0){
            result = -1;
        }

        if (result == -1){
            //存在非法数据

        } else {
            //查重处理
            int records = 0;
            records = locationDao.checkLocationAndUser_id(location);

            if (records > 0){
                //该用户已经收藏过该位置
                result = -1;
            } else {
                //可以进行添加
                locationDao.insertLocation(location);
                result = location.getLocation_id();
            }
        }
        return result;
    }

    public void deleteLocation(Location location) throws Exception {
        locationDao.deleteLocationByLongitudeAndLatitude(location);
    }

    public List<Location> findLocationByUser_id(int user_id) throws Exception {
        List<Location> locationList = locationDao.findLocationByUser_id(user_id);
        return locationList;
    }

    public int totalLocation(Location location) throws Exception {
        int result = 0;
        if (location.getLocation_longitude() == null || location.getLocation_longitude() == ""
                || location.getLocation_longitude().length() > 15){
            result = -1;
        }
        if (location.getLocation_latitude() == null || location.getLocation_latitude() == ""
                || location.getLocation_latitude().length() >15){
            result = -1;
        }
        if (result == -1){
            //存在非法数据

        } else {
            result = locationDao.totalLocation(location);
        }
        return result;
    }
}
