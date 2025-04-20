package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PWanderMapper;
import com.ruoyi.system.domain.PWander;
import com.ruoyi.system.service.IPWanderService;

/**
 * 流浪动物Service业务层处理
 * 
 * @author menhera
 * @date 2025-04-21
 */
@Service
public class PWanderServiceImpl implements IPWanderService 
{
    @Autowired
    private PWanderMapper pWanderMapper;

    /**
     * 查询流浪动物
     * 
     * @param wanderId 流浪动物主键
     * @return 流浪动物
     */
    @Override
    public PWander selectPWanderByWanderId(Long wanderId)
    {
        return pWanderMapper.selectPWanderByWanderId(wanderId);
    }

    /**
     * 查询流浪动物列表
     * 
     * @param pWander 流浪动物
     * @return 流浪动物
     */
    @Override
    public List<PWander> selectPWanderList(PWander pWander)
    {
        return pWanderMapper.selectPWanderList(pWander);
    }

    /**
     * 新增流浪动物
     * 
     * @param pWander 流浪动物
     * @return 结果
     */
    @Override
    public int insertPWander(PWander pWander)
    {
        return pWanderMapper.insertPWander(pWander);
    }

    /**
     * 修改流浪动物
     * 
     * @param pWander 流浪动物
     * @return 结果
     */
    @Override
    public int updatePWander(PWander pWander)
    {
        return pWanderMapper.updatePWander(pWander);
    }

    /**
     * 批量删除流浪动物
     * 
     * @param wanderIds 需要删除的流浪动物主键
     * @return 结果
     */
    @Override
    public int deletePWanderByWanderIds(Long[] wanderIds)
    {
        return pWanderMapper.deletePWanderByWanderIds(wanderIds);
    }

    /**
     * 删除流浪动物信息
     * 
     * @param wanderId 流浪动物主键
     * @return 结果
     */
    @Override
    public int deletePWanderByWanderId(Long wanderId)
    {
        return pWanderMapper.deletePWanderByWanderId(wanderId);
    }
}
