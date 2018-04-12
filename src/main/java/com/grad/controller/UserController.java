package com.grad.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.grad.dto.ModifyUserDto;
import com.grad.dto.UserBaseInformationDto;
import com.grad.entity.User;
import com.grad.service.IUserService;
import com.grad.util.*;
import com.grad.vo.SmsVo;
import com.grad.vo.UserApiVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: busis
 * @description: User相关操作API类，
 * @author: Mr.Chen
 * @create: 2018-03-13 14:42
 **/

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private IUserService userService;


    //无参构造
    public UserController(){

    }

    /**
     * 通过用户账户（电话号码/用户名）进行登录验证并返回用户基本信息
     * @param account 用户账户（电话号码或用户名）
     * @param password  用户密码
     * @return  用户信息JSON字符串
     *          user_id：用户登录成功返回用户ID，登录失败返回-1
     *          username：用户姓名
     *          password：用户密码（鉴于安全，一般为空）
     *          gender：用户性别
     *          birthday：用户出生日期
     *          head_portrail：用户头像图片路径
     *          introduce：用户介绍
     *          telphone：用户电话号码
     *          authority: 用户权限等级
     *          （注：若登录失败，user_id为-1，其余参数为默认值）
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = {RequestMethod.POST,RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String loginByAccountAndPassword(@RequestParam String account,@RequestParam String password) throws Exception{
        User resultUser = new User();
        UserApiVo userApiVo = new UserApiVo();

        userApiVo.setMessage("说明：");

        UserApiVo loginResult = userService.loginByAccountAndPassword(account,password);
        loginResult.setMessage(userApiVo.getMessage() + loginResult.getMessage());

        if(loginResult.getCode() == 1){
            //表示利用电话号码和密码进行成功登录
            resultUser = userService.getUserByTelphone(account).getUser();
        } else if (loginResult.getCode() == 2){
            //表示通过用户名和密码进行成功登录
            resultUser = userService.getUserByUsernameAndPassword(account,password).getUser();
            loginResult.setCode(1);
        } else {
            //登录失败
            resultUser.setUser_id(-1);
            loginResult.setCode(0);
        }

        resultUser = SimpleUtil.hideSensitiveInformation(resultUser);

        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setPrettyPrinting();        //格式化（仅用于开发阶段）
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();

        String resultJson = gson.toJson(resultUser);

        if(loginResult.getCode() == 0){
            resultJson = "";
        }

        return ApiFormatUtil.apiFormat(loginResult.getCode(),loginResult.getMessage(),resultJson);
    }


    /**
     * 用户注册
     * @param userBaseInformationDto
     *          username：用户姓名
     *          password：用户密码
     *          telphone：用户电话号码
     *          gender：用户性别
     *          birthday: 用户出生日期（yyyy-MM-dd）
     *          introduce: 用户备注
     * @return  用户基本信息
     *          user_id：用户登录成功返回用户ID，登录失败返回-1
     *          username：用户姓名
     *          password：用户密码（鉴于安全，一般为空）
     *          gender：用户性别
     *          birthday：用户出生日期
     *          head_portrail：用户头像图片路径
     *          introduce：用户介绍
     *          telphone：用户电话号码
     *          authority: 用户权限等级
     *          （注：若注册成功，返回值均为数据库中查询当前注册用户所得。若注册失败，user_id为-1，其他值为原值）
     */
    @RequestMapping(value = "/register",method = {RequestMethod.POST,RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String registerUser(UserBaseInformationDto userBaseInformationDto) throws Exception {
        User tempUser = new User();
        User resultUser = new User();
        boolean check = true;
        int resultId = -1;
        UserApiVo userApiVo = new UserApiVo();

        //初始化结果说明
        userApiVo.setMessage("说明：");

        //必填项检查
        if (userBaseInformationDto.getUsername() == "" || userBaseInformationDto.getUsername() == null){
            check = false;
            userApiVo.setMessage(userApiVo.getMessage() + "用户名不能为空！");
        }
        if(userBaseInformationDto.getTelphone() == "" || userBaseInformationDto.getTelphone() == null){
            check = false;
            userApiVo.setMessage(userApiVo.getMessage() + "电话号码不能为空！");
        }
        if (userBaseInformationDto.getPassword() == "" || userBaseInformationDto.getPassword() == null){
            check = false;
            userApiVo.setMessage(userApiVo.getMessage() + "密码不能为空！");
        }

        if (check == false){
            //缺少必填项
            userApiVo.setCode(0);
        } else {
            //填充数据，并检验数据合法性
            //检验username长度
            if(userBaseInformationDto.getUsername().length() < 10 || userBaseInformationDto.getUsername().length() < 2){
                tempUser.setUsername(userBaseInformationDto.getUsername());
            } else {
                //username数据长度不合法
                check = false;
                userApiVo.setMessage(userApiVo.getMessage() + "用户名应为2至10个字符！");
            }
            //验证手机号码是否合法
            if (TelphoneCheckUtil.isPhoneLegal(userBaseInformationDto.getTelphone())){
                tempUser.setTelphone(userBaseInformationDto.getTelphone());
            } else {
                check = false;
                userApiVo.setMessage(userApiVo.getMessage() + "电话号码非法！");
            }
            //检验密码长度是否合法
            if (userBaseInformationDto.getPassword().length() < 20 && userBaseInformationDto.getPassword().length() >= 6){
                tempUser.setPassword(userBaseInformationDto.getPassword());
            } else {
                //数据不合法
                check = false;
                userApiVo.setMessage(userApiVo.getMessage() + "密码应为6至20个字符！");
            }

            //判断必填项是否合法结果
            if (check == false){
                //数据非法
                userApiVo.setCode(0);

            } else {
                //必填项合法，填充其他信息
                if (userBaseInformationDto.getBirthday() != null && userBaseInformationDto.getBirthday() != null){
                    //将字符串转换为Date
                    tempUser.setBirthday(GetDateByStringUtils.getDate(userBaseInformationDto.getBirthday()));
                }
                if (userBaseInformationDto.getGender() != "" && userBaseInformationDto.getGender() != null){
//                    tempUser.setGender((char) user.getGender().indexOf(1));
                    if (userBaseInformationDto.getGender().equals("1")){
                        tempUser.setGender('1');
                    } else {
                        tempUser.setGender('0');
                    }
                } else {
                    //用户注册时未填写性别
                    tempUser.setGender(' ');
                }
                if (userBaseInformationDto.getIntroduce() != "" && userBaseInformationDto.getIntroduce() != null){
                    tempUser.setIntroduce(userBaseInformationDto.getIntroduce());
                }
            }
        }

        if (check == false){
            //存在不合法数据
            userApiVo.setCode(0);

            resultId = -1;      //标识注册失败
            resultUser.setUser_id(resultId);
            resultUser.setUsername(userBaseInformationDto.getUsername());
            resultUser.setIntroduce(userBaseInformationDto.getIntroduce());
//            resultUser.setGender((char) user.getGender().indexOf(1));
            if (userBaseInformationDto.getGender() != null){
                if (userBaseInformationDto.getGender().equals("1")){
                    tempUser.setGender('1');
                } else {
                    tempUser.setGender('0');
                }
            }
            if (userBaseInformationDto.getBirthday() != null){
                resultUser.setBirthday(GetDateByStringUtils.getDate(userBaseInformationDto.getBirthday()));
            }
            resultUser.setPassword(userBaseInformationDto.getPassword());
            resultUser.setTelphone(userBaseInformationDto.getTelphone());
        } else {
            //进行注册操作
            userApiVo = userService.registerUser(tempUser);
            if (userApiVo.getCode() == 0){
                //注册失败

            } else {
                //注册成功
                //重新从数据库中查询数据
                resultUser = userService.getUserById(userApiVo.getUser().getUser_id()).getUser();
                userApiVo.setMessage("注册成功！");
            }


        }

        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setPrettyPrinting();        //格式化（仅用于开发阶段）
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();

        resultUser = SimpleUtil.hideSensitiveInformation(resultUser);

        String resultJson = gson.toJson(resultUser);

        if(userApiVo.getCode() == 0){
            //注册失败
            resultJson = "";
        }

        return ApiFormatUtil.apiFormat(userApiVo.getCode(),userApiVo.getMessage(),resultJson);
    }


    /**
     * 修改用户基本信息
     * @param modifyUserDto
     *          user_id: 用户ID
     *          username：用户姓名
     *          password：用户密码
     *          telphone：用户电话号码
     *          gender：用户性别
     *          birthday: 用户出生日期（yyyy-MM-dd）
     *          introduce: 用户备注
     * @return 修改结果布尔值（修改成功返回true，反之为false）
     * @throws Exception
     */
    @RequestMapping(value = "/modify",method = {RequestMethod.POST,RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String modifyUserBaseInformation(ModifyUserDto modifyUserDto) throws Exception{
        User user = new User();
        User resultUser = new User();
        boolean result = false;
        UserApiVo userApiVo = new UserApiVo();
        String resultJson = "";

//        userApiVo.setMessage("说明：");

        if(modifyUserDto.getUser_id() <= 0){
            //user_id非法
            result = false;
            resultJson = "";
            userApiVo.setCode(0);
            userApiVo.setMessage("不存在此用户");
        }else {
            //填充数据
            user.setUser_id(modifyUserDto.getUser_id());
            if(modifyUserDto.getUsername() != null && modifyUserDto.getUsername() != ""){
                user.setUsername(modifyUserDto.getUsername());
            }
            if(modifyUserDto.getPassword() != null && modifyUserDto.getPassword() != ""){
                user.setPassword(modifyUserDto.getPassword());
            }
            if(modifyUserDto.getGender() != null && modifyUserDto.getGender() != ""){
                if (modifyUserDto.getGender().equals("1")){
                    //判断用户性别
                    user.setGender('1');
                } else {
                    //默认为0：女
                    user.setGender('0');
                }
            }

            if (modifyUserDto.getBirthday() != null && modifyUserDto.getBirthday() != ""){
                user.setBirthday(GetDateByStringUtils.getDate(modifyUserDto.getBirthday()));
            }
            if (modifyUserDto.getIntroduce() != null && modifyUserDto.getIntroduce() != ""){
                user.setIntroduce(modifyUserDto.getIntroduce());
            }
            if(modifyUserDto.getTelphone() != null && modifyUserDto.getIntroduce() != ""){
                user.setTelphone(modifyUserDto.getTelphone());
            }

            userApiVo = userService.updateUserInformation(user);

            GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setPrettyPrinting();        //格式化（仅用于开发阶段）
            gsonBuilder.setDateFormat("yyyy-MM-dd");
            Gson gson = gsonBuilder.create();

            resultUser = SimpleUtil.hideSensitiveInformation(userApiVo.getUser());

            resultJson = gson.toJson(resultUser);
        }
        if(userApiVo.getCode() == 0){
            resultJson = "";
        }

        return ApiFormatUtil.apiFormat(userApiVo.getCode(),userApiVo.getMessage(),resultJson);
    }


    /**
     * 修改用户头像图片
     * @param file   用户新头像图片文件
     * @param request
     * @param user_id   用户ID
     * @return  修改结果
     */
    @RequestMapping(value = "/modify/head_portrail",method = {RequestMethod.POST,RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String modifyHead_portrail(@RequestParam(value = "file",required = false)MultipartFile file,
                                      HttpServletRequest request, int user_id) throws Exception {

        //未进行测试

        User user = new User();
        boolean result = false;
        UserApiVo userApiVo = new UserApiVo();

        userApiVo.setMessage("说明：");
        userApiVo.setUser(null);

        //将图片存储在服务器文件夹中，并返回文件路径
        String head_portrailResult = UploadHead_portrailUtil.uploadHead_portrail(file,request);

        //封装数据
        user.setUser_id(user_id);
        user.setHead_portrail(head_portrailResult.toString().trim());

//        System.out.println("-------------------------------");
//        System.out.println(head_portrailResult.toString().trim());
//        System.out.println("length:" + head_portrailResult.length());
//        System.out.println(user.getHead_portrail());
//        System.out.println("-------------------------------");

        //进行数据库更新
        userApiVo = userService.updateHead_portrail(user.getUser_id(),user.getHead_portrail());

        String resultJson = "";

//        if(userApiVo.getCode() == 0){
//            //修改头像失败
//            resultJson = "";
//        } else{
//            resultJson = userService.getUserById(user.getUser_id()).getUser().getHead_portrail().trim();
//        }

        return ApiFormatUtil.apiFormat(userApiVo.getCode(),userApiVo.getMessage(),resultJson);
    }


    /**
     * 修改其他用户权限
     * @param user_id   当前用户ID
     * @param modifyUser_id     欲修改权限用户的ID
     * @param modifyAuthority   新权限
     * @return 修改结果
     */
    @RequestMapping(value = "/modify/authority",method = {RequestMethod.POST,RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String modifyAuthority(int user_id,int modifyUser_id,char modifyAuthority) throws Exception {

        User user = new User();
        boolean result = false;
        UserApiVo userApiVo = new UserApiVo();

        user.setUser_id(user_id);

        userApiVo = userService.updateUserAuthority(user,modifyUser_id,modifyAuthority);

        String resultJson = "";

        return ApiFormatUtil.apiFormat(userApiVo.getCode(),userApiVo.getMessage(),resultJson);
    }


    /**
     * 发送短信验证码
     * @param telphone
     * @return  发送结果
     * @throws Exception
     */
    @RequestMapping(value = "/sms",method = {RequestMethod.POST,RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String sendSmsCode(String telphone) throws Exception{

        int resultCode = 0;
        String result = "";

        if (telphone != "" && telphone != null){
            //接收参数正确
            if(TelphoneCheckUtil.isPhoneLegal(telphone)){
                //电话号码格式正确
                SmsVo smsVo = IndustrySMS.execute(telphone);
                if (smsVo.getStatusCode().equals("00000")){
                    //短信发送成功
                    resultCode = 1;
                    result = "短信发送成功！";

                    //需要在此处添加session，用于时间校验


                } else {
                    //短信发送失败
                    resultCode = 0;
                    result = "短信发送失败！";
                }

            } else {
                result  = "电话号码无效！";
                resultCode = 0;
            }
        }else {
            //未接收到参数
            result = "未接收到电话号码数据！";
            resultCode = 0;
        }

        return ApiFormatUtil.apiFormat(resultCode,result,"");
    }

}
