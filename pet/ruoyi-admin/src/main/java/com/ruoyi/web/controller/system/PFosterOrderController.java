package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.system.domain.PFosterOrder;
import com.ruoyi.system.service.IPFosterOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宠物寄养订单，记录宠物寄养的相关信息Controller
 * 
 * @author menhera
 * @date 2025-04-19
 */
@RestController
@RequestMapping("/system/order")
public class PFosterOrderController extends BaseController
{
    @Autowired
    private IPFosterOrderService pFosterOrderService;

    /**
     * 查询宠物寄养订单，记录宠物寄养的相关信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(PFosterOrder pFosterOrder)
    {
        startPage();
        List<PFosterOrder> list = pFosterOrderService.selectPFosterOrderList(pFosterOrder);
        return getDataTable(list);
    }

    /**
     * 导出宠物寄养订单，记录宠物寄养的相关信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "宠物寄养订单，记录宠物寄养的相关信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PFosterOrder pFosterOrder)
    {
        List<PFosterOrder> list = pFosterOrderService.selectPFosterOrderList(pFosterOrder);
        ExcelUtil<PFosterOrder> util = new ExcelUtil<PFosterOrder>(PFosterOrder.class);
        util.exportExcel(response, list, "宠物寄养订单，记录宠物寄养的相关信息数据");
    }

    /**
     * 获取宠物寄养订单，记录宠物寄养的相关信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping(value = "/{fosterId}")
    public AjaxResult getInfo(@PathVariable("fosterId") Long fosterId)
    {
        return success(pFosterOrderService.selectPFosterOrderByFosterId(fosterId));
    }

    @Autowired
    private IPPetInfoService pPetInfoService;
    /**
     * 新增宠物寄养订单，记录宠物寄养的相关信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "宠物寄养订单，记录宠物寄养的相关信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PFosterOrder pFosterOrder)
    {
        int result = pFosterOrderService.insertPFosterOrder(pFosterOrder);
        if (result > 0) {
            // 创建宠物信息对象
            com.ruoyi.system.domain.PPetInfo pPetInfo = new com.ruoyi.system.domain.PPetInfo();
            pPetInfo.setName(pFosterOrder.getPetName());
            pPetInfo.setStatus(pFosterOrder.getFosterStatus());
            pPetInfo.setDescription("该宠物寄养中……");
            // 插入宠物信息
            pPetInfoService.insertPPetInfo(pPetInfo);
        }
        return toAjax(result);
    }

    /**
     * 修改宠物寄养订单，记录宠物寄养的相关信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "宠物寄养订单，记录宠物寄养的相关信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PFosterOrder pFosterOrder)
    {
        return toAjax(pFosterOrderService.updatePFosterOrder(pFosterOrder));
    }

    /**
     * 删除宠物寄养订单，记录宠物寄养的相关信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "宠物寄养订单，记录宠物寄养的相关信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fosterIds}")
    public AjaxResult remove(@PathVariable Long[] fosterIds)
    {
        return toAjax(pFosterOrderService.deletePFosterOrderByFosterIds(fosterIds));
    }
}
