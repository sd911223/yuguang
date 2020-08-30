package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.DangerArea;
import com.ruoyi.system.service.IDangerAreaService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2020-08-30
 */
@Controller
@RequestMapping("/system/area")
public class DangerAreaController extends BaseController {
    private String prefix = "system/area";

    @Autowired
    private IDangerAreaService dangerAreaService;

    @RequiresPermissions("system:area:view")
    @GetMapping()
    public String area() {
        return prefix + "/area";
    }

    /**
     * 查询风险地区列表
     */
    @RequiresPermissions("system:area:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DangerArea dangerArea) {
        startPage();
        List<DangerArea> list = dangerAreaService.selectDangerAreaList(dangerArea);
        return getDataTable(list);
    }

    @PostMapping("/dangerAreaList")
    @ResponseBody
    public List<DangerArea> dangerAreaList(DangerArea dangerArea) {
        List<DangerArea> list = dangerAreaService.selectDangerAreaList(dangerArea);
        return list;
    }

    /**
     * 导出风险地区列表
     */
    @RequiresPermissions("system:area:export")
    @Log(title = "【风险地区】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DangerArea dangerArea) {
        List<DangerArea> list = dangerAreaService.selectDangerAreaList(dangerArea);
        ExcelUtil<DangerArea> util = new ExcelUtil<DangerArea>(DangerArea.class);
        return util.exportExcel(list, "area");
    }

    /**
     * 新增【风险地区】
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存【风险地区】
     */
    @RequiresPermissions("system:area:add")
    @Log(title = "【风险地区】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DangerArea dangerArea) {
        return toAjax(dangerAreaService.insertDangerArea(dangerArea));
    }

    /**
     * 修改【风险地区】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        DangerArea dangerArea = dangerAreaService.selectDangerAreaById(id);
        mmap.put("dangerArea", dangerArea);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:area:edit")
    @Log(title = "【风险地区】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DangerArea dangerArea) {
        return toAjax(dangerAreaService.updateDangerArea(dangerArea));
    }

    /**
     * 删除【风险地区】
     */
    @RequiresPermissions("system:area:remove")
    @Log(title = "【风险地区】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(dangerAreaService.deleteDangerAreaByIds(ids));
    }
}
