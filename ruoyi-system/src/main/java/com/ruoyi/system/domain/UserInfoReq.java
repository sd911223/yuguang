package com.ruoyi.system.domain;

public class UserInfoReq {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 证件类型
     */
    private String credentialsType;

    /**
     * 登记时间
     */
    private String registerTime;

    /**
     * 出发地
     */
    private String departure;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 抵达日期
     */
    private String arrivalTime;

    /**
     * 交通方式
     */
    private String trafficType;

    /**
     * 备用1
     */
    private String backup1;

    /**
     * 备用2
     */
    private String backup2;

    /**
     * 备用3
     */
    private String backup3;

    /**
     * 备用4
     */
    private String backup4;

    /**
     * 备用5
     */
    private String backup5;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCredentialsType(String credentialsType) {
        this.credentialsType = credentialsType;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setTrafficType(String trafficType) {
        this.trafficType = trafficType;
    }

    public void setBackup1(String backup1) {
        this.backup1 = backup1;
    }

    public void setBackup2(String backup2) {
        this.backup2 = backup2;
    }

    public void setBackup3(String backup3) {
        this.backup3 = backup3;
    }

    public void setBackup4(String backup4) {
        this.backup4 = backup4;
    }

    public void setBackup5(String backup5) {
        this.backup5 = backup5;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCredentialsType() {
        return credentialsType;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getTrafficType() {
        return trafficType;
    }

    public String getBackup1() {
        return backup1;
    }

    public String getBackup2() {
        return backup2;
    }

    public String getBackup3() {
        return backup3;
    }

    public String getBackup4() {
        return backup4;
    }

    public String getBackup5() {
        return backup5;
    }
}
