package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PWander;

/**
 * 流浪动物Mapper接口
 * 
 * @author menhera
 * @date 2025-04-21
 */
public interface PWanderMapper 
{
    /**
     * 查询流浪动物
     * 
     * @param wanderId 流浪动物主键
     * @return 流浪动物
     */
    public PWander selectPWanderByWanderId(Long wanderId);

    /**
     * 查询流浪动物列表
     * 
     * @param pWander 流浪动物
     * @return 流浪动物集合
     */
    public List<PWander> selectPWanderList(PWander pWander);

    /**
     * 新增流浪动物
     * 
     * @param pWander 流浪动物
     * @return 结果
     */
    public int insertPWander(PWander pWander);

    /**
     * 修改流浪动物
     * 
     * @param pWander 流浪动物
     * @return 结果
     */
    public int updatePWander(PWander pWander);

    /**
     * 删除流浪动物
     * 
     * @param wanderId 流浪动物主键
     * @return 结果
     */
    public int deletePWanderByWanderId(Long wanderId);

    /**
     * 批量删除流浪动物
     * 
     * @param wanderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePWanderByWanderIds(Long[] wanderIds);
}
