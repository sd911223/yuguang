package com.ruoyi.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.service.WeChatService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeChatServiceImpl implements WeChatService {
    @Value("${weixin.appid}")
    private String weiXinAppId;
    @Value("${weixin.appsecret}")
    private String weiXinAppSecret;

    @Override
    public Map<String, String> weChatLogin(UserInfo userInfo) {
        Map<String, String> map = getAccessToken(userInfo);
        return map;
    }

    public Map<String, String> getAccessToken(UserInfo userInfo) {
        String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + weiXinAppId + "&secret=" + weiXinAppSecret;
        System.out.println("URL for getting accessToken accessTokenUrl=" + accessTokenUrl);
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(accessTokenUrl, String.class);
        JSONObject jsonObject = JSON.parseObject(s);
        String accessToken = jsonObject.getString("access_token");
        String expires_in = jsonObject.getString("expires_in");
        HashMap<String, String> hashMap = new HashMap<>();
        String image = getminiqrQr(userInfo.getPhoneNumber(), accessToken);
//        String wxQrcode = getWXQrcode(accessToken, "pages/ScanCode/index", userInfo.getPhoneNumber(), 200);
        hashMap.put("image", image);
        hashMap.put("phoneNumber", userInfo.getPhoneNumber());
        return hashMap;
    }

    public String getminiqrQr(String sceneStr, String accessToken) {
        try {
            URL url = new URL("https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=" + accessToken);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            JSONObject paramJson = new JSONObject();
            paramJson.put("scene", sceneStr);
            paramJson.put("path", "pages/ScanCode/index");
            paramJson.put("width", 430);
            paramJson.put("auto_color", true);
            printWriter.write(paramJson.toString());
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据

//            OutputStream os = new FileOutputStream(new File("C:/Users/Administrator/Desktop/1.png"));
            try (InputStream is = httpURLConnection.getInputStream();
                 ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
                byte[] buffer = new byte[1024];
                int len = -1;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                return Base64.getEncoder().encodeToString(baos.toByteArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取sessionkey
     *
     * @param code
     * @return
     */
    public JSONObject getSessionKeyOrOpenId(String code) {
        //微信端登录code
        String wxCode = code;
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        StringBuilder sb = new StringBuilder();
        sb.append(requestUrl);
        sb.append("?appid=");
        sb.append(weiXinAppId);
        sb.append("&secret=");
        sb.append(weiXinAppSecret);
        sb.append("&js_code=");
        sb.append(wxCode);
        sb.append("&grant_type=authorization_code");
        Map<String, String> requestUrlParam = new HashMap<String, String>();
        //小程序appId
        requestUrlParam.put("appid", weiXinAppId);
        requestUrlParam.put("secret", weiXinAppSecret);
        //小程序端返回的code
        requestUrlParam.put("js_code", wxCode);
        //默认参数
        requestUrlParam.put("grant_type", "authorization_code");

        //发送post请求读取调用微信接口获取openid用户唯一标识
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(sb.toString(), String.class);
        JSONObject jsonObject = JSON.parseObject(s);
        return jsonObject;
    }
}
