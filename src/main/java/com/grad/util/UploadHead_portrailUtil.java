package com.grad.util;

import com.alibaba.fastjson.JSON;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @program: busis
 * @description: 上传头像图片到服务器，并返回图片存储路径
 * @author: Mr.Chen
 * @create: 2018-03-13 23:25
 **/
public class UploadHead_portrailUtil {

    public static String uploadHead_portrail(MultipartFile file, HttpServletRequest request){
        File targetFile = null;
        String msg = "";        //返回存储路径
        int code = 1;
        String fileName = file.getOriginalFilename();       //获取文件名后缀
        if(fileName != null && fileName != ""){
            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + request.getContextPath() + "/upload/imgs/";   //存储路径
            String path = request.getSession().getServletContext().getRealPath("upload/imgs");      //文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."),fileName.length());     //文件后缀
            fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;     //新的文件名

            //先判断文件是否存在
            String fileAdd = new SimpleDateFormat("yyyyMMdd").format(new Date());
            File file1 = new File(path + "/" + fileAdd);
            //如果文件夹不存在则创建
            if(!file1.exists() && !file1.isDirectory()){
                file1.mkdir();
            }
            targetFile = new File(file1,fileName);
            try {
                file.transferTo(targetFile);
//                msg = returnUrl + fileName;
                msg = returnUrl + fileAdd + "/" + fileName;
                code = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return JSON.toJSONString(msg);

        //注：需要在项目的webapp下创建upload文件，upload下创建imgs文件，否则存储不成功。也就会上传失败。

    }
}
