package com.grad.service;

import com.grad.entity.Link;
import com.grad.vo.LinkApiVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: busis
 * @description: LinkService测试类
 * @author: Mr.Chen
 * @create: 2018-04-13 22:07
 **/
public class LinkServiceTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
    }

    @Test
    public void testAddLink() throws Exception{

        Link link = new Link();
        link.setName("Google");
        link.setUrl("http://www.google.com");

        ILinkService linkService = (ILinkService) applicationContext.getBean("linkService");

        LinkApiVo linkApiVo = linkService.addLink(link);

        System.out.println("code:" + linkApiVo.getCode());
        System.out.println("message:" + linkApiVo.getMessage());
    }

    @Test
    public void testGetAll() throws Exception{

        ILinkService linkService = (ILinkService) applicationContext.getBean("linkService");
        LinkApiVo linkApiVo = linkService.getAll();

        System.out.println("code:" + linkApiVo.getCode());
        System.out.println("message:" + linkApiVo.getMessage());

        for (Link link : linkApiVo.getLinkArrayList()){
            System.out.print("link name:" + link.getName());
            System.out.println("  link url:" + link.getUrl());
        }
    }
}
