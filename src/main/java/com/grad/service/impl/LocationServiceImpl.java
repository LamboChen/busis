package com.grad.service.impl;

import com.grad.dao.ILocationDao;
import com.grad.entity.Location;
import com.grad.service.ILocationService;
import com.grad.vo.LocationApiVo;
import com.grad.vo.LocationListApiVo;
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

    @Resource
    private LocationApiVo locationApiVo;

    @Resource
    private LocationListApiVo locationListApiVo;


    public LocationApiVo addLocation(Location location) throws Exception {
        int result = 0;
        String area = "四川成都";

        locationApiVo.setCode(0);
        locationApiVo.setMessage("");

        //数据合法性检查
        if (location.getLocation_name() != "" && location.getLocation_name() != null
                && location.getLocation_name().length() > 20){
            result = -1;
            locationApiVo.setMessage(locationApiVo.getMessage() + "地点名称不能超过20个字符！");
        }
        if (location.getLocation_longitude() != null && location.getLocation_longitude() != ""
                && location.getLocation_longitude().length() > 15){
            locationApiVo.setMessage(locationApiVo.getMessage() + "地点经度不能超过15个字符！");
            result = -1;
        }
        if (location.getLocation_latitude() != null && location.getLocation_latitude() != ""
                && location.getLocation_latitude().length() > 30){
            result = -1;
            locationApiVo.setMessage(locationApiVo.getMessage() + "地点纬度不能超过30个字符！");
        }
        if (location.getLocation_type() != "" && location.getLocation_type() != null
                && location.getLocation_type().length() > 15){
            result = -1;
            locationApiVo.setMessage(locationApiVo.getMessage() + "位置类型名称不能超过15个字符！");
        }
        if (location.getArea() == "" || location.getArea() == null){
            location.setArea(area);
        } else if (location.getArea().length() > 20){
            result = -1;
            locationApiVo.setMessage(locationApiVo.getMessage() + "区域名称不能超过20个字符！");
        }
        if (location.getUser_id() <= 0){
            result = -1;
            locationApiVo.setMessage(locationApiVo.getMessage() + "缺少用户ID！");
        }

        if (result == -1){
            //存在非法数据
            locationApiVo.setCode(0);
        } else {
            //查重处理
            int records = 0;
            records = locationDao.checkLocationAndUser_id(location);

            if (records > 0){
                //该用户已经收藏过该位置
                result = -1;
                locationApiVo.setMessage(locationApiVo.getMessage() + "不能重复收藏！");
                locationApiVo.setCode(0);
            } else {
                //可以进行添加
                locationDao.insertLocation(location);
                result = location.getLocation_id();
                locationApiVo.setCode(1);
                locationApiVo.setMessage(locationApiVo.getMessage() + "收藏成功！");
                locationApiVo.setLocation(location);
            }
        }
        return locationApiVo;
    }

    public LocationApiVo deleteLocation(int location_id) throws Exception {
        locationDao.deleteLocationByLongitudeAndLatitude(location_id);
        locationApiVo.setCode(1);
        locationApiVo.setMessage("删除成功！");
        return locationApiVo;
    }

    public LocationListApiVo findLocationByUser_id(int user_id) throws Exception {
        List<Location> locationList = locationDao.findLocationByUser_id(user_id);
        locationListApiVo.setCode(1);
        locationListApiVo.setMessage("查询成功");
        locationListApiVo.setLocationList(locationList);
        return locationListApiVo;
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
