package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PSupplies;

/**
 * 用品名称Mapper接口
 * 
 * @author menhera
 * @date 2025-04-20
 */
public interface PSuppliesMapper 
{
    /**
     * 查询用品名称
     * 
     * @param supplyId 用品名称主键
     * @return 用品名称
     */
    public PSupplies selectPSuppliesBySupplyId(Long supplyId);

    /**
     * 查询用品名称列表
     * 
     * @param pSupplies 用品名称
     * @return 用品名称集合
     */
    public List<PSupplies> selectPSuppliesList(PSupplies pSupplies);

    /**
     * 新增用品名称
     * 
     * @param pSupplies 用品名称
     * @return 结果
     */
    public int insertPSupplies(PSupplies pSupplies);

    /**
     * 修改用品名称
     * 
     * @param pSupplies 用品名称
     * @return 结果
     */
    public int updatePSupplies(PSupplies pSupplies);

    /**
     * 删除用品名称
     * 
     * @param supplyId 用品名称主键
     * @return 结果
     */
    public int deletePSuppliesBySupplyId(Long supplyId);

    /**
     * 批量删除用品名称
     * 
     * @param supplyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePSuppliesBySupplyIds(Long[] supplyIds);
}
