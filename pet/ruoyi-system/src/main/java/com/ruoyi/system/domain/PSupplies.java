package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用品名称对象 p_supplies
 * 
 * @author menhera
 * @date 2025-04-20
 */
public class PSupplies extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Long supplyId;

    /** 图片路径，格式如/images/supplies/DogFood.png */
    @Excel(name = "图片路径，格式如/images/supplies/DogFood.png")
    private String imagePath;

    /** 商品价格（单位：元） */
    @Excel(name = "商品价格", readConverterExp = "单=位：元")
    private BigDecimal price;

    /** 库存余量 */
    @Excel(name = "库存余量")
    private String stock;

    /** 用品名称（如：狗粮） */
    @Excel(name = "用品名称", readConverterExp = "如=：狗粮")
    private String name;

    public void setSupplyId(Long supplyId) 
    {
        this.supplyId = supplyId;
    }

    public Long getSupplyId() 
    {
        return supplyId;
    }

    public void setImagePath(String imagePath) 
    {
        this.imagePath = imagePath;
    }

    public String getImagePath() 
    {
        return imagePath;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setStock(String stock) 
    {
        this.stock = stock;
    }

    public String getStock() 
    {
        return stock;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("supplyId", getSupplyId())
            .append("imagePath", getImagePath())
            .append("price", getPrice())
            .append("stock", getStock())
            .append("name", getName())
            .toString();
    }
}
