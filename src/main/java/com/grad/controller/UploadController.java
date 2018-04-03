package com.grad.controller;

import com.grad.util.UploadHead_portrailUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: busis
 * @description: 测试上传图片
 * @author: Mr.Chen
 * @create: 2018-04-02 19:23
 **/

@Controller
@RequestMapping(value = "/photo")
public class UploadController {

    public UploadController(){}

    @RequestMapping(value = "/upload",method = {RequestMethod.POST,RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String modifyHead_portrail(@RequestParam(value = "file",required = false)MultipartFile image,
                                      HttpServletRequest request) throws Exception {

        //将图片存储在服务器文件夹中，并返回文件路径
        String result = UploadHead_portrailUtil.uploadHead_portrail(image,request);

        System.out.println("this is a test.");

//        File targetFile = null;
//        String msg = "";        //返回存储路径
//        int code = 1;
//        String fileName = file.getOriginalFilename();       //获取文件名(带后缀）
//        if(fileName != null && fileName != ""){
//            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
//                    + request.getContextPath() + "/upload/imgs/";   //存储路径
//            String path = request.getSession().getServletContext().getRealPath("upload/imgs");      //文件存储位置
//            String fileF = fileName.substring(fileName.lastIndexOf("."),fileName.length());     //文件后缀
//            fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;     //新的文件名
//
//            //先判断文件是否存在
//            String fileAdd = new SimpleDateFormat("yyyyMMdd").format(new Date());
//            File file1 = new File(path + "/" + fileAdd);
//            //如果文件夹不存在则创建
//            if(!file1.exists() && !file1.isDirectory()){
//                file1.mkdir();
//            }
//            targetFile = new File(file1,fileName);
//            try {
//                file.transferTo(targetFile);
////                msg = returnUrl + fileName;
//                msg = returnUrl + fileAdd + "/" + fileName;
//                code = 0;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return JSON.toJSONString(msg);

        return result;
    }

}
