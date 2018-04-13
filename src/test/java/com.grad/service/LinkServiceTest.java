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
        link.setName("百度一下");
        link.setUrl("http://www.baidu.com");

        ILinkService linkService = (ILinkService) applicationContext.getBean("linkService");

        LinkApiVo linkApiVo = linkService.addLink(link);

        System.out.println("code:" + linkApiVo.getCode());
        System.out.println("message:" + linkApiVo.getMessage());
    }
}
