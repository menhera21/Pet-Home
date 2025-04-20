package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PFosterOrder;

/**
 * 宠物寄养订单，记录宠物寄养的相关信息Service接口
 * 
 * @author menhera
 * @date 2025-04-19
 */
public interface IPFosterOrderService 
{
    /**
     * 查询宠物寄养订单，记录宠物寄养的相关信息
     * 
     * @param fosterId 宠物寄养订单，记录宠物寄养的相关信息主键
     * @return 宠物寄养订单，记录宠物寄养的相关信息
     */
    public PFosterOrder selectPFosterOrderByFosterId(Long fosterId);

    /**
     * 查询宠物寄养订单，记录宠物寄养的相关信息列表
     * 
     * @param pFosterOrder 宠物寄养订单，记录宠物寄养的相关信息
     * @return 宠物寄养订单，记录宠物寄养的相关信息集合
     */
    public List<PFosterOrder> selectPFosterOrderList(PFosterOrder pFosterOrder);

    /**
     * 新增宠物寄养订单，记录宠物寄养的相关信息
     * 
     * @param pFosterOrder 宠物寄养订单，记录宠物寄养的相关信息
     * @return 结果
     */
    public int insertPFosterOrder(PFosterOrder pFosterOrder);

    /**
     * 修改宠物寄养订单，记录宠物寄养的相关信息
     * 
     * @param pFosterOrder 宠物寄养订单，记录宠物寄养的相关信息
     * @return 结果
     */
    public int updatePFosterOrder(PFosterOrder pFosterOrder);

    /**
     * 批量删除宠物寄养订单，记录宠物寄养的相关信息
     * 
     * @param fosterIds 需要删除的宠物寄养订单，记录宠物寄养的相关信息主键集合
     * @return 结果
     */
    public int deletePFosterOrderByFosterIds(Long[] fosterIds);

    /**
     * 删除宠物寄养订单，记录宠物寄养的相关信息信息
     * 
     * @param fosterId 宠物寄养订单，记录宠物寄养的相关信息主键
     * @return 结果
     */
    public int deletePFosterOrderByFosterId(Long fosterId);
}
