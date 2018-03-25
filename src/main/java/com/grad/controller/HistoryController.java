package com.grad.controller;

import com.grad.entity.History;
import com.grad.service.IHistoryService;
import com.grad.util.ApiFormatUtil;
import com.grad.util.GetDateByStringUtils;
import com.grad.vo.HistoryApiVo;
import com.grad.vo.HistoryListApiVo;
import com.grad.vo.HistoryVo;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @program: busis
 * @description: 历史路线相关接口
 * @author: Mr.Chen
 * @create: 2018-03-14 11:00
 **/
@Controller
@RequestMapping(value = "/history")
public class HistoryController {

    @Resource
    private IHistoryService historyService;

    /**
     * 增加历史路线
     * @param historyVo 历史路线基本信息
     *         start_point:起点名称
     *         end_point:终点名称
     *         start_longitude:起点经度
     *         start_latitude:起点纬度
     *         end_longitude:终点经度
     *         end_latitude:终点纬度
     *         history_time:历史路线时间
     *         area:区域
     *         user_id; 用户ID
     *         route_information:路线信息
     * @return  result，添加成功返回路线ID，失败返回0（JSON字符串）
     * @throws Exception
     */
    @RequestMapping(value = "/add",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String addHistory(HistoryVo historyVo) throws Exception{
        History history = new History();
        int result = 1;

        HistoryApiVo historyApiVo = new HistoryApiVo();
        historyApiVo.setCode(0);
        historyApiVo.setMessage("");

        //将数据转换填充到history中
        if (historyVo.getStart_point() != null && historyVo.getStart_point() != ""){
            history.setStart_point(historyVo.getStart_point());
        }
        if (historyVo.getEnd_point() != null && historyVo.getEnd_point() != ""){
            history.setEnd_point(historyVo.getEnd_point());
        }
        //起点经度不能为空
        if (historyVo.getStart_longitude() == null || historyVo.getStart_longitude() == ""){
            //参数为空
//            result = 0;
//            historyApiVo.setCode(0);
//            historyApiVo.setMessage(historyApiVo.getMessage() + "起点经度不能为空！");
        } else {
            history.setStart_longitude(historyVo.getStart_longitude());
        }
        //终点经度不能为空
        if (historyVo.getEnd_longitude() == null || historyVo.getEnd_longitude() == ""){
//            //参数为空
//            historyApiVo.setMessage(historyApiVo.getMessage() + "终点经度不能为空！");
//            result = 0;
        } else {
            history.setEnd_longitude(historyVo.getEnd_longitude());
        }
        //起点纬度不能为空
        if (historyVo.getStart_latitude() == null || historyVo.getStart_latitude() == ""){
            //参数为空
//            result = 0;
//            historyApiVo.setMessage(historyApiVo.getMessage() + "起点纬度不能为空！");
        } else {
            history.setStart_latitude(historyVo.getStart_latitude());
        }
        //终点纬度不能为空
        if (historyVo.getEnd_latitude() == null || historyVo.getEnd_latitude() == ""){
            //参数为空
//            result = 0;
//            historyApiVo.setMessage(historyApiVo.getMessage() + "终点纬度不能为空！");
        } else {
            history.setEnd_latitude(historyVo.getEnd_latitude());
        }
        //判断时间是否为空
        if (historyVo.getHistory_time() != null){
            history.setHistory_time(GetDateByStringUtils.getDateTime(historyVo.getHistory_time()));
        }
        //区域是否为空
        if (historyVo.getArea() != null && historyVo.getArea() != ""){
            history.setArea(historyVo.getArea());
        }
        //判断用户ID是否为空
        if (historyVo.getUser_id() <= 0){
            //没有user_id
            result = 0;
            historyApiVo.setMessage(historyApiVo.getMessage() + "用户ID不能为空！");
        } else {
            history.setUser_id(historyVo.getUser_id());
        }
        //路线信息
        if (historyVo.getRoute_information() == "" || historyVo.getRoute_information() == null
                || historyVo.getRoute_information().length() > 200){
            //数据非法
            result = 0;
            historyApiVo.setMessage(historyApiVo.getMessage() + "路线信息不能为空或路线信息不能超过200字符！");
        } else {
            history.setRoute_information(historyVo.getRoute_information());
        }

        if (result == 0){
            //存在非法数据
            historyApiVo.setCode(0);
            historyApiVo.setMessage("存在不合法数据：" + historyApiVo.getMessage());
        } else {
            //所有数据均合法，可以进行添加操作
            historyApiVo = historyService.insertHistory(history);
        }

        return ApiFormatUtil.apiFormat(historyApiVo.getCode(),historyApiVo.getMessage(),historyApiVo.getHistory());
    }


    /**
     * 通过用户ID查询历史路线信息
     * @param user_id
     * @return  历史路线信息列表
     * @throws Exception
     */
    @RequestMapping(value = "/get",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getHistory(int user_id) throws Exception{

        HistoryListApiVo historyListApiVo = historyService.getHistoryByUser_id(user_id);

        JSONArray result = JSONArray.fromObject(historyListApiVo.getHistoryList());

        return ApiFormatUtil.apiFormat(historyListApiVo.getCode(),historyListApiVo.getMessage(),result);
    }


}
