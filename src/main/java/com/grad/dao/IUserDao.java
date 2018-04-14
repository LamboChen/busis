package com.grad.dao;

import com.grad.entity.User;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: busis
 * @description: user dao
 * @author: Mr.Chen
 * @create: 2018-03-12 13:38
 **/

//@Transactional
@Scope(value = "singleton")
public interface IUserDao {

    //通过用户ID查询用户
    public User findUserById(int user_id) throws Exception;


    /**
     * 通过用户电话号码查找用户信息
     * @param telphone  用户电话号码
     * @return  User用户全部基本信息
     * @throws Exception
     */
    public User findUserByTelphone(String telphone) throws Exception;


    /**
     * 通过username和password查找用户信息
     * @param user  用户对象，其中username和password必须要填充数据值
     * @return  User用户全部基本信息
     * @throws Exception
     */
    public User findUserByUsernameAndPassword(User user) throws Exception;


    /**
     * 通过用户名和密码验证用户是否存在(返回所查询的记录数)
     * @param user  User中填充username和password两个字段
     * @return  在数据库中所查询到的记录数
     * @throws Exception
     */
    public int matchByUsernameAndPassword(User user) throws Exception;


    /**
     * 通过电话号码和密码验证用户是否存在(返回所查询的记录数)
     * @param user  User中填充telphone和password两个字段
     * @return  在数据库中所查询到的记录数
     * @throws Exception
     */
    public int matchByTelphoneAndPassword(User user) throws Exception;


    /**
     * 注册用户
     * @param user  用户基本信息
     * @throws Exception
     */
    public void insertUser(User user) throws Exception;


    /**
     * 查询数据库中利用参数telphone注册的用户是否存在
     * @param telphone  用户电话号码
     * @return  查询所得的记录数，即利用此号码进行注册的用户数
     * @throws Exception
     */
    public int queryTelphone(String telphone) throws Exception;


    /**
     * 修改密码
     * @param user  需要填充用户ID和用户新密码
     * @throws Exception
     */
    public void modifyPassword(User user) throws Exception;


    /**
     * 修改用户名
     * @param user  需要填充用户ID和用户新用户名
     * @throws Exception
     */
    public void modifyUsername(User user) throws Exception;


    /**
     * 修改用户头像路径
     * @param user  需要填充用户ID和用户新头像路径
     * @throws Exception
     */
    public void modifyHead_portrail(User user) throws Exception;


    /**
     * 修改用户性别
     * @param user 需要填充用户ID和用户新性别
     * @throws Exception
     */
    public void modifyGender(User user) throws Exception;


    /**
     * 修改用户出生日期
     * @param user 需要填充用户ID和用户新出生日期
     * @throws Exception
     */
    public void modifyBirthday(User user) throws Exception;


    /**
     * 修改用户备注
     * @param user  需要填充用户ID和用户新介绍、备注
     * @throws Exception
     */
    public void modifyIntroduce(User user) throws Exception;


    /**
     * 修改用户电话号码
     * @param user  需要填充用户ID和用户新电话号码
     * @throws Exception
     */
    public void modifyTelphone(User user) throws Exception;


    /**
     * 修改用户权限
     * @param user
     * @throws Exception
     */
    public void modifyAuthority(User user) throws Exception;


    /**
     * 通过用户名部分进行模糊查询得到用户列表
     * @param usernamePart
     * @return  用户列表
     * @throws Exception
     */
    public List<User> fuzzyQueryByUsername(String usernamePart) throws Exception;


    /**
     * 通过ID删除用户
     * @param user_id
     * @throws Exception
     */
    public void deleteUserByUser_id(int user_id) throws Exception;


    /**
     * 通过用户权限查询用户
     * @param authority
     * @return
     * @throws Exception
     */
    public ArrayList<User> getUserByAuthority(char authority) throws Exception;

}
