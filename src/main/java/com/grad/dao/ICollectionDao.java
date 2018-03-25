package com.grad.dao;

import com.grad.entity.Collection;

import java.util.List;

/**
 * @program: busis
 * @description: 收藏路线相关的dao类
 * @author: Mr.Chen
 * @create: 2018-03-15 12:09
 **/


public interface ICollectionDao {

    /**
     * 添加收藏路线
     * @param collection 收藏路线基本信息
     * @throws Exception
     */
    public void insertCollection(Collection collection) throws Exception;


    /**
     * 通过位置经纬度和用户ID进行收藏路线的删除
     * @param collection_id 路线ID
     * @throws Exception
     */
    public void deleteCollectionByCollection_id(int collection_id) throws Exception;


    /**
     * 通过用户ID查询收藏路线
     * @param user_id
     * @return  路线基本信息列表
     * @throws Exception
     */
    public List<Collection> findCollectionByUser_id(int user_id) throws Exception;


    /**
     * 统计同一条路线被多少用户所收藏
     * @param collection    路线基本信息（需要填充路线起点和终点经纬度）
     * @return  记录数
     * @throws Exception
     */
    public int totalCollection(Collection collection) throws Exception;


    /**
     * 通过起点和终点经纬度和用户ID查询是否存在此收藏
     * @param collection    路线基本信息
     * @return  记录数
     * @throws Exception
     */
    public int checkCollectionAndUser_id(Collection collection) throws Exception;

}
