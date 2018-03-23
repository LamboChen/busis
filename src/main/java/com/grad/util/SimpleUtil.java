package com.grad.util;

import com.grad.entity.User;

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
}
