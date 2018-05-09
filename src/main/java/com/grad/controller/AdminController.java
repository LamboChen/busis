package com.grad.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.grad.dto.AdminGetUserDto;
import com.grad.dto.AnnouncementDto;
import com.grad.dto.DeleteUserDto;
import com.grad.dto.SuAdminApiDto;
import com.grad.entity.Announcement;
import com.grad.entity.Link;
import com.grad.entity.User;
import com.grad.service.IAdminService;
import com.grad.service.IAnnouncementService;
import com.grad.service.ILinkService;
import com.grad.service.IUserService;
import com.grad.util.ApiFormatUtil;
import com.grad.util.SimpleUtil;
import com.grad.vo.AnnouncementListVo;
import com.grad.vo.LinkApiVo;
import com.grad.vo.UserApiVo;
import com.grad.vo.UserListVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;

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

    @Resource
    private IAdminService adminService;

    @Resource
    private IAnnouncementService announcementService;

    public AdminController() {

    }


    /**
     * 通过用户名模糊查询用户基本信息
     *
     * @param username 用户名
     * @return 用户信息列表
     * @throws Exception
     */
    @RequestMapping(value = "/user/query/username", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String fuzzyQueryByUsername(String username) throws Exception {
        UserListVo userListVo = userService.fuzzyQueryByUsername(username);
        String result = "";
        if (userListVo != null) {
            result = SimpleUtil.userListToJson(userListVo.getUserArrayList());
        }
        return ApiFormatUtil.apiFormat(userListVo.getStatusCode(), userListVo.getMessage(),
                result);
    }


    /**
     * 添加链接
     *
     * @param link name : 链接名称
     *             url : 链接URL
     *             type : 链接类型
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/link/add", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String addLink(Link link) throws Exception {

        LinkApiVo linkApiVo = linkService.addLink(link);

        String resultJson = "";

        return ApiFormatUtil.apiFormat(linkApiVo.getCode(), linkApiVo.getMessage(), resultJson);
    }


    /**
     * 删除链接
     *
     * @param link name : 链接名称
     *             url : 链接URL
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/link/delete", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String deleteLink(Link link) throws Exception {
        int code = 1;
        String message = "删除成功！";
        String resultJson = "";

        linkService.deleteLink(link);

        return ApiFormatUtil.apiFormat(code, message, resultJson);
    }


    /**
     * 获取所有链接
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/link/getall", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getAllLink() throws Exception {
        LinkApiVo linkApiVo = linkService.getAll();

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String resultJson = gson.toJson(linkApiVo.getLinkArrayList());

        return ApiFormatUtil.apiFormat(linkApiVo.getCode(), linkApiVo.getMessage(), resultJson);
    }


    /**
     * 新增管理员
     *
     * @param suAdminApiDto su_id : 超级管理员ID(必填)
     *                      username : 新增管理员姓名
     *                      password : 新增管理员密码（默认123456）
     *                      telphone : 新增管理员电话号码
     *                      introduce ： 新增管理员介绍介绍
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/su/add", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String addAdministrator(SuAdminApiDto suAdminApiDto) throws Exception {
        //声明返回
        int resultCode = 1;
        String resultMessage = "";
        String resultObject = "";


        //校验参数是否传入成功
        if (suAdminApiDto == null) {
            //参数传入失败
            resultCode = 0;
            resultMessage += "未接收到参数！";
        } else {
            //校验必填项
            if (suAdminApiDto.getSu_id() <= 0) {
                //未传入超级管理员ID
                resultCode = 0;
                resultMessage += "未传入超级管理员ID！";
            }
            if (suAdminApiDto.getUsername() == null || suAdminApiDto.getUsername() == "") {
                //未传入管理员用户名
                resultCode = 0;
                resultMessage += "新增管理员用户名为空！";
            }
            if (suAdminApiDto.getTelphone() == null || suAdminApiDto.getTelphone() == "") {
                //未传入新增管理员电话号码
                resultCode = 0;
                resultMessage += "新增管理员用户电话号码为空！";
            }

            if (resultCode == 0) {
                //缺失必填项
                resultObject = "";
            } else {
                //校验超级管理员权限
                UserApiVo userApiVo = userService.getUserById(suAdminApiDto.getSu_id());

                if (userApiVo.getCode() == 0) {
                    //查询失败
                    resultCode = userApiVo.getCode();
                    resultMessage = userApiVo.getMessage();
                    resultObject = "";
                } else {
                    //校验是否具有超级管理员权限
                    User user = userApiVo.getUser();
                    if (user.getAuthority() == '1') {
                        //具有超级管理员权限
                        //填充新增管理员信息
                        User addAdmin = new User();
                        addAdmin.setUsername(suAdminApiDto.getUsername());
                        addAdmin.setTelphone(suAdminApiDto.getTelphone());
                        addAdmin.setIntroduce(suAdminApiDto.getIntroduce());
                        addAdmin.setPassword(suAdminApiDto.getPassword());

                        UserApiVo userApiVo1 = adminService.addAdministrator(addAdmin);
                        resultCode = userApiVo1.getCode();
                        resultMessage = userApiVo1.getMessage();

                        //格式化
                        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setPrettyPrinting();        //格式化（仅用于开发阶段）
                        gsonBuilder.setDateFormat("yyyy-MM-dd");
                        Gson gson = gsonBuilder.create();
                        User resultUser = SimpleUtil.hideSensitiveInformation(userApiVo1.getUser());

                        resultObject = gson.toJson(resultUser);

                    } else {
                        resultCode = 0;
                        resultMessage += "权限不足！";
                        resultObject = "";
                    }
                }
            }
        }
        return ApiFormatUtil.apiFormat(resultCode, resultMessage, resultObject);
    }


    /**
     * 删除用户
     *
     * @param deleteUserDto admin_id : 管理员ID
     *                      user_id : 待删除用户ID（管理员ID）
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/delete", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String deleteUser(DeleteUserDto deleteUserDto) throws Exception {
        int resultCode = 1;
        String resultMessage = "";

        //校验传入参数
        if (deleteUserDto == null) {
            resultCode = 0;
            resultMessage += "参数传入失败！";
        } else {

            //校验用户权限
            UserApiVo adminUserApiVo = userService.getUserById(deleteUserDto.getAdmin_id());
            UserApiVo deleteUserApiVo = userService.getUserById(deleteUserDto.getUser_id());

            if (adminUserApiVo.getCode() == 0) {
                resultCode = 0;
                resultMessage += adminUserApiVo.getMessage();
            }
            if (deleteUserApiVo.getCode() == 0) {
                resultCode = 0;
                resultMessage += deleteUserApiVo.getMessage();
            }

            if (resultCode == 0) {
                //输入用户有误

            } else {
                //获取数据库中查询到的用户
                User adminUser = adminUserApiVo.getUser();
                User userUser = deleteUserApiVo.getUser();

                //校验用户
                if (adminUser == null) {
                    resultCode = 0;
                    resultMessage += "管理员用户不存在！";
                }
                if (userUser == null) {
                    resultCode = 0;
                    resultMessage += "待查询用户不存在！";
                }

                if (resultCode == 0) {
                    //用户不存在

                } else {
                    //获取用户权限
                    char adminAuthority = adminUser.getAuthority();
                    char userAuthority = userUser.getAuthority();

                    if ((adminAuthority == '1' && userAuthority == '1') ||
                            adminAuthority == '2' && userAuthority != '3') {
                        resultCode = 0;
                        resultMessage += "用户权限不足！";
                    } else {
                        if (adminAuthority == '1' && userAuthority == '2') {
                            //执行删除管理员账户
                            User user = new User();
                            user.setUser_id(deleteUserDto.getUser_id());
                            adminService.deleteAdministrator(user);
                        } else {
                            //执行删除普通用户
                            User user = new User();
                            user.setUser_id(deleteUserDto.getUser_id());
                            adminService.deleteUser(user);
                        }
                        resultCode = 1;
                        resultMessage += "删除成功！";
                    }
                }
            }
        }
        return ApiFormatUtil.apiFormat(resultCode, resultMessage, "");
    }


    /**
     * 新增普通用户
     *
     * @param suAdminApiDto su_id : 管理员ID(必填)
     *                      username : 新增用户姓名
     *                      password : 新增用户密码（默认123456）
     *                      telphone : 新增用户电话号码
     *                      introduce ： 新增用户介绍介绍
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/add", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String addUser(SuAdminApiDto suAdminApiDto) throws Exception {
        //声明返回
        int resultCode = 1;
        String resultMessage = "";
        String resultObject = "";


        //校验参数是否传入成功
        if (suAdminApiDto == null) {
            //参数传入失败
            resultCode = 0;
            resultMessage += "未接收到参数！";
        } else {
            //校验必填项
            if (suAdminApiDto.getSu_id() <= 0) {
                //未传入超级管理员ID
                resultCode = 0;
                resultMessage += "未传入管理员ID！";
            }
            if (suAdminApiDto.getUsername() == null || suAdminApiDto.getUsername() == "") {
                //未传入管理员用户名
                resultCode = 0;
                resultMessage += "新增用户用户名为空！";
            }
            if (suAdminApiDto.getTelphone() == null || suAdminApiDto.getTelphone() == "") {
                //未传入新增管理员电话号码
                resultCode = 0;
                resultMessage += "新增用户电话号码为空！";
            }

            if (resultCode == 0) {
                //缺失必填项
                resultObject = "";
            } else {
                //校验管理员权限
                UserApiVo userApiVo = userService.getUserById(suAdminApiDto.getSu_id());

                if (userApiVo.getCode() == 0) {
                    //查询失败
                    resultCode = userApiVo.getCode();
                    resultMessage = userApiVo.getMessage();
                    resultObject = "";
                } else {
                    //校验是否具有管理员权限
                    User user = userApiVo.getUser();
                    if (user.getAuthority() == '1' || user.getAuthority() == '2') {
                        //具有超级管理员权限
                        //填充新增管理员信息
                        User addUser = new User();
                        addUser.setUsername(suAdminApiDto.getUsername());
                        addUser.setTelphone(suAdminApiDto.getTelphone());
                        addUser.setIntroduce(suAdminApiDto.getIntroduce());
                        addUser.setPassword(suAdminApiDto.getPassword());

                        UserApiVo userApiVo1 = adminService.addUser(addUser);
                        resultCode = userApiVo1.getCode();
                        resultMessage = userApiVo1.getMessage();

                        //格式化
                        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setPrettyPrinting();        //格式化（仅用于开发阶段）
                        gsonBuilder.setDateFormat("yyyy-MM-dd");
                        Gson gson = gsonBuilder.create();
                        User resultUser = SimpleUtil.hideSensitiveInformation(userApiVo1.getUser());

                        resultObject = gson.toJson(resultUser);

                    } else {
                        resultCode = 0;
                        resultMessage += "权限不足！";
                        resultObject = "";
                    }
                }
            }
        }
        return ApiFormatUtil.apiFormat(resultCode, resultMessage, resultObject);
    }


    /**
     * 获取全部用户
     *
     * @param adminGetUserDto admin_id ： 管理员ID
     *                        authority : 用户权限
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/getall", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getAllUser(AdminGetUserDto adminGetUserDto) throws Exception {
        //初始化返回
        int resultCode = 1;
        String resultMessage = "";
        ArrayList<User> resultUser = null;

        //校验是否接收到参数
        if (adminGetUserDto == null) {
            resultCode = 0;
            resultMessage += "未接收到参数！";
        } else {
            //校验用户是否存在
            UserApiVo queryAdmin = userService.getUserById(adminGetUserDto.getAdmin_id());
            if (queryAdmin.getCode() == 0) {
                //未获取到用户
                resultCode = queryAdmin.getCode();
                resultMessage = queryAdmin.getMessage();
                resultUser = null;
            } else {
                //校验用户权限
                User adminUser = queryAdmin.getUser();
                if (adminUser == null) {
                    //用户不存在
                    resultCode = 0;
                    resultMessage += "管理员用户不存在！";
                    resultUser = null;
                } else {
                    char adminAuthority = adminUser.getAuthority();
                    char queryAuthority = adminGetUserDto.getAuthority();
                    if ((adminAuthority == '2' && queryAuthority == '1') ||
                            adminAuthority == '3') {
                        //用户权限不足
                        resultCode = 0;
                        resultMessage += "权限不足！";
                        resultUser = null;
                    } else {
                        if (queryAuthority != '1' && queryAuthority != '2' && queryAuthority != '3') {
                            //不存在此类用户
                            resultCode = 0;
                            resultMessage += "不存在此类用户！";
                            resultUser = null;
                        } else {
                            UserListVo userListVo = adminService.getUserByAuthority(queryAuthority);
                            resultCode = userListVo.getStatusCode();
                            resultMessage += userListVo.getMessage();
                            resultUser = userListVo.getUserArrayList();
                        }
                    }
                }
            }
        }

        String resultObject = "";
        if (resultUser == null) {
            //获取到用户为空

        } else {
            GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setPrettyPrinting();        //格式化（仅用于开发阶段）
            gsonBuilder.setDateFormat("yyyy-MM-dd");
            Gson gson = gsonBuilder.create();

            ArrayList<User> resultJson = new ArrayList<>();
            for (User user : resultUser) {
                resultJson.add(SimpleUtil.hideSensitiveInformation(user));
            }

            resultObject = gson.toJson(resultJson);
        }

        return ApiFormatUtil.apiFormat(resultCode, resultMessage, resultObject);
    }

    /**
     * 获取公告信息列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/announce/get", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getAnnouncement() throws Exception {
        char delete_or = '0';

        AnnouncementListVo announcementListVo = announcementService.getAnnouncement(delete_or);

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String result = "";
        if (announcementListVo.getAnnouncementArrayList() != null) {
            result = gson.toJson(announcementListVo.getAnnouncementArrayList());
        }
        return ApiFormatUtil.apiFormat(announcementListVo.getCode(), announcementListVo.getMessage(), result);
    }


    /**
     * 添加公告
     *
     * @param announcementDto title : 公告标题
     *                        content ： 公告内容
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/announce/add", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String addAnnouncement(AnnouncementDto announcementDto) throws Exception {
        int code = 1;
        String message = "";

        //校验参数接收情况
        if (announcementDto == null) {
            code = 0;
            message += "传入参数为空！";
        } else {
            //对参数进行校验并处理前后空格
            String title = announcementDto.getTitle();
            String content = announcementDto.getContent();

            if (title == null || title == "") {
                code = 0;
                message += "标题不能为空！";
            } else {
                title = title.trim();
            }

            if (content == null || content == "") {
                code = 0;
                message += "内容不能为空！";
            } else {
                content = content.trim();
            }

            if (code != 0) {
                Announcement announcement = new Announcement();
                announcement.setTitle(title);
                announcement.setContent(content);
                announcement.setUser_id(announcementDto.getUser_id());
                AnnouncementListVo announcementListVo = announcementService.insertAnnouncement(announcement);
                code = announcementListVo.getCode();
                message = announcementListVo.getMessage();
            }
        }
        return ApiFormatUtil.apiFormat(code, message, "");
    }


    /**
     * 删除公告
     *
     * @param announcement_id 公告ID
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/announce/delete", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String deleteAnnouncement(int announcement_id) throws Exception {
        AnnouncementListVo announcementListVo = announcementService.deleteAnnouncement(announcement_id);
        return ApiFormatUtil.apiFormat(announcementListVo.getCode(), announcementListVo.getMessage(), "");
    }


}
