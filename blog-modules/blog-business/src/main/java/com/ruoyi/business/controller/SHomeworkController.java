package com.ruoyi.business.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.common.log.annotation.Log;
import com.blog.common.log.enums.BusinessType;
import com.blog.common.security.annotation.RequiresPermissions;
import com.blog.business.domain.SHomework;
import com.blog.business.service.ISHomeworkService;
import com.blog.common.core.web.controller.BaseController;
import com.blog.common.core.web.domain.AjaxResult;
import com.blog.common.core.utils.poi.ExcelUtil;
import com.blog.common.core.web.page.TableDataInfo;

/**
 * 作业Controller
 *
 * @author BahetCoder
 * @date 2022-09-10
 */
@RestController
@RequestMapping("/leavehomework")
public class SHomeworkController extends BaseController
{
    @Autowired
    private ISHomeworkService sHomeworkService;

    /**
     * 查询作业列表
     */
    @RequiresPermissions("homework:leavehomework:list")
    @GetMapping("/list")
    public TableDataInfo list(SHomework sHomework)
    {
        startPage();
        List<SHomework> list = sHomeworkService.selectSHomeworkList(sHomework);
        return getDataTable(list);
    }

    /**
     * 导出作业列表
     */
    @RequiresPermissions("homework:leavehomework:export")
    @Log(title = "作业", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SHomework sHomework)
    {
        List<SHomework> list = sHomeworkService.selectSHomeworkList(sHomework);
        ExcelUtil<SHomework> util = new ExcelUtil<SHomework>(SHomework.class);
        util.exportExcel(response, list, "作业数据");
    }

    /**
     * 获取作业详细信息
     */
    @RequiresPermissions("homework:leavehomework:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sHomeworkService.selectSHomeworkById(id));
    }

    /**
     * 新增作业
     */
    @RequiresPermissions("homework:leavehomework:add")
    @Log(title = "作业", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SHomework sHomework)
    {
        return toAjax(sHomeworkService.insertSHomework(sHomework));
    }

    /**
     * 修改作业
     */
    @RequiresPermissions("homework:leavehomework:edit")
    @Log(title = "作业", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SHomework sHomework)
    {
        return toAjax(sHomeworkService.updateSHomework(sHomework));
    }

    /**
     * 删除作业
     */
    @RequiresPermissions("homework:leavehomework:remove")
    @Log(title = "作业", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sHomeworkService.deleteSHomeworkByIds(ids));
    }
}
