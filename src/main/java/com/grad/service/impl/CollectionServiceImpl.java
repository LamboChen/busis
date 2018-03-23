package com.grad.service.impl;

import com.grad.dao.ICollectionDao;
import com.grad.entity.Collection;
import com.grad.service.ICollectionService;
import com.grad.vo.CollectionApiVo;
import com.grad.vo.CollectionListApiVo;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: busis
 * @description: ICollectionService实现类
 * @author: Mr.Chen
 * @create: 2018-03-15 12:53
 **/

@Service(value = "collectionService")
public class CollectionServiceImpl implements ICollectionService {

    @Resource
    private ICollectionDao collectionDao;

    @Resource
    private CollectionApiVo collectionApiVo;

    @Resource
    private CollectionListApiVo collectionListApiVo;


    public CollectionApiVo addCollection(Collection collection) throws Exception {
        int result = 0;
        String area = "四川成都";

        collectionApiVo.setCode(0);
        collectionApiVo.setMessage("");
        collectionApiVo.setCollection(null);

        //数据合法性检查
        //起点和终点名称可以为空，只需校验其长度
        if (collection.getStart_point() != "" && collection.getStart_point() != null
                && collection.getStart_point().length() > 20){
            result = -1;
            collectionApiVo.setMessage(collectionApiVo.getMessage() + "起点名称不能超过20个字符！");
        }
        if (collection.getEnd_point() != "" && collection.getEnd_point() != null
                && collection.getEnd_point().length() > 20){
            collectionApiVo.setMessage(collectionApiVo.getMessage() + "终点名称不能超过20个字符！");
            result = -1;
        }
        //起点和终点经纬度不能为空，且长度应少于15
        if (collection.getStart_longitude() == "" || collection.getStart_longitude() == null
                || collection.getStart_longitude().length() > 15){
            result = -1;
            collectionApiVo.setMessage(collectionApiVo.getMessage() + "起点经度不能超过15个字符！");
        }
        if (collection.getStart_latitude() == "" || collection.getStart_latitude() == null
                || collection.getStart_latitude().length() > 15){
            result = -1;
            collectionApiVo.setMessage(collectionApiVo.getMessage() + "起点纬度不能超过15个字符！");
        }
        if (collection.getEnd_longitude() == "" || collection.getEnd_longitude() == null
                || collection.getEnd_longitude().length() > 15){
            result = -1;
            collectionApiVo.setMessage(collectionApiVo.getMessage() + "终点经度不能超过15个字符！");
        }
        if (collection.getEnd_latitude() == "" || collection.getEnd_latitude() == null
                || collection.getEnd_latitude().length() > 15){
            result = -1;
            collectionApiVo.setMessage(collectionApiVo.getMessage() + "终点纬度不能超过15个字符！");
        }
        //区域不能为空，默认为area
        if (collection.getArea() == "" || collection.getArea() == null){
            //设置默认值
            collection.setArea(area);
        } else if (collection.getArea().length() > 20){
            //数据长度非法
            result = -1;
            collectionApiVo.setMessage(collectionApiVo.getMessage() + "区域名称不能超过20个字符！");
        }
        //路线信息不能为空，长度不能大于200
        if (collection.getRoute_information() == "" || collection.getRoute_information() == null
                || collection.getRoute_information().length() > 1500){
            result = -1;
            collectionApiVo.setMessage(collectionApiVo.getMessage() + "路线信息不能超过1500个字符！");
        }
        //用户ID不能为空
        if (collection.getUser_id() <= 0){
            result = -1;
            collectionApiVo.setMessage(collectionApiVo.getMessage() + "用户ID不能为空！");
        }

        if (result == -1){
            //存在非法数据
            collectionApiVo.setCode(0);
        } else {
            //查重处理
            int records = 0;
            records = collectionDao.checkCollectionAndUser_id(collection);

            if (records > 0){
                //用户已经收藏过该路线
                result = -1;
                collectionApiVo.setMessage(collectionApiVo.getMessage() + "不能重复收藏路线！");
            } else {
                //可以进行添加
                collectionDao.insertCollection(collection);
                result = collection.getCollection_id();
                collectionApiVo.setCode(1);
                collectionApiVo.setCollection(collection);
                collectionApiVo.setMessage("收藏路线成功！");
            }
        }

        return collectionApiVo;
    }

    public CollectionApiVo deleteCollection(Collection collection) throws Exception {
        collectionDao.deleteCollectionByLongitudeAndLatitudeAndUser_id(collection);
        collectionApiVo.setCode(1);
        collectionApiVo.setMessage("删除收藏路线成功");
        return collectionApiVo;
    }

    public CollectionListApiVo findCollectionByUser_id(int user_id) throws Exception {
        List<Collection> collectionList = collectionDao.findCollectionByUser_id(user_id);
        collectionListApiVo.setCode(1);
        collectionListApiVo.setCollectionList(collectionList);
        collectionListApiVo.setMessage("查询成功");
        return collectionListApiVo;
    }

    public int totalCollection(Collection collection) throws Exception {
        int result = 0;

        //数据合法性检查
        //起点和终点经纬度不能为空，且长度应少于15
        if (collection.getStart_longitude() == "" || collection.getStart_longitude() == null
                || collection.getStart_longitude().length() > 15){
            result = -1;
        }
        if (collection.getStart_latitude() == "" || collection.getStart_latitude() == null
                || collection.getStart_latitude().length() > 15){
            result = -1;
        }
        if (collection.getEnd_longitude() == "" || collection.getEnd_longitude() == null
                || collection.getEnd_longitude().length() > 15){
            result = -1;
        }
        if (collection.getEnd_latitude() == "" || collection.getEnd_latitude() == null
                || collection.getEnd_latitude().length() > 15){
            result = -1;
        }

        if (result == -1){
            //存在非法数据

        } else {
            //可以进行查询
            result = collectionDao.totalCollection(collection);
        }

        return result;
    }
}
