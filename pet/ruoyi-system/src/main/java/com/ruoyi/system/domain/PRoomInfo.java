package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间信息对象 p_room_info
 * 
 * @author menhera
 * @date 2025-04-20
 */
public class PRoomInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房间ID */
    private Long roomId;

    /** 房间编号 */
    @Excel(name = "房间编号")
    private String roomNumber;

    /** 容纳数量 */
    @Excel(name = "容纳数量")
    private Long capacity;

    /** 当前宠物数 */
    @Excel(name = "当前宠物数")
    private Long currentPets;

    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }

    public void setRoomNumber(String roomNumber) 
    {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() 
    {
        return roomNumber;
    }

    public void setCapacity(Long capacity) 
    {
        this.capacity = capacity;
    }

    public Long getCapacity() 
    {
        return capacity;
    }

    public void setCurrentPets(Long currentPets) 
    {
        this.currentPets = currentPets;
    }

    public Long getCurrentPets() 
    {
        return currentPets;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roomId", getRoomId())
            .append("roomNumber", getRoomNumber())
            .append("capacity", getCapacity())
            .append("currentPets", getCurrentPets())
            .toString();
    }
}
