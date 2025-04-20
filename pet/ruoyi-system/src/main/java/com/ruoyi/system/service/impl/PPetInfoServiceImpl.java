package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PPetInfoMapper;
import com.ruoyi.system.domain.PPetInfo;
import com.ruoyi.system.service.IPPetInfoService;

/**
 * 宠物信息Service业务层处理
 * 
 * @author menhera
 * @date 2025-04-19
 */
@Service
public class PPetInfoServiceImpl implements IPPetInfoService 
{
    @Autowired
    private PPetInfoMapper pPetInfoMapper;

    /**
     * 查询宠物信息
     * 
     * @param petId 宠物信息主键
     * @return 宠物信息
     */
    @Override
    public PPetInfo selectPPetInfoByPetId(Long petId)
    {
        return pPetInfoMapper.selectPPetInfoByPetId(petId);
    }

    /**
     * 查询宠物信息列表
     * 
     * @param pPetInfo 宠物信息
     * @return 宠物信息
     */
    @Override
    public List<PPetInfo> selectPPetInfoList(PPetInfo pPetInfo)
    {
        return pPetInfoMapper.selectPPetInfoList(pPetInfo);
    }

    /**
     * 新增宠物信息
     * 
     * @param pPetInfo 宠物信息
     * @return 结果
     */
    @Override
    public int insertPPetInfo(PPetInfo pPetInfo)
    {
        pPetInfo.setCreateTime(DateUtils.getNowDate());
        return pPetInfoMapper.insertPPetInfo(pPetInfo);
    }

    /**
     * 修改宠物信息
     * 
     * @param pPetInfo 宠物信息
     * @return 结果
     */
    @Override
    public int updatePPetInfo(PPetInfo pPetInfo)
    {
        return pPetInfoMapper.updatePPetInfo(pPetInfo);
    }

    /**
     * 批量删除宠物信息
     * 
     * @param petIds 需要删除的宠物信息主键
     * @return 结果
     */
    @Override
    public int deletePPetInfoByPetIds(Long[] petIds)
    {
        return pPetInfoMapper.deletePPetInfoByPetIds(petIds);
    }

    /**
     * 删除宠物信息信息
     * 
     * @param petId 宠物信息主键
     * @return 结果
     */
    @Override
    public int deletePPetInfoByPetId(Long petId)
    {
        return pPetInfoMapper.deletePPetInfoByPetId(petId);
    }

    // 获取最大主键
    public Long getMaxPetId() {
        return pPetInfoMapper.getMaxPetId();
    }
}
