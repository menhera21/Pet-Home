package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PRoomInfo;

/**
 * 房间信息Service接口
 * 
 * @author menhera
 * @date 2025-04-20
 */
public interface IPRoomInfoService 
{
    /**
     * 查询房间信息
     * 
     * @param roomId 房间信息主键
     * @return 房间信息
     */
    public PRoomInfo selectPRoomInfoByRoomId(Long roomId);

    /**
     * 查询房间信息列表
     * 
     * @param pRoomInfo 房间信息
     * @return 房间信息集合
     */
    public List<PRoomInfo> selectPRoomInfoList(PRoomInfo pRoomInfo);

    /**
     * 新增房间信息
     * 
     * @param pRoomInfo 房间信息
     * @return 结果
     */
    public int insertPRoomInfo(PRoomInfo pRoomInfo);

    /**
     * 修改房间信息
     * 
     * @param pRoomInfo 房间信息
     * @return 结果
     */
    public int updatePRoomInfo(PRoomInfo pRoomInfo);

    /**
     * 批量删除房间信息
     * 
     * @param roomIds 需要删除的房间信息主键集合
     * @return 结果
     */
    public int deletePRoomInfoByRoomIds(Long[] roomIds);

    /**
     * 删除房间信息信息
     * 
     * @param roomId 房间信息主键
     * @return 结果
     */
    public int deletePRoomInfoByRoomId(Long roomId);
}
