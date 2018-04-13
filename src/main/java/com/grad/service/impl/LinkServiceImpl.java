package com.grad.service.impl;

import com.grad.dao.ILinkDao;
import com.grad.entity.Link;
import com.grad.service.ILinkService;
import com.grad.vo.LinkApiVo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @program: busis
 * @description: ILinkService接口实现类
 * @author: Mr.Chen
 * @create: 2018-04-13 21:49
 **/
@Scope(value = "singleton")
@Service(value = "linkService")
public class LinkServiceImpl implements ILinkService {

    @Resource
    private LinkApiVo linkApiVo;

    @Resource
    private ILinkDao linkDao;

    @Override
    public LinkApiVo addLink(Link link) throws Exception {
        //初始化返回
        linkApiVo.setCode(1);
        linkApiVo.setMessage("");
        linkApiVo.setLinkArrayList(null);

        if (link == null){
            //传入参数为空
            linkApiVo.setCode(0);
            linkApiVo.setMessage("传入参数为空！");
        } else {
            if (link.getName() == "" || link.getName() == null){
                linkApiVo.setCode(0);
                linkApiVo.setMessage(linkApiVo.getMessage() + "链接名称不能为空！");
            }
            if (link.getUrl() == "" || link.getUrl() == null){
                linkApiVo.setCode(0);
                linkApiVo.setMessage(linkApiVo.getMessage() + "链接URL不能为空！");
            }
            if (linkApiVo.getCode() == 0){
                //名称或URL为空

            }else {
                //输入数据正常
                ArrayList<Link> tempList = linkDao.findLinkByName(link.getName());
                if (tempList != null){
                    boolean flag = true;
                    for (Link link1 : tempList){
                        if (link1.getUrl().equals(link.getUrl())){
                            flag = false;
                        }
                    }
                    if (!flag){
                        //数据库中已存在链接
                        linkApiVo.setCode(0);
                        linkApiVo.setMessage(linkApiVo.getMessage() + "已存在此链接！");
                    }
                }
                if (linkApiVo.getCode() != 0){
                    linkDao.addLink(link);
                    linkApiVo.setCode(1);
                    linkApiVo.setMessage("增加链接成功！");
                }
            }
        }
        return linkApiVo;
    }

    @Override
    public void deleteLink(Link link) throws Exception {
        linkDao.deleteLink(link);
    }
}
