package com.ruoyi.business.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.blog.common.security.utils.SecurityUtils;
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
import com.blog.business.domain.SStudentHomework;
import com.blog.business.service.ISStudentHomeworkService;
import com.blog.common.core.web.controller.BaseController;
import com.blog.common.core.web.domain.AjaxResult;
import com.blog.common.core.utils.poi.ExcelUtil;
import com.blog.common.core.web.page.TableDataInfo;

/**
 * 查看作业Controller
 *
 * @author BahetCoder
 * @date 2022-09-10
 */
@RestController
@RequestMapping("/markstuhomework")
public class SStudentHomeworkController extends BaseController
{
    @Autowired
    private ISStudentHomeworkService sStudentHomeworkService;

    /**
     * 查询查看作业列表
     */
    @RequiresPermissions("homework:markstuhomework:list")
    @GetMapping("/list")
    public TableDataInfo list(SStudentHomework sStudentHomework)
    {
        startPage();
//        String username = SecurityUtils.getUsername();
//        sStudentHomework.setStudentName(username);
        List<SStudentHomework> list = sStudentHomeworkService.selectSStudentHomeworkList(sStudentHomework);
        return getDataTable(list);
    }

    /**
     * 导出查看作业列表
     */
    @RequiresPermissions("homework:markstuhomework:export")
    @Log(title = "查看作业", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SStudentHomework sStudentHomework)
    {
        List<SStudentHomework> list = sStudentHomeworkService.selectSStudentHomeworkList(sStudentHomework);
        ExcelUtil<SStudentHomework> util = new ExcelUtil<SStudentHomework>(SStudentHomework.class);
        util.exportExcel(response, list, "查看作业数据");
    }

    /**
     * 获取查看作业详细信息
     */
    @RequiresPermissions("homework:markstuhomework:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sStudentHomeworkService.selectSStudentHomeworkById(id));
    }

    /**
     * 新增查看作业
     */
    @RequiresPermissions("homework:markstuhomework:add")
    @Log(title = "查看作业", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SStudentHomework sStudentHomework)
    {
        return toAjax(sStudentHomeworkService.insertSStudentHomework(sStudentHomework));
    }

    /**
     * 修改查看作业
     */
    @RequiresPermissions("homework:markstuhomework:edit")
    @Log(title = "查看作业", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SStudentHomework sStudentHomework)
    {
        return toAjax(sStudentHomeworkService.updateSStudentHomework(sStudentHomework));
    }

    /**
     * 删除查看作业
     */
    @RequiresPermissions("homework:markstuhomework:remove")
    @Log(title = "查看作业", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sStudentHomeworkService.deleteSStudentHomeworkByIds(ids));
    }
}
