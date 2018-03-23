//package com.grad.service;
//
//import com.grad.entity.Location;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.List;
//
///**
// * @program: busis
// * @description:
// * @author: Mr.Chen
// * @create: 2018-03-14 21:13
// **/
//public class LocationServiceTest {
//
//    private ApplicationContext applicationContext;
//
//    @Before
//    public void setUp(){
//        applicationContext = new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
//    }
//
//    @Test
//    public void testAddLocation() throws Exception{
//        ILocationService locationService = (ILocationService) applicationContext.getBean("locationService");
//        Location location = (Location) applicationContext.getBean("location");
//
//        location.setLocation_name("西华大学xi大门");
//        location.setLocation_longitude("123.123");
//        location.setLocation_latitude("123.456");
//        location.setLocation_type("公交车站");
//        location.setArea("四川成都");
//        location.setUser_id(4);
//
//        int result = 0;
//        result = locationService.addLocation(location);
//
//        System.out.println(result);
//    }
//
//    @Test
//    public void testDeleteLocation() throws Exception{
//        ILocationService locationService = (ILocationService) applicationContext.getBean("locationService");
//        Location location = (Location) applicationContext.getBean("location");
//
//        location.setLocation_name("西华大学xi大门");
//        location.setLocation_longitude("123.123");
//        location.setLocation_latitude("123.456");
//        location.setLocation_type("公交车站");
//        location.setUser_id(1);
//
//        locationService.deleteLocation(location);
//    }
//
//    @Test
//    public void testFindLocationByUser_id() throws Exception{
//        ILocationService locationService = (ILocationService) applicationContext.getBean("locationService");
//        int user_id = 2;
//
//        List<Location> locationList = locationService.findLocationByUser_id(user_id);
//
//        for (Location location : locationList){
//            System.out.println(location.getLocation_id());
//            System.out.println(location.getLocation_name());
//            System.out.println(location.getLocation_longitude());
//            System.out.println(location.getLocation_latitude());
//            System.out.println(location.getLocation_type());
//            System.out.println(location.getArea());
//            System.out.println(location.getUser_id());
//            System.out.println("-----------------------------------------");
//        }
//    }
//
//}
