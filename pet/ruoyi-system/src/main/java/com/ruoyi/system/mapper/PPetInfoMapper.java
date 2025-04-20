package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PPetInfo;
import org.apache.ibatis.annotations.Select;

/**
 * 宠物信息Mapper接口
 * 
 * @author menhera
 * @date 2025-04-19
 */
public interface PPetInfoMapper 
{
    /**
     * 查询宠物信息
     * 
     * @param petId 宠物信息主键
     * @return 宠物信息
     */
    public PPetInfo selectPPetInfoByPetId(Long petId);

    /**
     * 查询宠物信息列表
     * 
     * @param pPetInfo 宠物信息
     * @return 宠物信息集合
     */
    public List<PPetInfo> selectPPetInfoList(PPetInfo pPetInfo);

    /**
     * 新增宠物信息
     * 
     * @param pPetInfo 宠物信息
     * @return 结果
     */
    public int insertPPetInfo(PPetInfo pPetInfo);

    /**
     * 修改宠物信息
     * 
     * @param pPetInfo 宠物信息
     * @return 结果
     */
    public int updatePPetInfo(PPetInfo pPetInfo);

    /**
     * 删除宠物信息
     * 
     * @param petId 宠物信息主键
     * @return 结果
     */
    public int deletePPetInfoByPetId(Long petId);

    /**
     * 批量删除宠物信息
     * 
     * @param petIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePPetInfoByPetIds(Long[] petIds);

    // 获取最大主键
    @Select("select MAX(pet_id) from p_pet_info")
    Long getMaxPetId();
}
