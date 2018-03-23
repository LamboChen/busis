package com.grad.service;

import com.grad.entity.Location;
import com.grad.vo.LocationApiVo;
import com.grad.vo.LocationListApiVo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: busis
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-14 20:43
 **/
@Transactional
public interface ILocationService {

    /**
     * 用户新增位置信息
     * @param location  位置基本信息，用户ID
     * @return  code 结果码
     *          message 结果描述
     *          location 位置信息
     * @throws Exception
     */
    public LocationApiVo addLocation(Location location) throws Exception;


    /**
     * 用户删除位置信息
     * @param location  位置基本信息
     * @return  code 结果码
     *          message 结果描述
     *          location 位置信息
     * @throws Exception
     */
    public LocationApiVo deleteLocation(Location location) throws Exception;


    /**
     * 通过用户ID查询位置信息列表
     * @param user_id   用户ID
     * @return  code 结果码
     *          message 结果描述
     *          location 位置信息列表
     * @throws Exception
     */
    public LocationListApiVo findLocationByUser_id(int user_id) throws Exception;


    /**
     * 通过经纬度进行统计位置被多少用户所使用
     * @param location  位置信息
     * @return  用户数
     * @throws Exception
     */
    public int totalLocation(Location location) throws Exception;

}
