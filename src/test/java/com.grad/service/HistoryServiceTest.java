//package com.grad.service;
//
//import com.grad.entity.History;
//import net.sf.json.JSONArray;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.List;
//
///**
// * @program: busis
// * @description: IHistoryService方法测试类
// * @author: Mr.Chen
// * @create: 2018-03-14 10:47
// **/
//public class HistoryServiceTest {
//
//    private ApplicationContext applicationContext;
//
//    @Before
//    public void setUp() {
//        applicationContext = new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
//    }
//
//    @Test
//    public void testInsertHistory() throws Exception{
//        IHistoryService historyService = (IHistoryService) applicationContext.getBean("historyService");
//        History history = (History) applicationContext.getBean("history");
//
//        history.setStart_longitude("123.123");
//        history.setStart_latitude("123.123");
//        history.setEnd_longitude("345.345");
//        history.setEnd_latitude("456.456");
//        history.setUser_id(1);
//        history.setRoute_information("route-information test");
//
//        int result = 0;
//        result = historyService.insertHistory(history);
//
//        System.out.println(result);
//    }
//
//    @Test
//    public void testGetHistoryByUser_id() throws Exception{
//        IHistoryService historyService = (IHistoryService) applicationContext.getBean("historyService");
//        int user_id = 1;
//
//        List<History> historyList = historyService.getHistoryByUser_id(user_id);
//
//        for (History history : historyList){
//            System.out.println(history.getHistory_id());
//            System.out.println(history.getStart_point());
//            System.out.println(history.getEnd_point());
//            System.out.println(history.getStart_longitude());
//            System.out.println(history.getStart_latitude());
//            System.out.println(history.getEnd_longitude());
//            System.out.println(history.getEnd_latitude());
//            System.out.println(history.getHistory_time());
//            System.out.println(history.getArea());
//            System.out.println(history.getRoute_information());
//            System.out.println(history.getUser_id());
//            System.out.println("--------------------------------------------------");
//        }
//
//        JSONArray jsonList = JSONArray.fromObject(historyList);
//        System.out.println("JSONArray: " + jsonList);
//    }
//}
