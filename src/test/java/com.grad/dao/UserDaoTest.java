package com.grad.dao;

import com.grad.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @program: busis
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-12 14:25
 **/
public class UserDaoTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {
        System.out.println(applicationContext);

        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");
        User user = userDao.findUserById(2);
        System.out.println("id: " + user.getUser_id());
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("birthday: " + user.getBirthday());
        System.out.println("head_portrail: " + user.getHead_portrail());
        System.out.println("gender: " + user.getGender());
        System.out.println("introduce: " + user.getIntroduce());
        System.out.println("telphone: " + user.getTelphone());
        System.out.println("authority: " + user.getAuthority());

    }

    @Test
    public void testFindUserByTelphone() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");
        String telphone = "13008142300";
        User user = userDao.findUserByTelphone(telphone);

        System.out.println("id: " + user.getUser_id());
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("birthday: " + user.getBirthday());
        System.out.println("head_portrail: " + user.getHead_portrail());
        System.out.println("gender: " + user.getGender());
        System.out.println("introduce: " + user.getIntroduce());
        System.out.println("telphone: " + user.getTelphone());
        System.out.println("authority: " + user.getAuthority());

    }

    @Test
    public void testFindUserByUsernameAndPassword() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");
        User temp = (User) applicationContext.getBean("user");

        temp.setUsername("Bob");
        temp.setPassword("123123");

        User user = userDao.findUserByUsernameAndPassword(temp);

        System.out.println("id: " + user.getUser_id());
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("birthday: " + user.getBirthday());
        System.out.println("head_portrail: " + user.getHead_portrail());
        System.out.println("gender: " + user.getGender());
        System.out.println("introduce: " + user.getIntroduce());
        System.out.println("telphone: " + user.getTelphone());
        System.out.println("authority: " + user.getAuthority());
    }




    @Test
    public void testMatchByUsernameAndPassword() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");

        User user = (User) applicationContext.getBean("user");
        user.setUsername("Bob");
        user.setPassword("123123");

        int res = userDao.matchByUsernameAndPassword(user);
        System.out.println(res);
    }

    @Test
    public void testMatchByTelphoneAndPassword() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");

        User user = (User) applicationContext.getBean("user");
        user.setTelphone("13008142300");
        user.setPassword("123123");

        int res = userDao.matchByTelphoneAndPassword(user);
        System.out.println(res);
    }

    @Test
    public void testInsertUser() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");
        User user = (User) applicationContext.getBean("user");

        user.setUsername("Alice");
        user.setTelphone("13008142301");
        user.setBirthday(new Date());
        user.setHead_portrail("1.jpg");
        user.setGender('0');
        user.setPassword("123456");
        user.setIntroduce("I am a good girl");

        userDao.insertUser(user);

        System.out.println(user.getUser_id());
    }

    @Test
    public void testQueryTelphone() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");
        String telphone = "13008142300";

        int result = userDao.queryTelphone(telphone);
        System.out.println(result);
    }


    @Test
    public void testModifyPassword() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");
        User user = (User) applicationContext.getBean("user");
        String password = "123123";
        int user_id = 4;

        user.setUser_id(user_id);
        user.setPassword(password);

        userDao.modifyPassword(user);

        User result = userDao.findUserById(user_id);

        System.out.println(result.getPassword());
    }

    @Test
    public void testModifyUsername() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");
        User user = (User) applicationContext.getBean("user");
        String username = "Marry";
        int user_id = 4;

        user.setUser_id(user_id);
        user.setUsername(username);

        userDao.modifyUsername(user);

        User result = userDao.findUserById(user_id);

        System.out.println(result.getUsername());
    }

    @Test
    public void testModifyHead_portrail() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");
        User user = (User) applicationContext.getBean("user");
        String head_portrail = "1.jpg";
        int user_id = 4;

        user.setUser_id(user_id);
        user.setHead_portrail(head_portrail);

        userDao.modifyHead_portrail(user);

        User result = userDao.findUserById(user_id);

        System.out.println(result.getHead_portrail());
    }

    @Test
    public void testModifyGender() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");
        User user = (User) applicationContext.getBean("user");
        char gender = '1';
        int user_id = 4;

        user.setUser_id(user_id);
        user.setGender(gender);

        userDao.modifyGender(user);

        User result = userDao.findUserById(user_id);

        System.out.println(result.getGender());
    }

    @Test
    public void testModifyBirthday() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");
        User user = (User) applicationContext.getBean("user");
        int user_id = 4;

        user.setUser_id(user_id);
        user.setBirthday(new Date());

        userDao.modifyBirthday(user);

        User result = userDao.findUserById(user_id);

        System.out.println(result.getBirthday());
    }

    @Test
    public void testModifyIntroduce() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");
        User user = (User) applicationContext.getBean("user");
        String introduce = "this is test";
        int user_id = 4;

        user.setUser_id(user_id);
        user.setIntroduce(introduce);

        userDao.modifyIntroduce(user);

        User result = userDao.findUserById(user_id);

        System.out.println(result.getIntroduce());
    }

    @Test
    public void testModifyTelphone() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");
        User user = (User) applicationContext.getBean("user");
        String telphone = "13008142302";
        int user_id = 4;

        user.setUser_id(user_id);
        user.setTelphone(telphone);

        userDao.modifyTelphone(user);

        User result = userDao.findUserById(user_id);

        System.out.println(result.getTelphone());
    }

    @Test
    public void testModifyAuthority() throws Exception{
        IUserDao userDao = (IUserDao) applicationContext.getBean("userMapper");
        User user = (User) applicationContext.getBean("user");
        char authority = '2';
        int user_id = 4;

        user.setUser_id(user_id);
        user.setAuthority(authority);

        userDao.modifyAuthority(user);

        User result = userDao.findUserById(user_id);

        System.out.println(result.getAuthority());
    }
}
