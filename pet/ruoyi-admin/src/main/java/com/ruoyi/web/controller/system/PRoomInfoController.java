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
import com.ruoyi.system.domain.PRoomInfo;
import com.ruoyi.system.service.IPRoomInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房间信息Controller
 * 
 * @author menhera
 * @date 2025-04-20
 */
@RestController
@RequestMapping("/system/roomInfo")
public class PRoomInfoController extends BaseController
{
    @Autowired
    private IPRoomInfoService pRoomInfoService;

    /**
     * 查询房间信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:roomInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(PRoomInfo pRoomInfo)
    {
        startPage();
        List<PRoomInfo> list = pRoomInfoService.selectPRoomInfoList(pRoomInfo);
        return getDataTable(list);
    }

    /**
     * 导出房间信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:roomInfo:export')")
    @Log(title = "房间信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PRoomInfo pRoomInfo)
    {
        List<PRoomInfo> list = pRoomInfoService.selectPRoomInfoList(pRoomInfo);
        ExcelUtil<PRoomInfo> util = new ExcelUtil<PRoomInfo>(PRoomInfo.class);
        util.exportExcel(response, list, "房间信息数据");
    }

    /**
     * 获取房间信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:roomInfo:query')")
    @GetMapping(value = "/{roomId}")
    public AjaxResult getInfo(@PathVariable("roomId") Long roomId)
    {
        return success(pRoomInfoService.selectPRoomInfoByRoomId(roomId));
    }

    /**
     * 新增房间信息
     */
    @PreAuthorize("@ss.hasPermi('system:roomInfo:add')")
    @Log(title = "房间信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PRoomInfo pRoomInfo)
    {
        return toAjax(pRoomInfoService.insertPRoomInfo(pRoomInfo));
    }

    /**
     * 修改房间信息
     */
    @PreAuthorize("@ss.hasPermi('system:roomInfo:edit')")
    @Log(title = "房间信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PRoomInfo pRoomInfo)
    {
        return toAjax(pRoomInfoService.updatePRoomInfo(pRoomInfo));
    }

    /**
     * 删除房间信息
     */
    @PreAuthorize("@ss.hasPermi('system:roomInfo:remove')")
    @Log(title = "房间信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roomIds}")
    public AjaxResult remove(@PathVariable Long[] roomIds)
    {
        return toAjax(pRoomInfoService.deletePRoomInfoByRoomIds(roomIds));
    }
}
