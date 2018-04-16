package com.grad.service.impl;

import com.grad.dao.AnnouncementDao;
import com.grad.entity.Announcement;
import com.grad.service.IAnnouncementService;
import com.grad.vo.AnnounceDeleteVo;
import com.grad.vo.AnnouncementListVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

/**
 * @program: busis
 * @description: AnnouncementService接口实现类
 * @author: Mr.Chen
 * @create: 2018-04-16 14:06
 **/
@Service(value = "announcementService")
public class AnnouncementServiceImpl implements IAnnouncementService {

    @Resource
    private AnnouncementDao announcementDao;

    public AnnouncementServiceImpl(){

    }

    @Override
    public AnnouncementListVo insertAnnouncement(Announcement announcement) throws Exception {
        //初始化返回
        AnnouncementListVo announcementListVo = new AnnouncementListVo();
        announcementListVo.setCode(1);
        announcementListVo.setMessage("");

        //校验是否接收参数成功
        if (announcement == null){
            announcementListVo.setCode(0);
            announcementListVo.setMessage(announcementListVo.getMessage() + "未接收到参数！");
        } else {
            //接收到参数
            //校验必填项
            if (announcement.getTitle() == null || announcement.getTitle() == ""){
                //未传入公告标题
                announcementListVo.setCode(0);
                announcementListVo.setMessage(announcementListVo.getMessage() + "公告标题不能为空！");
            } else if (announcement.getTitle().length() > 50){
                announcementListVo.setCode(0);
                announcementListVo.setMessage(announcementListVo.getMessage() + "标题长度应小于50");
            }

            if (announcement.getContent() == null || announcement.getContent() == ""){
                announcementListVo.setCode(0);
                announcementListVo.setMessage(announcementListVo.getMessage() + "公告内容不能为空！");
            } else if (announcement.getContent().length() > 500){
                announcementListVo.setCode(0);
                announcementListVo.setMessage(announcementListVo.getMessage() + "公告内容长度应小于500");
            }

            //填充数据
            if (announcement.getUser_id() <= 0){
                //用户ID默认为1
                announcement.setUser_id(1);
            } else {
                //填充用户ID
                announcement.setUser_id(announcement.getUser_id());
            }
            if (announcement.getTime() == null){
                //发布时间默认为当前时间
                announcement.setTime(new Date());
            }

            if (announcementListVo.getCode() == 1){
                //数据均合法
                announcementDao.insertAnnouncement(announcement);
                announcementListVo.setCode(1);
                announcementListVo.setMessage("添加成功！");
            }
        }
        announcementListVo.setAnnouncementArrayList(null);
        return announcementListVo;
    }

    @Override
    public AnnouncementListVo deleteAnnouncement(int announcement_id) throws Exception {
        //初始化返回
        AnnouncementListVo announcementListVo = new AnnouncementListVo();
        announcementListVo.setCode(1);
        announcementListVo.setMessage("");

        //声明删除所需参数
        AnnounceDeleteVo announceDeleteVo = new AnnounceDeleteVo();
        announceDeleteVo.setAnnounce_id(announcement_id);
        announceDeleteVo.setDelete_or('1');

        //检验数据合法
        if (announcement_id <= 0){
            announcementListVo.setCode(0);
            announcementListVo.setMessage(announcementListVo.getMessage() + "不存在此公告！");
        } else {
            announcementDao.deleteAnnouncement(announceDeleteVo);
            announcementListVo.setCode(1);
            announcementListVo.setMessage("删除成功！");
        }
        announcementListVo.setAnnouncementArrayList(null);
        return announcementListVo;
    }

    @Override
    public AnnouncementListVo getAnnouncement(char delete_or) throws Exception {
        AnnouncementListVo announcementListVo = new AnnouncementListVo();
        announcementListVo.setCode(1);
        announcementListVo.setMessage("");

        if (delete_or != '1'){
            //默认为获取为删除公告信息列表
            delete_or = '0';
        }

        announcementListVo.setAnnouncementArrayList((ArrayList<Announcement>) announcementDao.getAnnouncement(delete_or));
        announcementListVo.setMessage("获取成功！");

        return announcementListVo;
    }
}
