package com.ruoyi.system.domain;

public class LoginRqe {
    /**
     * 临时登录凭证
     */
    private String code;
    /**
     * 用户非敏感信息
     */
    private String rawData;
    /**
     * 签名
     */
    private String signature;
    /**
     * 用户敏感信息
     */
    private String encrypteData;
    /**
     * 解密算法
     */
    private String iv;

    public void setCode(String code) {
        this.code = code;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setEncrypteData(String encrypteData) {
        this.encrypteData = encrypteData;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getCode() {
        return code;
    }

    public String getRawData() {
        return rawData;
    }

    public String getSignature() {
        return signature;
    }

    public String getEncrypteData() {
        return encrypteData;
    }

    public String getIv() {
        return iv;
    }
}
