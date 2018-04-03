package com.grad.controller;

import com.grad.entity.Collection;
import com.grad.service.ICollectionService;
import com.grad.util.ApiFormatUtil;
import com.grad.vo.CollectionApiVo;
import com.grad.vo.CollectionListApiVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @program: busis
 * @description: 收藏路线相关接口类
 * @author: Mr.Chen
 * @create: 2018-03-15 14:39
 **/

@RequestMapping(value = "collection")
@Controller
public class CollectionController {

    @Resource
    private ICollectionService collectionService;


    /**
     * 添加收藏路线信息
     * @param collection 路线基本信息
     *         start_point:起点名称
     *         end_point:终点名称
     *         start_longitude:起点经度(必填）
     *         start_latitude:起点纬度(必填）
     *         end_longitude:终点经度(必填）
     *         end_latitude:终点纬度(必填）
     *         area:区域
     *         user_id; 用户ID(必填）
     *         route_information:路线信息(必填）
     * @return  result，添加成功返回收藏路线ID，失败返回0（JSON字符串）
     * @throws Exception
     */
    @RequestMapping(value = "/add",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String addCollection(Collection collection) throws Exception{

        CollectionApiVo collectionApiVo = collectionService.addCollection(collection);

        JSONObject jsonObject = new JSONObject();
        if (collectionApiVo.getCollection() != null){
            jsonObject.put("result",collectionApiVo.getCollection().getCollection_id());
        }

        return ApiFormatUtil.apiFormat(collectionApiVo.getCode(),collectionApiVo.getMessage(),jsonObject);
    }


    /**
     * 用户删除收藏路线
     * @param collection_id 收藏路线ID
     * @throws Exception
     */
    @RequestMapping(value = "/delete",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String deleteCollection(int collection_id) throws Exception{
        CollectionApiVo collectionApiVo = collectionService.deleteCollection(collection_id);
        return ApiFormatUtil.apiFormat(collectionApiVo.getCode(),collectionApiVo.getMessage(),"");
    }


    /**
     * 通过用户ID查询用户收藏路线
     * @param user_id
     * @return  路线列表
     *         collection_id:路线ID
     *         start_point:起点名称
     *         end_point:终点名称
     *         start_longitude:起点经度
     *         start_latitude:起点纬度
     *         end_longitude:终点经度
     *         end_latitude:终点纬度
     *         area:区域
     *         user_id; 用户ID
     *         route_information:路线信息
     * @throws Exception
     */
    @RequestMapping(value = "/query",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String findCollectionByUser_id(int user_id) throws Exception{
        //解决JSON中文乱码

        CollectionListApiVo collectionListApiVo = collectionService.findCollectionByUser_id(user_id);

        JSONArray result = JSONArray.fromObject(collectionListApiVo.getCollectionList());

        return ApiFormatUtil.apiFormat(collectionListApiVo.getCode(),collectionListApiVo.getMessage(),result);
    }


    /**
     * 统计该路线被多少用户收藏
     * @param collection
     *         start_point:起点名称
     *         end_point:终点名称
     *         start_longitude:起点经度(必填）
     *         start_latitude:起点纬度(必填）
     *         end_longitude:终点经度(必填）
     *         end_latitude:终点纬度(必填）
     *         area:区域
     *         route_information:路线信息
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/total",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String totalCollection(Collection collection) throws Exception{
        int result = 0;

        result = collectionService.totalCollection(collection);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);

        return ApiFormatUtil.apiFormat(1,"查询成功",jsonObject);
    }


}
