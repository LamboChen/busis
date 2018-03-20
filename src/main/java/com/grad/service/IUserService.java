package com.grad.service;

import com.grad.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: busis
 * @description: 对于User相关的service层接口
 * @author: Mr.Chen
 * @create: 2018-03-13 13:10
 **/

@Transactional
public interface IUserService {

    /**
     * @param account 用户账户（电话号码或用户名）
     * @param password  用户密码
     * @return 登录结果（0：登录失败，1：电话号码登录成功，2：用户名登录成功）
     * @throws Exception
     */
    public int loginByAccountAndPassword(String account,String password) throws Exception;


    /**
     * 通过电话号码获得用户基本信息
     * @param telphone  用户电话号码
     * @return  User用户基本信息
     * @throws Exception
     */
    public User getUserByTelphone(String telphone) throws Exception;


    /**
     * 通过用户名和密码获取用户基本信息
     * @param username  用户名
     * @param password  密码
     * @return  User用户基本信息
     * @throws Exception
     */
    public User getUserByUsernameAndPassword(String username,String password) throws Exception;


    /**
     * 通过用户ID查询用户基本信息
     * @param user_id
     * @return  User用户基本信息
     * @throws Exception
     */
    public User getUserById(int user_id) throws Exception;

    /**
     * 注册用户
     * @param user  用户对象，其中user_id字段为空
     * @return  注册成功后用户的ID，注册失败返回-1
     * @throws Exception
     */
    public int registerUser(User user) throws Exception;


    /**
     * 修改用户基本信息
     * @param user
     *          user_id: 用户ID
     *          username: 用户名
     *          telphone: 用户电话号码
     *          birthday: 用户出生日期
     *          head_portrail: 用户头像路径
     *          gender: 用户性别
     *          password: 用户密码
     *          introduce：用户备注
     * @return  修改结果（修改成功返回true，反之返回false）
     * @throws Exception
     */
    public boolean updateUserInformation(User user) throws Exception;


    /**
     * 修改用户等级权限
     * @param user  当前用户
     *          user_id: 用户ID
     *          authority: 用户权限等级
     * @param user_id   待修改用户ID
     * @param newAuthority  用户新权限等级
     * @return  结果布尔值（成功返回true，反之返回false）
     * @throws Exception
     */
    public boolean updateUserAuthority(User user,int user_id,char newAuthority) throws Exception;



}
