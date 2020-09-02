package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.domain.UserInfoReq;
import com.ruoyi.system.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2020-08-30
 */
@Controller
@RequestMapping("/system/info")
@Api(tags = "外来人员信息管理")
public class UserInfoController extends BaseController {
    private String prefix = "system/info";

    @Autowired
    private IUserInfoService userInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info() {
        return prefix + "/info";
    }

    /**
     * 查询【外来人员】列表
     */
    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserInfo userInfo) {
        startPage();
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        list.forEach(e -> {
            if (e.getTrafficType().equals("0")) {
                e.setTrafficType("火车");
            }
            if (e.getTrafficType().equals("1")) {
                e.setTrafficType("飞机");
            }
            if (e.getTrafficType().equals("2")) {
                e.setTrafficType("乘车");
            }
            if (e.getCredentialsType().equals("0")) {
                e.setCredentialsType("身份证");
            }
            if (e.getCredentialsType().equals("1")) {
                e.setCredentialsType("护照");
            }
            if (e.getCredentialsType().equals("2")) {
                e.setCredentialsType("其他");
            }
        });
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:info:export")
    @Log(title = "【外来人员】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserInfo userInfo) {
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        ExcelUtil<UserInfo> util = new ExcelUtil<UserInfo>(UserInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 添加用户信息
     */
    @ApiOperation("添加用户信息")
    @RequiresPermissions("system:info:add")
    @Log(title = "添加用户信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserInfo userInfo) {
        return toAjax(userInfoService.insertUserInfo(userInfo));
    }

    @PostMapping("/addUserSave")
    @ResponseBody
    public AjaxResult addUserSave(@RequestBody UserInfoReq userInfo) throws ParseException {
        String registerTime = userInfo.getRegisterTime();
        String arrivalTime = userInfo.getArrivalTime();
        UserInfo info = new UserInfo();
        BeanUtils.copyProperties(userInfo, info);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        info.setRegisterTime(format.parse(registerTime));
        info.setArrivalTime(format.parse(arrivalTime));
        info.setCreateTime(new Date());
        return toAjax(userInfoService.insertUserInfo(info));
    }

    @PostMapping("/byPhone")
    @ResponseBody
    public List<UserInfo> byPhone(@RequestBody UserInfoReq userInfo) {
        UserInfo info = new UserInfo();
        info.setPhoneNumber(userInfo.getPhoneNumber());
        List<UserInfo> list = userInfoService.selectUserInfoList(info);
        return list;
    }

    /**
     * 修改【外来人员】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        UserInfo userInfo = userInfoService.selectUserInfoById(id);
        mmap.put("userInfo", userInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存【外来人员】
     */
    @RequiresPermissions("system:info:edit")
    @Log(title = "【外来人员】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserInfo userInfo) {
        return toAjax(userInfoService.updateUserInfo(userInfo));
    }

    /**
     * 删除【外来人员】
     */
    @RequiresPermissions("system:info:remove")
    @Log(title = "【外来人员】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(userInfoService.deleteUserInfoByIds(ids));
    }
}
