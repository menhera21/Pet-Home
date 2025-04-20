package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宠物信息对象 p_pet_info
 * 
 * @author menhera
 * @date 2025-04-19
 */
public class PPetInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 宠物ID */
    private Long petId;

    /** 宠物名称 */
    @Excel(name = "宠物名称")
    private String name;

    /** 宠物类型（猫/狗等） */
    @Excel(name = "宠物类型", readConverterExp = "猫=/狗等")
    private String type;

    /** 性别（公/母） */
    @Excel(name = "性别", readConverterExp = "公=/母")
    private String gender;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 状态（待领养/已领养） */
    @Excel(name = "状态", readConverterExp = "待=领养/已领养")
    private String status;

    /** 宠物图片URL */
    @Excel(name = "宠物图片URL")
    private String imageUrl;

    /** 宠物描述 */
    @Excel(name = "宠物描述")
    private String description;

    public void setPetId(Long petId) 
    {
        this.petId = petId;
    }

    public Long getPetId() 
    {
        return petId;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("petId", getPetId())
            .append("name", getName())
            .append("type", getType())
            .append("gender", getGender())
            .append("age", getAge())
            .append("status", getStatus())
            .append("imageUrl", getImageUrl())
            .append("description", getDescription())
            .append("createTime", getCreateTime())
            .toString();
    }
}
