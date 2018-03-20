package com.grad.dao;

import com.grad.entity.History;
import com.grad.vo.StartAndEndPointVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * @program: busis
 * @description: IHistoryDao测试类
 * @author: Mr.Chen
 * @create: 2018-03-14 09:20
 **/
public class HistoryDaoTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void testInsertHistory() throws Exception{
        IHistoryDao historyDao = (IHistoryDao) applicationContext.getBean("historyMapper");
        History history = (History) applicationContext.getBean("history");

        history.setStart_point("西华大学南大门");
        history.setEnd_point("西华大学西大门");
        history.setStart_longitude("123.123");
        history.setStart_latitude("456.456");
        history.setEnd_longitude("789.789");
        history.setEnd_latitude("321.321");
        history.setHistory_time(new Date());
        history.setArea("四川成都");
        history.setRoute_information("route-information");
        history.setUser_id(1);

        historyDao.insertHistory(history);

        System.out.println(history.getHistory_id());

    }

    @Test
    public void testFindHistoryByStartAndEnd() throws Exception{
        IHistoryDao historyDao = (IHistoryDao) applicationContext.getBean("historyMapper");
        StartAndEndPointVo startAndEndPointVo =
                (StartAndEndPointVo) applicationContext.getBean("startAndEndPointVo");

        startAndEndPointVo.setStart_longitude("1.1");
        startAndEndPointVo.setStart_latitude("2.2");
        startAndEndPointVo.setEnd_longitude("3.3");
        startAndEndPointVo.setEnd_latitude("4.4");

        List<History> historyList = historyDao.findHistoryByStartAndEnd(startAndEndPointVo);

        for (History history : historyList){
            System.out.println(history.getHistory_id());
        }
    }

    @Test
    public void testFindHistoryByUser_id() throws Exception{
        IHistoryDao historyDao = (IHistoryDao) applicationContext.getBean("historyMapper");
        int user_id = 1;

        List<History> historyList = historyDao.findHistoryByUser_id(user_id);

        for (History history : historyList){
            System.out.println(history.getHistory_id());
            System.out.println(history.getStart_point());
            System.out.println(history.getEnd_point());
            System.out.println(history.getStart_longitude());
            System.out.println(history.getStart_latitude());
            System.out.println(history.getEnd_longitude());
            System.out.println(history.getEnd_latitude());
            System.out.println(history.getHistory_time());
            System.out.println(history.getArea());
            System.out.println(history.getRoute_information());
            System.out.println(history.getUser_id());
            System.out.println("--------------------------------------------------");
        }
    }
}
