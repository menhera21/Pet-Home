package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PSuppliesMapper;
import com.ruoyi.system.domain.PSupplies;
import com.ruoyi.system.service.IPSuppliesService;

/**
 * 用品名称Service业务层处理
 * 
 * @author menhera
 * @date 2025-04-20
 */
@Service
public class PSuppliesServiceImpl implements IPSuppliesService 
{
    @Autowired
    private PSuppliesMapper pSuppliesMapper;

    /**
     * 查询用品名称
     * 
     * @param supplyId 用品名称主键
     * @return 用品名称
     */
    @Override
    public PSupplies selectPSuppliesBySupplyId(Long supplyId)
    {
        return pSuppliesMapper.selectPSuppliesBySupplyId(supplyId);
    }

    /**
     * 查询用品名称列表
     * 
     * @param pSupplies 用品名称
     * @return 用品名称
     */
    @Override
    public List<PSupplies> selectPSuppliesList(PSupplies pSupplies)
    {
        return pSuppliesMapper.selectPSuppliesList(pSupplies);
    }

    /**
     * 新增用品名称
     * 
     * @param pSupplies 用品名称
     * @return 结果
     */
    @Override
    public int insertPSupplies(PSupplies pSupplies)
    {
        return pSuppliesMapper.insertPSupplies(pSupplies);
    }

    /**
     * 修改用品名称
     * 
     * @param pSupplies 用品名称
     * @return 结果
     */
    @Override
    public int updatePSupplies(PSupplies pSupplies)
    {
        return pSuppliesMapper.updatePSupplies(pSupplies);
    }

    /**
     * 批量删除用品名称
     * 
     * @param supplyIds 需要删除的用品名称主键
     * @return 结果
     */
    @Override
    public int deletePSuppliesBySupplyIds(Long[] supplyIds)
    {
        return pSuppliesMapper.deletePSuppliesBySupplyIds(supplyIds);
    }

    /**
     * 删除用品名称信息
     * 
     * @param supplyId 用品名称主键
     * @return 结果
     */
    @Override
    public int deletePSuppliesBySupplyId(Long supplyId)
    {
        return pSuppliesMapper.deletePSuppliesBySupplyId(supplyId);
    }
}
