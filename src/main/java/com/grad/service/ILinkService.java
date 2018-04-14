package com.grad.service;

import com.grad.entity.Link;
import com.grad.vo.LinkApiVo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: busis
 * @description: 友情链接相关业务逻辑接口类
 * @author: Mr.Chen
 * @create: 2018-04-13 21:42
 **/
@Transactional
public interface ILinkService {

    /**
     * 新增友情链接
     * @param link
     *      name : 友情链接名称
     *      url : 链接URL
     *      flag ： 有效标记
     *      type : 链接类型
     * @return
     * @throws Exception
     */
    public LinkApiVo addLink(Link link) throws Exception;

    /**
     * 删除链接
     * @param link
     *      name : 链接名称
     *      url ： 链接URL
     * @return
     * @throws Exception
     */
    public void deleteLink(Link link) throws Exception;


    /**
     * 获取所有链接
     * @return
     * @throws Exception
     */
    public LinkApiVo getAll() throws Exception;


}
