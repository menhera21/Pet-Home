package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PFosterOrder;

/**
 * 宠物寄养订单，记录宠物寄养的相关信息Mapper接口
 * 
 * @author menhera
 * @date 2025-04-19
 */
public interface PFosterOrderMapper 
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
     * 删除宠物寄养订单，记录宠物寄养的相关信息
     * 
     * @param fosterId 宠物寄养订单，记录宠物寄养的相关信息主键
     * @return 结果
     */
    public int deletePFosterOrderByFosterId(Long fosterId);

    /**
     * 批量删除宠物寄养订单，记录宠物寄养的相关信息
     * 
     * @param fosterIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePFosterOrderByFosterIds(Long[] fosterIds);
}
