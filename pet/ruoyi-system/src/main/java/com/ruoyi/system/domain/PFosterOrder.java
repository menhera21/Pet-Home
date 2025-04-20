package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宠物寄养订单，记录宠物寄养的相关信息对象 p_foster_order
 * 
 * @author menhera
 * @date 2025-04-19
 */
public class PFosterOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 寄养订单 ID */
    private Long fosterId;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 宠物昵称 */
    @Excel(name = "宠物昵称")
    private String petName;

    /** 寄养时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "寄养时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fosterTime;

    /** 寄养天数 */
    @Excel(name = "寄养天数")
    private Long fosterDays;

    /** 寄养状态 */
    @Excel(name = "寄养状态")
    private String fosterStatus;

    /** 寄养房间号 */
    @Excel(name = "寄养房间号")
    private String roomNumber;

    public void setFosterId(Long fosterId) 
    {
        this.fosterId = fosterId;
    }

    public Long getFosterId() 
    {
        return fosterId;
    }

    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }

    public void setPetName(String petName) 
    {
        this.petName = petName;
    }

    public String getPetName() 
    {
        return petName;
    }

    public void setFosterTime(Date fosterTime) 
    {
        this.fosterTime = fosterTime;
    }

    public Date getFosterTime() 
    {
        return fosterTime;
    }

    public void setFosterDays(Long fosterDays) 
    {
        this.fosterDays = fosterDays;
    }

    public Long getFosterDays() 
    {
        return fosterDays;
    }

    public void setFosterStatus(String fosterStatus) 
    {
        this.fosterStatus = fosterStatus;
    }

    public String getFosterStatus() 
    {
        return fosterStatus;
    }

    public void setRoomNumber(String roomNumber) 
    {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() 
    {
        return roomNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fosterId", getFosterId())
            .append("userName", getUserName())
            .append("petName", getPetName())
            .append("fosterTime", getFosterTime())
            .append("fosterDays", getFosterDays())
            .append("fosterStatus", getFosterStatus())
            .append("roomNumber", getRoomNumber())
            .toString();
    }
}
