package com.grad.dao;

import com.grad.entity.Collection;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: busis
 * @description: ICollectionDao接口方法测试类
 * @author: Mr.Chen
 * @create: 2018-03-15 12:27
 **/
public class CollectionDaoTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void testInsertCollection() throws Exception{
        ICollectionDao collectionDao = (ICollectionDao) applicationContext.getBean("collectionMapper");
        Collection collection = (Collection) applicationContext.getBean("collection");

        collection.setStart_point("西华大学南大门");
        collection.setEnd_point("西华大学西大门");
        collection.setStart_longitude("123.123");
        collection.setStart_latitude("456.456");
        collection.setEnd_longitude("789.789");
        collection.setEnd_latitude("321.321");
        collection.setArea("四川成都");
        collection.setRoute_information("route-information");
        collection.setUser_id(1);

        collectionDao.insertCollection(collection);

        System.out.println(collection.getCollection_id());
    }

    @Test
    public void testDeleteCollectionByLongitudeAndLatitudeAndUser_id() throws Exception{
        ICollectionDao collectionDao = (ICollectionDao) applicationContext.getBean("collectionMapper");
        Collection collection = (Collection) applicationContext.getBean("collection");

        collection.setStart_point("西华大学南大门");
        collection.setEnd_point("西华大学西大门");
        collection.setStart_longitude("123.123");
        collection.setStart_latitude("456.456");
        collection.setEnd_longitude("789.789");
        collection.setEnd_latitude("321.321");
        collection.setArea("四川成都");
        collection.setRoute_information("route-information");
        collection.setUser_id(1);

        collectionDao.deleteCollectionByCollection_id(collection.getCollection_id());
    }

    @Test
    public void testFindCollectionByUser_id() throws  Exception{
        ICollectionDao collectionDao = (ICollectionDao) applicationContext.getBean("collectionMapper");
        int user_id = 1;

        List<Collection> collectionList = collectionDao.findCollectionByUser_id(user_id);

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
    }

    @Test
    public void testTotalCollection() throws Exception{
        ICollectionDao collectionDao = (ICollectionDao) applicationContext.getBean("collectionMapper");
        Collection collection = (Collection) applicationContext.getBean("collection");

        collection.setStart_longitude("123.123");
        collection.setStart_latitude("456.456");
        collection.setEnd_longitude("789.789");
        collection.setEnd_latitude("321.321");

        int result = 0;
        result = collectionDao.totalCollection(collection);

        System.out.println(result);
    }

    @Test
    public void testCheckCollectionAndUser_id() throws Exception{
        ICollectionDao collectionDao = (ICollectionDao) applicationContext.getBean("collectionMapper");
        Collection collection = (Collection) applicationContext.getBean("collection");

        collection.setStart_longitude("123.123");
        collection.setStart_latitude("456.456");
        collection.setEnd_longitude("789.789");
        collection.setEnd_latitude("321.321");
        collection.setUser_id(1);

        int result = 0;

        result = collectionDao.checkCollectionAndUser_id(collection);

        System.out.println(result);
    }




}
