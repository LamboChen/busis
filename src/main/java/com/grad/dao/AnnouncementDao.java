package com.grad.dao;

import com.grad.entity.Announcement;
import com.grad.vo.AnnounceDeleteVo;

import java.util.List;

/**
 * @program: busis
 * @description: 公告相关dao接口
 * @author: Mr.Chen
 * @create: 2018-04-16 13:33
 **/

public interface AnnouncementDao {

    /**
     * 添加公告
     * @param announcement
     * @throws Exception
     */
    public void insertAnnouncement(Announcement announcement) throws Exception;

    /**
     * 删除公告（修改是否删除字段为1）
     * @param announceDeleteVo
     *      announcement_id : 公告ID
     *      delete_or : 是否删除字段
     * @throws Exception
     */
    public void deleteAnnouncement(AnnounceDeleteVo announceDeleteVo) throws Exception;

    /**
     * 获取公告信息列表
     * @param delete_or     是否删除
     * @return
     * @throws Exception
     */
    public List<Announcement> getAnnouncement(char delete_or) throws Exception;

}
