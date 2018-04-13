package com.grad.controller;

import com.grad.entity.Link;
import com.grad.service.ILinkService;
import com.grad.service.IUserService;
import com.grad.util.ApiFormatUtil;
import com.grad.vo.LinkApiVo;
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

    @Resource
    private ILinkService linkService;

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


    /**
     * 添加链接
     * @param link
     *      name : 链接名称
     *      url : 链接URL
     *      type : 链接类型
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/link/add",method = {RequestMethod.POST,RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String addLink(Link link) throws Exception{

        LinkApiVo linkApiVo = linkService.addLink(link);

        String resultJson = "";

        return ApiFormatUtil.apiFormat(linkApiVo.getCode(),linkApiVo.getMessage(),resultJson);
    }


    /**
     *  删除链接
     * @param link
     *      name : 链接名称
     *      url : 链接URL
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/link/delete",method = {RequestMethod.POST,RequestMethod.GET},
        produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String deleteLink(Link link) throws Exception{
        int code = 1;
        String message = "删除成功！";
        String resultJson = "";

        linkService.deleteLink(link);

        return ApiFormatUtil.apiFormat(code,message,resultJson);
    }






}
