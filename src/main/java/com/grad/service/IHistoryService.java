package com.grad.service;

import com.grad.entity.History;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: busis
 * @description: history相关业务逻辑类
 * @author: Mr.Chen
 * @create: 2018-03-14 10:22
 **/
@Transactional
public interface IHistoryService {


    /**
     * 添加历史路线，返回其ID
     * @param history   路线基本信息
     * @return  历史路线ID,添加失败返回-1
     * @throws Exception
     */
    public int insertHistory(History history) throws Exception;


    /**
     * 通过用户ID查询历史路线信息
     * @param user_id
     * @return  信息列表
     * @throws Exception
     */
    public List<History> getHistoryByUser_id(int user_id) throws Exception;

}
