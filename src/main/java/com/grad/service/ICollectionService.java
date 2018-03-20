package com.grad.service;

import com.grad.entity.Collection;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: busis
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-15 12:47
 **/
@Transactional
public interface ICollectionService {


    /**
     * 用户添加收藏路线
     * @param collection    路线基本信息，用户ID
     * @return 新增成功返回位置ID，失败返回-1
     * @throws Exception
     */
    public int addCollection(Collection collection) throws Exception;


    /**
     * 用户删除收藏路线
     * @param collection    路线基本信息，用户ID
     * @throws Exception
     */
    public void deleteCollection(Collection collection) throws Exception;


    /**
     * 通过用户ID查询收藏路线列表
     * @param user_id   用户ID
     * @return  路线基本信息列表
     * @throws Exception
     */
    public List<Collection> findCollectionByUser_id(int user_id) throws Exception;


    /**
     * 通过路线起点和终点经纬度进行查询该路线被多少用户收藏
     * @param collection    路线基本信息（需要填充起点和终点经纬度）
     * @return  用户数
     * @throws Exception
     */
    public int totalCollection(Collection collection) throws Exception;
}
