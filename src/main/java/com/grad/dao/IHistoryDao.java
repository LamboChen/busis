package com.grad.dao;

import com.grad.entity.History;
import com.grad.vo.StartAndEndPointVo;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * @program: busis
 * @description: History实体类相关的dao类
 * @author: Mr.Chen
 * @create: 2018-03-14 09:04
 **/
//事物注解仅测试使用
//@Transactional

@Scope(value = "singleton")
public interface IHistoryDao {


    /**
     * 添加历史路线
     * @param history   路线基本信息
     * @throws Exception
     */
    public void insertHistory(History history) throws Exception;


    /**
     * 通过线路起点和终点经纬度查询所有历史路线
     * @param startAndEndPointVo
     *          start_longitude:起点经度
     *          start_latitude:起点纬度
     *          end_longitude：终点经度
     *          end_latitude：终点纬度
     * @return  全部历史路线基本信息
     * @throws Exception
     */
    public List<History> findHistoryByStartAndEnd(StartAndEndPointVo startAndEndPointVo) throws Exception;


    /**
     * 通过用户ID查询用户历史路线
     * @param user_id   用户ID
     * @return  历史路线列表
     * @throws Exception
     */
    public List<History> findHistoryByUser_id(int user_id) throws Exception;

}
