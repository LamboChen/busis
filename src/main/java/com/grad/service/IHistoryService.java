package com.grad.service;

import com.grad.entity.History;
import com.grad.vo.HistoryApiVo;
import com.grad.vo.HistoryListApiVo;
import org.springframework.transaction.annotation.Transactional;

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
     * @return  code 添加结果
     *          history
     *          message 结果描述
     * @throws Exception
     */
    public HistoryApiVo insertHistory(History history) throws Exception;


    /**
     * 通过用户ID查询历史路线信息
     * @param user_id
     * @return  code 结果码
     *          historyList 历史路线列表
     *          message 结果描述
     * @throws Exception
     */
    public HistoryListApiVo getHistoryByUser_id(int user_id) throws Exception;

}
