//package com.grad.service;
//
//import com.grad.entity.User;
//import com.grad.vo.UserApiVo;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * @program: busis
// * @description:
// * @author: Mr.Chen
// * @create: 2018-04-14 13:45
// **/
//public class AdminServiceTest {
//
//    private ApplicationContext applicationContext;
//
//    @Before
//    public void setApplicationContext(){
//        applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
//    }
//
//    @Test
//    public void testAddAdministrator() throws Exception{
//
//        User user = new User();
//        user.setUsername("Bob");
//        user.setTelphone("13008142305");
//
//        IAdminService adminService = (IAdminService) applicationContext.getBean("adminService");
//
//        UserApiVo userApiVo = adminService.addAdministrator(user);
//
//        System.out.println(userApiVo.getCode());
//        System.out.println(userApiVo.getMessage());
//        System.out.println(userApiVo.getUser().getPassword());
//    }
//
//}
