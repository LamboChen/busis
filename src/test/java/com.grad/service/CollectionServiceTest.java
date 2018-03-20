package com.grad.service;

import com.grad.entity.Collection;
import net.sf.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: busis
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-15 14:24
 **/
public class CollectionServiceTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void testAddCollection() throws Exception{
        ICollectionService collectionService = (ICollectionService) applicationContext.getBean("collectionService");
        Collection collection = (Collection) applicationContext.getBean("collection");
        int result = 0;

        collection.setStart_point("xhu西大门");
        collection.setEnd_point("xhu南大门");
        collection.setStart_longitude("1.1");
        collection.setStart_latitude("2.2");
        collection.setEnd_longitude("3.3");
        collection.setEnd_latitude("4.4");
        collection.setRoute_information("route");
        collection.setUser_id(1);

        result = collectionService.addCollection(collection);

        System.out.println(result);
    }

    @Test
    public void testDeleteCollection() throws Exception{
        ICollectionService collectionService = (ICollectionService) applicationContext.getBean("collectionService");
        Collection collection = (Collection) applicationContext.getBean("collection");

        collection.setStart_longitude("1.1");
        collection.setStart_latitude("2.2");
        collection.setEnd_longitude("3.3");
        collection.setEnd_latitude("4.4");
        collection.setUser_id(1);

        collectionService.deleteCollection(collection);
    }

    @Test
    public void testFindCollectionByUser_id() throws Exception{
        ICollectionService collectionService = (ICollectionService) applicationContext.getBean("collectionService");
        int user_id = 1;

        List<Collection> collectionList = collectionService.findCollectionByUser_id(user_id);

        for (Collection collection : collectionList){
            System.out.println(collection.getCollection_id());
            System.out.println(collection.getStart_point());
            System.out.println(collection.getEnd_point());
            System.out.println(collection.getStart_longitude());
            System.out.println(collection.getStart_latitude());
            System.out.println(collection.getEnd_longitude());
            System.out.println(collection.getEnd_latitude());
            System.out.println(collection.getArea());
            System.out.println(collection.getRoute_information());
            System.out.println(collection.getUser_id());
            System.out.println("--------------------------------------------------");
        }

        JSONArray jsonList = JSONArray.fromObject(collectionList);
        System.out.println("JSONArray: " + jsonList);
    }

    @Test
    public void testTotalCollection() throws Exception{
        ICollectionService collectionService = (ICollectionService) applicationContext.getBean("collectionService");
        Collection collection = (Collection) applicationContext.getBean("collection");

        collection.setStart_longitude("1.1");
        collection.setStart_latitude("2.2");
        collection.setEnd_longitude("3.3");
        collection.setEnd_latitude("4.4");
        collection.setUser_id(1);

        int result = 0;
        result = collectionService.totalCollection(collection);

        System.out.println(result);

    }

}
