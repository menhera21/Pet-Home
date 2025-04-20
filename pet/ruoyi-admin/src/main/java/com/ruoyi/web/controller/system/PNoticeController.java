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
import com.ruoyi.system.domain.PNotice;
import com.ruoyi.system.service.IPNoticeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公告信息Controller
 *
 * @author menhera
 * @date 2025-04-19
 */
@RestController
@RequestMapping("/p/notice")
public class PNoticeController extends BaseController
{
    @Autowired
    private IPNoticeService pNoticeService;

    /**
     * 查询公告信息列表
     */
    @PreAuthorize("@ss.hasPermi('p:notice:list')")
    @GetMapping("/list")
    public TableDataInfo list(PNotice pNotice)
    {
        startPage();
        List<PNotice> list = pNoticeService.selectPNoticeList(pNotice);
        return getDataTable(list);
    }

    /**
     * 导出公告信息列表
     */
    @PreAuthorize("@ss.hasPermi('p:notice:export')")
    @Log(title = "公告信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PNotice pNotice)
    {
        List<PNotice> list = pNoticeService.selectPNoticeList(pNotice);
        ExcelUtil<PNotice> util = new ExcelUtil<PNotice>(PNotice.class);
        util.exportExcel(response, list, "公告信息数据");
    }

    /**
     * 获取公告信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('p:notice:query')")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable("noticeId") Long noticeId)
    {
        return success(pNoticeService.selectPNoticeByNoticeId(noticeId));
    }

    /**
     * 新增公告信息
     */
    @PreAuthorize("@ss.hasPermi('p:notice:add')")
    @Log(title = "公告信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PNotice pNotice)
    {
        return toAjax(pNoticeService.insertPNotice(pNotice));
    }

    /**
     * 修改公告信息
     */
    @PreAuthorize("@ss.hasPermi('p:notice:edit')")
    @Log(title = "公告信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PNotice pNotice)
    {
        return toAjax(pNoticeService.updatePNotice(pNotice));
    }

    /**
     * 删除公告信息
     */
    @PreAuthorize("@ss.hasPermi('p:notice:remove')")
    @Log(title = "公告信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds)
    {
        return toAjax(pNoticeService.deletePNoticeByNoticeIds(noticeIds));
    }
}
