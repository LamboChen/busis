package com.grad.service.impl;

import com.grad.dao.IUserDao;
import com.grad.entity.User;
import com.grad.service.IAdminService;
import com.grad.service.IUserService;
import com.grad.util.TelphoneCheckUtil;
import com.grad.vo.UserApiVo;
import com.grad.vo.UserListVo;
import org.springframework.stereotype.Service;
import sun.security.x509.IssuerAlternativeNameExtension;

import javax.annotation.Resource;
import javax.persistence.ExcludeSuperclassListeners;

/**
 * @program: busis
 * @description: IAdminService实现类接口
 * @author: Mr.Chen
 * @create: 2018-04-12 14:30
 **/

@Service(value = "adminService")
public class AdminServiceImpl implements IAdminService{

    @Resource
    IUserDao userDao;

//    @Resource
//    private UserApiVo userApiVo;

//    @Resource
//    private UserListVo userListVo;

    @Resource
    private IUserService userService;


    @Override
    public UserApiVo addAdministrator(User user) throws Exception {
        UserApiVo userApiVo = new UserApiVo();

        //初始化返回
        userApiVo.setCode(1);
        userApiVo.setMessage("");

        //检验用户名
        if (user.getUsername() == null || user.getUsername() == ""){
            //用户名为空
            userApiVo.setCode(0);
            userApiVo.setMessage(userApiVo.getMessage() + "用户名为空！");
        }else if (user.getUsername().length() < 2 || user.getUsername().length() > 10){
            //用户名长度不符合
            userApiVo.setCode(0);
            userApiVo.setMessage(userApiVo.getMessage() + "用户名应为2至10个字符！");
        }

        //检验密码
        if (user.getPassword() == null || user.getPassword() == ""){
            //自动填充密码
            user.setPassword("123456");
        } else if (user.getPassword().length() < 6 || user.getPassword().length() > 20){
            //密码长度不符合
            userApiVo.setCode(0);
            userApiVo.setMessage(userApiVo.getMessage() + "密码应为6至20个字符！");
        }

        //检验电话号码
        if (user.getTelphone() == null || user.getTelphone() == ""){
            //电话号码为空
            userApiVo.setCode(0);
            userApiVo.setMessage(userApiVo.getMessage() + "电话号码为空！");
        } else if (!TelphoneCheckUtil.isPhoneLegal(user.getTelphone())){
            //电话号码不合法
            userApiVo.setCode(0);
            userApiVo.setMessage(userApiVo.getMessage() + "电话号码不合法！");
        } else {
            //检验电话号码是否已被注册
            int count = 0;
            count = userDao.queryTelphone(user.getTelphone());
            if (count > 0){
                //电话号码已被注册
                userApiVo.setCode(0);
                userApiVo.setMessage(userApiVo.getMessage() + "电话号码已注册！");
            }
        }

        if (userApiVo.getCode() == 0){
            //说明存在非法数据

        } else {
            //用户名、密码、电话号码均合法
            //填充用户介绍
            if (user.getIntroduce() == null){
                user.setIntroduce("");
            }
            //注册用户
            userDao.insertUser(user);
            //修改用户权限
            user.setAuthority('2');
            userDao.modifyAuthority(user);

            //填充返回数据
            userApiVo.setCode(1);
            userApiVo.setMessage("添加管理员成功！");
            userApiVo.setUser(user);
        }
        return userApiVo;
    }

    @Override
    public UserApiVo deleteAdministrator(User user) throws Exception {

        UserApiVo userApiVo = new UserApiVo();

        //初始化返回
        userApiVo.setCode(1);
        userApiVo.setMessage("");
        userApiVo.setUser(null);

        userDao.deleteUserByUser_id(user.getUser_id());
        return userApiVo;
    }

    @Override
    public UserListVo getUserByAuthority(char authority) throws Exception {
        UserListVo userListVo = new UserListVo();
        //初始化
        userListVo.setStatusCode(1);
        userListVo.setMessage("");

        if (authority != '1' && authority != '2' && authority != '3'){
            //权限参数非法
            userListVo.setStatusCode(0);
            userListVo.setMessage("用户权限非法！");
        } else {
            userListVo.setUserArrayList(userDao.getUserByAuthority(authority));
        }
        return userListVo;
    }

    @Override
    public UserApiVo addUser(User user) throws Exception {
        UserApiVo userApiVo = new UserApiVo();
        //初始化返回
        userApiVo.setCode(1);
        userApiVo.setMessage("");

        //检验用户名
        if (user.getUsername() == "" || user.getUsername() == null){
            //用户名为空
            userApiVo.setCode(0);
            userApiVo.setMessage(userApiVo.getMessage() + "用户名为空！");
        } else if (user.getUsername().length() < 2 || user.getUsername().length() > 10){
            //用户名格式不对
            userApiVo.setCode(0);
            userApiVo.setMessage(userApiVo.getMessage() + "用户名应为2-10个字符！");
        }

        //检验电话号码是非非法
        if (user.getTelphone() == "" || user.getTelphone() == null){
            //电话号码为空
            userApiVo.setCode(0);
            userApiVo.setMessage(userApiVo.getMessage() + "电话号码为空！");
        } else if (!TelphoneCheckUtil.isPhoneLegal(user.getTelphone())){
            //电话号码非法
            userApiVo.setCode(0);
            userApiVo.setMessage(userApiVo.getMessage() + "电话号码无效！");
        } else {
            //校验电话号码是否被注册
            int count = 0;
            count = userDao.queryTelphone(user.getTelphone());
            if (count > 0){
                userApiVo.setCode(0);
                userApiVo.setMessage(userApiVo.getMessage() + "电话号码已注册！");
            }
        }

        //检验密码
        if (user.getPassword() == "" || user.getPassword() == null){
            //密码为空，填充默认值
            String password = "123456";
            user.setPassword(password);
        } else if (user.getPassword().length() < 6 || user.getPassword().length() > 20){
            //密码长度不合法
            userApiVo.setCode(0);
            userApiVo.setMessage(userApiVo.getMessage() + "密码应为6-20个字符！");
        }

        if (userApiVo.getCode() == 0){
            //存在非法数据
            userApiVo.setUser(null);
        } else {
            userDao.insertUser(user);
            userApiVo.setCode(1);
            userApiVo.setMessage("注册成功！");
            userApiVo.setUser(user);
        }
        return userApiVo;
    }

    @Override
    public UserApiVo deleteUser(User user) throws Exception {
        UserApiVo userApiVo = new UserApiVo();
        //初始化返回
        userApiVo.setCode(1);
        userApiVo.setMessage("");

        //校验用户是否存在
        User count = userDao.findUserById(user.getUser_id());
        if (user == null){
            //不存在用户
            userApiVo.setCode(0);
            userApiVo.setMessage("用户不存在！");
            userApiVo.setUser(null);
        } else {
            userDao.deleteUserByUser_id(user.getUser_id());
            userApiVo.setCode(1);
            userApiVo.setMessage("删除成功！");
            userApiVo.setUser(null);
        }
        return userApiVo;
    }
}
