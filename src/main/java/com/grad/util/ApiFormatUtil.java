package com.grad.util;

import net.sf.json.JSONObject;

/**
 * @program: busis
 * @description: API格式化工具类
 * @author: Mr.Chen
 * @create: 2018-03-22 13:56
 **/
public class ApiFormatUtil {

    public static String apiFormat(int code,String message,Object object){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("code",code);
        jsonObject.put("message",message);
        jsonObject.put("data",object);

        return jsonObject.toString();
    }
}
