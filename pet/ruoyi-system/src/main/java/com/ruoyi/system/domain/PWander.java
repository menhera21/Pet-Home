package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 流浪动物对象 p_wander
 * 
 * @author menhera
 * @date 2025-04-21
 */
public class PWander extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 流浪动物唯一标识ID */
    private Long wanderId;

    /** 动物图片 */
    @Excel(name = "动物图片")
    private String imagePath;

    /** 发现宠物的详细情况说明 */
    @Excel(name = "发现宠物的详细情况说明")
    private String reportDesc;

    /** 上报人用户名 */
    @Excel(name = "上报人用户名")
    private String userName;

    /** 上报时间（自动记录提交时间） */
    @Excel(name = "上报时间", readConverterExp = "自=动记录提交时间")
    private Date reportTime;

    /** 当前处理状态 */
    @Excel(name = "当前处理状态")
    private String status;

    /** 发现人的电话号码 */
    @Excel(name = "发现人的电话号码")
    private String phonenumber;

    /** 发现地点的详细文字描述 */
    @Excel(name = "发现地点的详细文字描述")
    private String discoveryLocation;

    /** 关联宠物信息的宠物id */
    private Long petId;

    public void setWanderId(Long wanderId) 
    {
        this.wanderId = wanderId;
    }

    public Long getWanderId() 
    {
        return wanderId;
    }

    public void setImagePath(String imagePath) 
    {
        this.imagePath = imagePath;
    }

    public String getImagePath() 
    {
        return imagePath;
    }

    public void setReportDesc(String reportDesc) 
    {
        this.reportDesc = reportDesc;
    }

    public String getReportDesc() 
    {
        return reportDesc;
    }

    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }

    public void setReportTime(Date reportTime) 
    {
        this.reportTime = reportTime;
    }

    public Date getReportTime() 
    {
        return reportTime;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }

    public void setDiscoveryLocation(String discoveryLocation) 
    {
        this.discoveryLocation = discoveryLocation;
    }

    public String getDiscoveryLocation() 
    {
        return discoveryLocation;
    }

    public void setPetId(Long petId) 
    {
        this.petId = petId;
    }

    public Long getPetId() 
    {
        return petId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("wanderId", getWanderId())
            .append("imagePath", getImagePath())
            .append("reportDesc", getReportDesc())
            .append("userName", getUserName())
            .append("reportTime", getReportTime())
            .append("status", getStatus())
            .append("phonenumber", getPhonenumber())
            .append("discoveryLocation", getDiscoveryLocation())
            .append("petId", getPetId())
            .toString();
    }
}
