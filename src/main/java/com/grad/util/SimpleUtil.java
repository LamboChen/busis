package com.grad.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.grad.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: busis
 * @description: 一些简单的工具方法
 * @author: Mr.Chen
 * @create: 2018-03-21 17:50
 **/
public class SimpleUtil {

    /**
     * 隐藏用户敏感信息
     * @param user
     * @return
     */
    public static User hideSensitiveInformation(User user){

        if (user != null){
            if(user.getPassword() == null || user.getPassword() != ""){
                user.setPassword(" ");
            }

            //判空处理
            if(user.getBirthday() == null){

            }
            if (user.getHead_portrail() == null){
                user.setHead_portrail(" ");
            }
            if (user.getIntroduce() == null){
                user.setIntroduce(" ");
            }
            if (user.getGender() != '1' && user.getGender() != '0'){
                user.setGender(' ');
            }
            if (user.getAuthority()!='1' && user.getAuthority()!='2' && user.getAuthority()!='3'){
                user.setAuthority(' ');
            }

        }


        return user;
    }


    public static String userToJson(User user) throws Exception{
        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setPrettyPrinting();        //格式化（仅用于开发阶段）
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();

        user = SimpleUtil.hideSensitiveInformation(user);

        String resultJson = gson.toJson(user);
        return resultJson;
    }


    public static String userListToJson(List<User> userList) throws Exception{
        List<String> stringList = new ArrayList<>();

        for (User user : userList){
            String temp = userToJson(user);
            stringList.add(temp);
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String result = gson.toJson(stringList);
        return result;
    }


}
