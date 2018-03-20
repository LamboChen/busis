package com.grad.dao;

import com.grad.entity.Location;

import java.util.List;

/**
 * @program: busis
 * @description: 位置收藏表对应的实体类
 * @author: Mr.Chen
 * @create: 2018-03-14 19:58
 **/

public interface ILocationDao {

    /**
     * 新增位置信息
     * @param location
     * @throws Exception
     */
    public void insertLocation(Location location) throws Exception;


    /**
     * 通过位置经纬度和用户ID进行地点的删除
     * @param location
     * @throws Exception
     */
    public void deleteLocationByLongitudeAndLatitude(Location location) throws Exception;


    /**
     * 通过用户ID进行位置查询
     * @param user_id   用户ID
     * @return  位置列表
     * @throws Exception
     */
    public List<Location> findLocationByUser_id(int user_id) throws Exception;


    /**
     * 统计同一个位置被多少用户所使用
     * @param location  （需要填充经纬度）
     * @return  记录数
     * @throws Exception
     */
    public int totalLocation(Location location) throws Exception;


    /**
     * 通过位置经纬度和用户ID查询是否存在此收藏
     * @param location 位置信息（需要填充经纬度和用户ID）
     * @return  查询记录数
     * @throws Exception
     */
    public int checkLocationAndUser_id(Location location) throws Exception;

}
