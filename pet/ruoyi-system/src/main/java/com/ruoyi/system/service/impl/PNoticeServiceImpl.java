package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PNoticeMapper;
import com.ruoyi.system.domain.PNotice;
import com.ruoyi.system.service.IPNoticeService;

/**
 * 公告信息Service业务层处理
 * 
 * @author menhera
 * @date 2025-04-19
 */
@Service
public class PNoticeServiceImpl implements IPNoticeService 
{
    @Autowired
    private PNoticeMapper pNoticeMapper;

    /**
     * 查询公告信息
     * 
     * @param noticeId 公告信息主键
     * @return 公告信息
     */
    @Override
    public PNotice selectPNoticeByNoticeId(Long noticeId)
    {
        return pNoticeMapper.selectPNoticeByNoticeId(noticeId);
    }

    /**
     * 查询公告信息列表
     * 
     * @param pNotice 公告信息
     * @return 公告信息
     */
    @Override
    public List<PNotice> selectPNoticeList(PNotice pNotice)
    {
        return pNoticeMapper.selectPNoticeList(pNotice);
    }

    /**
     * 新增公告信息
     * 
     * @param pNotice 公告信息
     * @return 结果
     */
    @Override
    public int insertPNotice(PNotice pNotice)
    {
        pNotice.setCreateTime(DateUtils.getNowDate());
        return pNoticeMapper.insertPNotice(pNotice);
    }

    /**
     * 修改公告信息
     * 
     * @param pNotice 公告信息
     * @return 结果
     */
    @Override
    public int updatePNotice(PNotice pNotice)
    {
        return pNoticeMapper.updatePNotice(pNotice);
    }

    /**
     * 批量删除公告信息
     * 
     * @param noticeIds 需要删除的公告信息主键
     * @return 结果
     */
    @Override
    public int deletePNoticeByNoticeIds(Long[] noticeIds)
    {
        return pNoticeMapper.deletePNoticeByNoticeIds(noticeIds);
    }

    /**
     * 删除公告信息信息
     * 
     * @param noticeId 公告信息主键
     * @return 结果
     */
    @Override
    public int deletePNoticeByNoticeId(Long noticeId)
    {
        return pNoticeMapper.deletePNoticeByNoticeId(noticeId);
    }
}
