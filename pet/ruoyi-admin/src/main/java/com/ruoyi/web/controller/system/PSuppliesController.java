package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PSupplies;
import com.ruoyi.system.service.IPSuppliesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用品名称Controller
 * 
 * @author menhera
 * @date 2025-04-20
 */
@RestController
@RequestMapping("/system/supplies")
public class PSuppliesController extends BaseController
{
    @Autowired
    private IPSuppliesService pSuppliesService;

    /**
     * 查询用品名称列表
     */
    @PreAuthorize("@ss.hasPermi('system:supplies:list')")
    @GetMapping("/list")
    public TableDataInfo list(PSupplies pSupplies)
    {
        startPage();
        List<PSupplies> list = pSuppliesService.selectPSuppliesList(pSupplies);
        return getDataTable(list);
    }

    /**
     * 导出用品名称列表
     */
    @PreAuthorize("@ss.hasPermi('system:supplies:export')")
    @Log(title = "用品名称", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PSupplies pSupplies)
    {
        List<PSupplies> list = pSuppliesService.selectPSuppliesList(pSupplies);
        ExcelUtil<PSupplies> util = new ExcelUtil<PSupplies>(PSupplies.class);
        util.exportExcel(response, list, "用品名称数据");
    }

    /**
     * 获取用品名称详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:supplies:query')")
    @GetMapping(value = "/{supplyId}")
    public AjaxResult getInfo(@PathVariable("supplyId") Long supplyId)
    {
        return success(pSuppliesService.selectPSuppliesBySupplyId(supplyId));
    }

    /**
     * 新增用品名称
     */
    @PreAuthorize("@ss.hasPermi('system:supplies:add')")
    @Log(title = "用品名称", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PSupplies pSupplies)
    {
        return toAjax(pSuppliesService.insertPSupplies(pSupplies));
    }

    /**
     * 修改用品名称
     */
    @PreAuthorize("@ss.hasPermi('system:supplies:edit')")
    @Log(title = "用品名称", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PSupplies pSupplies)
    {
        return toAjax(pSuppliesService.updatePSupplies(pSupplies));
    }

    /**
     * 删除用品名称
     */
    @PreAuthorize("@ss.hasPermi('system:supplies:remove')")
    @Log(title = "用品名称", businessType = BusinessType.DELETE)
	@DeleteMapping("/{supplyIds}")
    public AjaxResult remove(@PathVariable Long[] supplyIds)
    {
        return toAjax(pSuppliesService.deletePSuppliesBySupplyIds(supplyIds));
    }
}
