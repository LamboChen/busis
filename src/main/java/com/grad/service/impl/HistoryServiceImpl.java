package com.grad.service.impl;

import com.grad.dao.IHistoryDao;
import com.grad.entity.History;
import com.grad.service.IHistoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: busis
 * @description: IHistoryService接口实现类
 * @author: Mr.Chen
 * @create: 2018-03-14 10:25
 **/
@Service(value = "historyService")
public class HistoryServiceImpl implements IHistoryService {

    @Resource
    private IHistoryDao historyDao;

    public int insertHistory(History history) throws Exception {
        boolean check = true;
        int result = -1;

        //history合法性检查
        //起点名称长度不能超过20
        if (history.getStart_point() != "" && history.getStart_point() != null && history.getStart_point().length() > 20){
            check = false;
        }
        //终点名称长度不能超过20
        if (history.getEnd_point() != "" && history.getEnd_point() != null && history.getEnd_point().length() > 20){
            check = false;
        }
        //起点位置经度数据不能为空，长度不能超过15
        if (history.getStart_longitude() == "" || history.getStart_longitude() == null ||
                history.getStart_longitude().length() > 15){
            check = false;
        }
        //起点位置纬度数据不能为空，长度不能超过15
        if (history.getStart_latitude() == "" || history.getStart_latitude() == null ||
                history.getStart_latitude().length() > 15){
            check = false;
        }
        //终点位置经度数据不能为空，长度不能超过15
        if (history.getEnd_longitude() == "" || history.getEnd_longitude() == null ||
                history.getEnd_longitude().length() > 15){
            check = false;
        }
        //终点位置纬度数据不能为空，长度不能超过15
        if (history.getEnd_latitude() == "" || history.getEnd_latitude() == null ||
                history.getEnd_latitude().length() > 15){
            check = false;
        }
        //历史线路时间不能为空
        if (history.getHistory_time() == null){
            //默认为当前时间
            history.setHistory_time(new Date());
        }
        //区域不能为空
        if (history.getArea() == null || history.getArea() == ""){
            //区域默认为四川成都
            history.setArea("四川成都");
        }
        if (history.getUser_id() == 0){
            check = false;
        }
        if (history.getRoute_information() == "" || history.getRoute_information() == null
                || history.getRoute_information().length() > 200){
            check = false;
        }

        if (check){
            //数据合法，可以进行线路数据的更新
            historyDao.insertHistory(history);
            result = history.getHistory_id();
        } else {
            //存在不合法数据
            result = -1;
        }

        return result;
    }

    public List<History> getHistoryByUser_id(int user_id) throws Exception {

        List<History> historyList = historyDao.findHistoryByUser_id(user_id);

        return historyList;
    }
}
