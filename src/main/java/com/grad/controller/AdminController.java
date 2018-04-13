package com.grad.controller;

import com.grad.service.IUserService;
import com.grad.util.ApiFormatUtil;
import com.grad.vo.UserListVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @program: busis
 * @description: 供管理员调用的接口：主要是进行用户管理、信息维护等
 * @author: Mr.Chen
 * @create: 2018-04-12 14:03
 **/

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Resource
    private IUserService userService;

    public AdminController(){

    }


    /**
     * 通过用户名模糊查询用户基本信息
     * @param username 用户名
     * @return  用户信息列表
     * @throws Exception
     */
    @RequestMapping(value = "/user/query/username",method = {RequestMethod.POST,RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String fuzzyQueryByUsername(String username) throws Exception{

        UserListVo userListVo = userService.fuzzyQueryByUsername(username);

        return ApiFormatUtil.apiFormat(userListVo.getStatusCode(),userListVo.getMessage(),
                userListVo.getUserArrayList());
    }





}
