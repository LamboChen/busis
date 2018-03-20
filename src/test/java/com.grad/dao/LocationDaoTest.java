package com.grad.dao;

import com.grad.entity.Location;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: busis
 * @description: LocationDao方法测试类
 * @author: Mr.Chen
 * @create: 2018-03-14 20:11
 **/
public class LocationDaoTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void testInsertLocation() throws Exception{
        ILocationDao locationDao = (ILocationDao) applicationContext.getBean("locationMapper");
        Location location = (Location) applicationContext.getBean("location");

        location.setLocation_name("西华大学xi大门");
        location.setLocation_longitude("123.123");
        location.setLocation_latitude("123.456");
        location.setLocation_type("公交车站");
        location.setArea("四川成都");
        location.setUser_id(3);


        locationDao.insertLocation(location);

        System.out.println(location.getLocation_id());
    }

    @Test
    public void testDeleteLocationByLongitudeAndLatitude() throws Exception{
        ILocationDao locationDao = (ILocationDao) applicationContext.getBean("locationMapper");
        Location location = (Location) applicationContext.getBean("location");

        location.setLocation_longitude("123.123");
        location.setLocation_latitude("123.123");
        location.setUser_id(1);

        locationDao.deleteLocationByLongitudeAndLatitude(location);
    }

    @Test
    public void testFindLocationByUser_id() throws Exception{
        ILocationDao locationDao = (ILocationDao) applicationContext.getBean("locationMapper");

        List<Location> locationList = locationDao.findLocationByUser_id(1);

        for (Location location : locationList){
            System.out.println(location.getLocation_id());
            System.out.println(location.getLocation_name());
            System.out.println(location.getLocation_longitude());
            System.out.println(location.getLocation_latitude());
            System.out.println(location.getLocation_type());
            System.out.println(location.getArea());
            System.out.println(location.getUser_id());
            System.out.println("-----------------------------------------");
        }
    }

    @Test
    public void testTotalLocation() throws Exception{
        ILocationDao locationDao = (ILocationDao) applicationContext.getBean("locationMapper");
        Location location = (Location) applicationContext.getBean("location");

        location.setLocation_longitude("123.123");
        location.setLocation_latitude("123.456");

        int result = 0;
        result = locationDao.totalLocation(location);

        System.out.println(result);
    }

    @Test
    public void testCheckLocationAndUser_id() throws Exception{
        ILocationDao locationDao = (ILocationDao) applicationContext.getBean("locationMapper");
        Location location = (Location) applicationContext.getBean("location");

        location.setLocation_longitude("123.123");
        location.setLocation_latitude("123.456");
        location.setUser_id(2);

        int result = 0;
        result = locationDao.checkLocationAndUser_id(location);

        System.out.println(result);
    }
}
