package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/system/wechat")
public class WeChatController {
    @Autowired
    WeChatService weChatService;

    /**
     * 登陆接口
     */
    @PostMapping("/getAccessToken")
    @ResponseBody
    public AjaxResult ajaxLogin(@RequestBody UserInfo userInfo) {
        Map<String, String> map = weChatService.weChatLogin(userInfo);
        return AjaxResult.success(map);
    }
}
