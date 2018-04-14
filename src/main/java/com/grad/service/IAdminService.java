package com.grad.service;

import com.grad.entity.User;
import com.grad.vo.UserApiVo;
import com.grad.vo.UserListVo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: busis
 * @description: 管理员相关业务逻辑接口类
 * @author: Mr.Chen
 * @create: 2018-04-12 14:28
 **/

@Transactional
public interface IAdminService {

    /**
     * 新增普通管理员用户
     * @param user  用户基本信息
     *              username : 用户姓名（必填）
     *              password : 用户密码(默认为123456)
     *              telphone : 电话号码（必填）
     *              introduce : 用户介绍
     * @return
     * @throws Exception
     */
    public UserApiVo addAdministrator(User user) throws Exception;


    /**
     * 删除普通管理员
     * @param user
     *      user_id : 用户ID
     * @return
     * @throws Exception
     */
    public UserApiVo deleteAdministrator(User user) throws Exception;


    /**
     * 根据用户权限查询用户
     * @return
     * @throws Exception
     */
    public UserListVo getUserByAuthority(char authority) throws Exception;


    /**
     * 新增普通用户
     * @param user
     *      username : 用户姓名（必填）
     *      telphone : 用户电话号码（必填）
     *      password : 密码（默认123456）
     * @return
     * @throws Exception
     */
    public UserApiVo addUser(User user) throws Exception;


    /**
     * 删除普通用户
     * @param user
     * @return
     * @throws Exception
     */
    public UserApiVo deleteUser(User user) throws Exception;

}
