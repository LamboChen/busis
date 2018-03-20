package com.grad.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: xhuApp
 * @description: 解析字符串为时间
 * @author: Mr.Chen
 * @create: 2018-03-07 10:45
 **/
public class GetDateByStringUtils {

    public static Date getDate(String data){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date result = new Date();
        try {
            result = simpleDateFormat.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Date getDateTime(String data){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date result = new Date();
        try {
            result = simpleDateFormat.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
