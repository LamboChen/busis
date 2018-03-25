package com.grad.service;

import com.grad.entity.Collection;
import com.grad.vo.CollectionApiVo;
import com.grad.vo.CollectionListApiVo;
import org.springframework.transaction.annotation.Transactional;

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
     * @return code 新增成功返回1，失败返回0
     *          collection collection_id
     *          message 结果说明
     * @throws Exception
     */
    public CollectionApiVo addCollection(Collection collection) throws Exception;


    /**
     * 用户删除收藏路线
     * @param collection_id    收藏路线ID
     * @return code 结果
     *          message 结果说明
     * @throws Exception
     */
    public CollectionApiVo deleteCollection(int collection_id) throws Exception;


    /**
     * 通过用户ID查询收藏路线列表
     * @param user_id   用户ID
     * @return  code 结果码
     *          collectionList 成功返回收藏路线列表，否则返回空
     *          message 结果说明
     * @throws Exception
     */
    public CollectionListApiVo findCollectionByUser_id(int user_id) throws Exception;


    /**
     * 通过路线起点和终点经纬度进行查询该路线被多少用户收藏
     * @param collection    路线基本信息（需要填充起点和终点经纬度）
     * @return  用户数
     * @throws Exception
     */
    public int totalCollection(Collection collection) throws Exception;
}
