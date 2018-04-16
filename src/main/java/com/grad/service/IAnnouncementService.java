package com.grad.service;

import com.grad.entity.Announcement;
import com.grad.vo.AnnouncementListVo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: busis
 * @description: 公告业务逻辑相关接口类
 * @author: Mr.Chen
 * @create: 2018-04-16 13:54
 **/

@Transactional
public interface IAnnouncementService {

    /**
     * 添加公告
     * @param announcement
     *      title : 标题
     *      content ： 内容
     *      time ： 时间（默认为当前时间）
     *      user_id : 用户ID（默认为1）
     * @return
     * @throws Exception
     */
    public AnnouncementListVo insertAnnouncement(Announcement announcement) throws Exception;


    /**
     * 删除公告
     * @param announcement_id 公告ID
     * @return
     * @throws Exception
     */
    public AnnouncementListVo deleteAnnouncement(int announcement_id) throws Exception;


    /**
     * 获取公告信息列表
     * @param delete_or 是否删除
     * @return
     * @throws Exception
     */
    public AnnouncementListVo getAnnouncement(char delete_or) throws Exception;


}
