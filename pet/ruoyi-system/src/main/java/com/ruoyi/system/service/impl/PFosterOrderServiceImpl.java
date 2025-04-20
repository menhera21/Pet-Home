package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PFosterOrderMapper;
import com.ruoyi.system.domain.PFosterOrder;
import com.ruoyi.system.service.IPFosterOrderService;

/**
 * 宠物寄养订单，记录宠物寄养的相关信息Service业务层处理
 * 
 * @author menhera
 * @date 2025-04-19
 */
@Service
public class PFosterOrderServiceImpl implements IPFosterOrderService 
{
    @Autowired
    private PFosterOrderMapper pFosterOrderMapper;

    /**
     * 查询宠物寄养订单，记录宠物寄养的相关信息
     * 
     * @param fosterId 宠物寄养订单，记录宠物寄养的相关信息主键
     * @return 宠物寄养订单，记录宠物寄养的相关信息
     */
    @Override
    public PFosterOrder selectPFosterOrderByFosterId(Long fosterId)
    {
        return pFosterOrderMapper.selectPFosterOrderByFosterId(fosterId);
    }

    /**
     * 查询宠物寄养订单，记录宠物寄养的相关信息列表
     * 
     * @param pFosterOrder 宠物寄养订单，记录宠物寄养的相关信息
     * @return 宠物寄养订单，记录宠物寄养的相关信息
     */
    @Override
    public List<PFosterOrder> selectPFosterOrderList(PFosterOrder pFosterOrder)
    {
        return pFosterOrderMapper.selectPFosterOrderList(pFosterOrder);
    }

    /**
     * 新增宠物寄养订单，记录宠物寄养的相关信息
     * 
     * @param pFosterOrder 宠物寄养订单，记录宠物寄养的相关信息
     * @return 结果
     */
    @Override
    public int insertPFosterOrder(PFosterOrder pFosterOrder)
    {
        return pFosterOrderMapper.insertPFosterOrder(pFosterOrder);
    }

    /**
     * 修改宠物寄养订单，记录宠物寄养的相关信息
     * 
     * @param pFosterOrder 宠物寄养订单，记录宠物寄养的相关信息
     * @return 结果
     */
    @Override
    public int updatePFosterOrder(PFosterOrder pFosterOrder)
    {
        return pFosterOrderMapper.updatePFosterOrder(pFosterOrder);
    }

    /**
     * 批量删除宠物寄养订单，记录宠物寄养的相关信息
     * 
     * @param fosterIds 需要删除的宠物寄养订单，记录宠物寄养的相关信息主键
     * @return 结果
     */
    @Override
    public int deletePFosterOrderByFosterIds(Long[] fosterIds)
    {
        return pFosterOrderMapper.deletePFosterOrderByFosterIds(fosterIds);
    }

    /**
     * 删除宠物寄养订单，记录宠物寄养的相关信息信息
     * 
     * @param fosterId 宠物寄养订单，记录宠物寄养的相关信息主键
     * @return 结果
     */
    @Override
    public int deletePFosterOrderByFosterId(Long fosterId)
    {
        return pFosterOrderMapper.deletePFosterOrderByFosterId(fosterId);
    }
}
