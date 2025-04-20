package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.PPetInfo;
import com.ruoyi.system.service.IPPetInfoService;
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
import com.ruoyi.system.domain.PWander;
import com.ruoyi.system.service.IPWanderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 流浪动物Controller
 * 
 * @author menhera
 * @date 2025-04-21
 */
@RestController
@RequestMapping("/system/wander")
public class PWanderController extends BaseController
{
    @Autowired
    private IPWanderService pWanderService;

    /**
     * 查询流浪动物列表
     */
    @PreAuthorize("@ss.hasPermi('system:wander:list')")
    @GetMapping("/list")
    public TableDataInfo list(PWander pWander)
    {
        startPage();
        List<PWander> list = pWanderService.selectPWanderList(pWander);
        return getDataTable(list);
    }

    /**
     * 导出流浪动物列表
     */
    @PreAuthorize("@ss.hasPermi('system:wander:export')")
    @Log(title = "流浪动物", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PWander pWander)
    {
        List<PWander> list = pWanderService.selectPWanderList(pWander);
        ExcelUtil<PWander> util = new ExcelUtil<PWander>(PWander.class);
        util.exportExcel(response, list, "流浪动物数据");
    }

    /**
     * 获取流浪动物详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:wander:query')")
    @GetMapping(value = "/{wanderId}")
    public AjaxResult getInfo(@PathVariable("wanderId") Long wanderId)
    {
        return success(pWanderService.selectPWanderByWanderId(wanderId));
    }

    @Autowired
    private IPPetInfoService pPetInfoService;
    /**
     * 新增流浪动物
     */
    @PreAuthorize("@ss.hasPermi('system:wander:add')")
    @Log(title = "流浪动物", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PWander pWander)
    {
        // 同步新增
        PPetInfo pPetInfo = new PPetInfo();
        pPetInfo.setStatus(pWander.getStatus());
        pPetInfo.setDescription("流浪中……求收留");
        pPetInfoService.insertPPetInfo(pPetInfo);
        pWander.setPetId(pPetInfoService.getMaxPetId());
        return toAjax(pWanderService.insertPWander(pWander));
    }

    /**
     * 修改流浪动物
     */
    @PreAuthorize("@ss.hasPermi('system:wander:edit')")
    @Log(title = "流浪动物", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PWander pWander)
    {
        // 同步修改
        PPetInfo pPetInfo = new PPetInfo();
        pPetInfo.setPetId(pWander.getPetId());
        pPetInfo.setImageUrl(pWander.getImagePath());
        pPetInfo.setStatus(pWander.getStatus());
        pPetInfo.setDescription(pWander.getReportDesc());
        pPetInfoService.updatePPetInfo(pPetInfo);
        return toAjax(pWanderService.updatePWander(pWander));
    }

    /**
     * 删除流浪动物
     */
    @PreAuthorize("@ss.hasPermi('system:wander:remove')")
    @Log(title = "流浪动物", businessType = BusinessType.DELETE)
	@DeleteMapping("/{wanderIds}")
    public AjaxResult remove(@PathVariable Long[] wanderIds)
    {
        return toAjax(pWanderService.deletePWanderByWanderIds(wanderIds));
    }
}
