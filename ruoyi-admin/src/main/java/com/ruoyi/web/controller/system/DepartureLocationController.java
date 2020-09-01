package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.DepartureLocation;
import com.ruoyi.system.service.IDepartureLocationService;
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
 * @date 2020-09-01
 */
@Controller
@RequestMapping("/system/location")
public class DepartureLocationController extends BaseController {
    private String prefix = "system/location";

    @Autowired
    private IDepartureLocationService departureLocationService;

    @RequiresPermissions("system:location:view")
    @GetMapping()
    public String location() {
        return prefix + "/location";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:location:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DepartureLocation departureLocation) {
        startPage();
        List<DepartureLocation> list = departureLocationService.selectDepartureLocationList(departureLocation);
        return getDataTable(list);
    }

    @PostMapping("/locationList")
    @ResponseBody
    public List<DepartureLocation> locationList() {
        DepartureLocation departureLocation = new DepartureLocation();
        return departureLocationService.selectDepartureLocationList(departureLocation);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:location:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DepartureLocation departureLocation) {
        List<DepartureLocation> list = departureLocationService.selectDepartureLocationList(departureLocation);
        ExcelUtil<DepartureLocation> util = new ExcelUtil<DepartureLocation>(DepartureLocation.class);
        return util.exportExcel(list, "location");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:location:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DepartureLocation departureLocation) {
        return toAjax(departureLocationService.insertDepartureLocation(departureLocation));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        DepartureLocation departureLocation = departureLocationService.selectDepartureLocationById(id);
        mmap.put("departureLocation", departureLocation);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:location:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DepartureLocation departureLocation) {
        return toAjax(departureLocationService.updateDepartureLocation(departureLocation));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:location:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(departureLocationService.deleteDepartureLocationByIds(ids));
    }
}
