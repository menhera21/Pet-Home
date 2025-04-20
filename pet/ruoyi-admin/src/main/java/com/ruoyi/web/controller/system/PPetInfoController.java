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
import com.ruoyi.system.domain.PPetInfo;
import com.ruoyi.system.service.IPPetInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宠物信息Controller
 * 
 * @author menhera
 * @date 2025-04-19
 */
@RestController
@RequestMapping("/system/info")
public class PPetInfoController extends BaseController
{
    @Autowired
    private IPPetInfoService pPetInfoService;

    /**
     * 查询宠物信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(PPetInfo pPetInfo)
    {
        startPage();
        List<PPetInfo> list = pPetInfoService.selectPPetInfoList(pPetInfo);
        return getDataTable(list);
    }

    /**
     * 导出宠物信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "宠物信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PPetInfo pPetInfo)
    {
        List<PPetInfo> list = pPetInfoService.selectPPetInfoList(pPetInfo);
        ExcelUtil<PPetInfo> util = new ExcelUtil<PPetInfo>(PPetInfo.class);
        util.exportExcel(response, list, "宠物信息数据");
    }

    /**
     * 获取宠物信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{petId}")
    public AjaxResult getInfo(@PathVariable("petId") Long petId)
    {
        return success(pPetInfoService.selectPPetInfoByPetId(petId));
    }

    /**
     * 新增宠物信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "宠物信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PPetInfo pPetInfo)
    {
        return toAjax(pPetInfoService.insertPPetInfo(pPetInfo));
    }

    /**
     * 修改宠物信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "宠物信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PPetInfo pPetInfo)
    {
        return toAjax(pPetInfoService.updatePPetInfo(pPetInfo));
    }

    /**
     * 删除宠物信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "宠物信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{petIds}")
    public AjaxResult remove(@PathVariable Long[] petIds)
    {
        return toAjax(pPetInfoService.deletePPetInfoByPetIds(petIds));
    }
}
