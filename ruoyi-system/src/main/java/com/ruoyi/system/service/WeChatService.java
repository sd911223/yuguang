package com.ruoyi.system.service;

import com.ruoyi.system.domain.UserInfo;

import java.util.Map;

public interface WeChatService {
    Map<String, String> weChatLogin(UserInfo userInfo);
}
