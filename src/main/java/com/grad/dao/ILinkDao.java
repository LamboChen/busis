package com.grad.dao;

import com.grad.entity.Link;

import java.util.ArrayList;

/**
 * @program: busis
 * @description: 友情链接（link）表相关dao接口
 * @author: Mr.Chen
 * @create: 2018-04-13 21:33
 **/
public interface ILinkDao {

    /**
     * 增加链接
     * @param link  链接信息
     *              name : 链接名称
     *              url : 链接url
     *              type : 链接类型
     * @throws Exception
     */
    public void addLink(Link link) throws Exception;


    /**
     * 通过名称查找链接信息
     * @param name
     * @return
     * @throws Exception
     */
    public ArrayList<Link> findLinkByName(String name) throws Exception;


    /**
     * 删除链接
     * @param link
     *      name : 链接名称
     *      url : 链接URL
     * @throws Exception
     */
    public void deleteLink(Link link) throws Exception;


    /**
     * 获取所有链接
     * @return
     * @throws Exception
     */
    public ArrayList<Link> getAll() throws Exception;


}
