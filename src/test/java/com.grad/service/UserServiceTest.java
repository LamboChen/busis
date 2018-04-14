package com.grad.service;

import com.grad.entity.User;
import com.grad.vo.UserApiVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @program: busis
 * @description: IUserService接口及其实现类测试类
 * @author: Mr.Chen
 * @create: 2018-03-13 13:37
 **/
public class UserServiceTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
    }

    @Test
    public void testLoginByAccountAndPassword() throws Exception{
        IUserService userService = (IUserService) applicationContext.getBean("userService");
        String account = "13008142300";
        String password = "123123";
        UserApiVo result = userService.loginByAccountAndPassword(account,password);
//        System.out.println(result);
    }

    @Test
    public void testGetUserByTelphone() throws Exception{
        IUserService userService = (IUserService) applicationContext.getBean("userService");
        String telphone = "13008142300";

        UserApiVo user = userService.getUserByTelphone(telphone);

//        System.out.println("id: " + user.getUser_id());
//        System.out.println("username: " + user.getUsername());
//        System.out.println("password: " + user.getPassword());
//        System.out.println("birthday: " + user.getBirthday());
//        System.out.println("head_portrail: " + user.getHead_portrail());
//        System.out.println("gender: " + user.getGender());
//        System.out.println("introduce: " + user.getIntroduce());
//        System.out.println("telphone: " + user.getTelphone());
//        System.out.println("authority: " + user.getAuthority());

    }

    @Test
    public void testGetUserByUsernameAndPassword() throws Exception{
        IUserService userService = (IUserService) applicationContext.getBean("userService");
        String username = "Bob";
        String password = "123123";

        UserApiVo user = userService.getUserByUsernameAndPassword(username,password);

//        System.out.println("id: " + user.getUser_id());
//        System.out.println("username: " + user.getUsername());
//        System.out.println("password: " + user.getPassword());
//        System.out.println("birthday: " + user.getBirthday());
//        System.out.println("head_portrail: " + user.getHead_portrail());
//        System.out.println("gender: " + user.getGender());
//        System.out.println("introduce: " + user.getIntroduce());
//        System.out.println("telphone: " + user.getTelphone());
//        System.out.println("authority: " + user.getAuthority());

    }

    @Test
    public void testGetUserById() throws Exception{
        IUserService userService = (IUserService) applicationContext.getBean("userService");
        int user_id = 1;
        int user_id1 = 21;

        UserApiVo user = userService.getUserById(1);
        UserApiVo userApiVo = userService.getUserById(21);

        System.out.println("user == userApiVo:" + (user == userApiVo));

        System.out.println("--------------------------");

        System.out.println("id: " + user.getUser().getUser_id());
        System.out.println("username: " + user.getUser().getUsername());
        System.out.println("password: " + user.getUser().getPassword());
        System.out.println("birthday: " + user.getUser().getBirthday());
        System.out.println("head_portrail: " + user.getUser().getHead_portrail());
        System.out.println("gender: " + user.getUser().getGender());
        System.out.println("introduce: " + user.getUser().getIntroduce());
        System.out.println("telphone: " + user.getUser().getTelphone());
        System.out.println("authority: " + user.getUser().getAuthority());

        System.out.println("---------------------------------------------");
        System.out.println("id: " + userApiVo.getUser().getUser_id());
        System.out.println("username: " + userApiVo.getUser().getUsername());
        System.out.println("password: " + userApiVo.getUser().getPassword());
        System.out.println("birthday: " + userApiVo.getUser().getBirthday());
        System.out.println("head_portrail: " + userApiVo.getUser().getHead_portrail());
        System.out.println("gender: " + userApiVo.getUser().getGender());
        System.out.println("introduce: " + userApiVo.getUser().getIntroduce());
        System.out.println("telphone: " + userApiVo.getUser().getTelphone());
        System.out.println("authority: " + userApiVo.getUser().getAuthority());

    }

    @Test
    public void testRegisterUser() throws Exception{
        IUserService userService = (IUserService) applicationContext.getBean("userService");
//        IUserService userService = new UserServiceImpl();
        User user = (User) applicationContext.getBean("user");
//        User user = new User();


        user.setUsername("Alice");
        user.setTelphone("13008142301");
        user.setBirthday(new Date());
        user.setHead_portrail("1.jpg");
        user.setPassword("123456");
        user.setIntroduce("I am a good girl");

//        int result = 0;
        UserApiVo result = userService.registerUser(user);

        System.out.println(result);
    }

    @Test
    public void testUpdateUserInformation() throws Exception{
        IUserService userService = (IUserService) applicationContext.getBean("userService");
        User user = (User) applicationContext.getBean("user");
        boolean result = false;

        user.setUser_id(4);
        user.setUsername("Alice");
        user.setTelphone("13008142301");
        user.setBirthday(new Date(1));
        user.setHead_portrail("2.jpg");
        user.setGender('1');
        user.setPassword("123456");
        user.setIntroduce("I am a good girl");

//        result = userService.updateUserInformation(user);

        System.out.println(result);
    }

    @Test
    public void testUpdateUserAuthority() throws Exception{
        IUserService userService = (IUserService) applicationContext.getBean("userService");
        User user = (User) applicationContext.getBean("user");
        int user_id = 4;
        char newAuthority = '3';

        user.setUser_id(1);

        boolean result = false;
//        result = userService.updateUserAuthority(user,user_id,newAuthority);

        System.out.println(result);

    }
}
