package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PNotice;

/**
 * 公告信息Service接口
 * 
 * @author menhera
 * @date 2025-04-19
 */
public interface IPNoticeService 
{
    /**
     * 查询公告信息
     * 
     * @param noticeId 公告信息主键
     * @return 公告信息
     */
    public PNotice selectPNoticeByNoticeId(Long noticeId);

    /**
     * 查询公告信息列表
     * 
     * @param pNotice 公告信息
     * @return 公告信息集合
     */
    public List<PNotice> selectPNoticeList(PNotice pNotice);

    /**
     * 新增公告信息
     * 
     * @param pNotice 公告信息
     * @return 结果
     */
    public int insertPNotice(PNotice pNotice);

    /**
     * 修改公告信息
     * 
     * @param pNotice 公告信息
     * @return 结果
     */
    public int updatePNotice(PNotice pNotice);

    /**
     * 批量删除公告信息
     * 
     * @param noticeIds 需要删除的公告信息主键集合
     * @return 结果
     */
    public int deletePNoticeByNoticeIds(Long[] noticeIds);

    /**
     * 删除公告信息信息
     * 
     * @param noticeId 公告信息主键
     * @return 结果
     */
    public int deletePNoticeByNoticeId(Long noticeId);
}
