package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PRoomInfoMapper;
import com.ruoyi.system.domain.PRoomInfo;
import com.ruoyi.system.service.IPRoomInfoService;

/**
 * 房间信息Service业务层处理
 * 
 * @author menhera
 * @date 2025-04-20
 */
@Service
public class PRoomInfoServiceImpl implements IPRoomInfoService 
{
    @Autowired
    private PRoomInfoMapper pRoomInfoMapper;

    /**
     * 查询房间信息
     * 
     * @param roomId 房间信息主键
     * @return 房间信息
     */
    @Override
    public PRoomInfo selectPRoomInfoByRoomId(Long roomId)
    {
        return pRoomInfoMapper.selectPRoomInfoByRoomId(roomId);
    }

    /**
     * 查询房间信息列表
     * 
     * @param pRoomInfo 房间信息
     * @return 房间信息
     */
    @Override
    public List<PRoomInfo> selectPRoomInfoList(PRoomInfo pRoomInfo)
    {
        return pRoomInfoMapper.selectPRoomInfoList(pRoomInfo);
    }

    /**
     * 新增房间信息
     * 
     * @param pRoomInfo 房间信息
     * @return 结果
     */
    @Override
    public int insertPRoomInfo(PRoomInfo pRoomInfo)
    {
        return pRoomInfoMapper.insertPRoomInfo(pRoomInfo);
    }

    /**
     * 修改房间信息
     * 
     * @param pRoomInfo 房间信息
     * @return 结果
     */
    @Override
    public int updatePRoomInfo(PRoomInfo pRoomInfo)
    {
        return pRoomInfoMapper.updatePRoomInfo(pRoomInfo);
    }

    /**
     * 批量删除房间信息
     * 
     * @param roomIds 需要删除的房间信息主键
     * @return 结果
     */
    @Override
    public int deletePRoomInfoByRoomIds(Long[] roomIds)
    {
        return pRoomInfoMapper.deletePRoomInfoByRoomIds(roomIds);
    }

    /**
     * 删除房间信息信息
     * 
     * @param roomId 房间信息主键
     * @return 结果
     */
    @Override
    public int deletePRoomInfoByRoomId(Long roomId)
    {
        return pRoomInfoMapper.deletePRoomInfoByRoomId(roomId);
    }
}
