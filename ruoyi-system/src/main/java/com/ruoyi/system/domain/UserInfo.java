package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 user_info
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
public class UserInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phoneNumber;

    /** 证件类型0:身份证,1:护照,2:其他 */
    @Excel(name = "证件类型0:身份证,1:护照,2:其他")
    private String credentialsType;

    /** 登记时间 */
    @Excel(name = "登记时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date registerTime;

    /** 出发地 */
    @Excel(name = "出发地")
    private String departure;

    /** 目的地 */
    @Excel(name = "目的地")
    private String destination;

    /** 抵达日期 */
    @Excel(name = "抵达日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arrivalTime;

    /** 交通方式 */
    @Excel(name = "交通方式")
    private String trafficType;

    /** 备用1 */
    @Excel(name = "风险地区")
    private String backup1;

    /** 备用2 */
    @Excel(name = "途径地")
    private String backup2;

    /** 备用3 */
    @Excel(name = "航班/车次/车牌号")
    private String backup3;

    /** 备用4 */
    @Excel(name = "座位号")
    private String backup4;

    /** 备用5 */
    @Excel(name = "备用5")
    private String backup5;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setCredentialsType(String credentialsType) 
    {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsType() 
    {
        return credentialsType;
    }
    public void setRegisterTime(Date registerTime) 
    {
        this.registerTime = registerTime;
    }

    public Date getRegisterTime() 
    {
        return registerTime;
    }
    public void setDeparture(String departure) 
    {
        this.departure = departure;
    }

    public String getDeparture() 
    {
        return departure;
    }
    public void setDestination(String destination) 
    {
        this.destination = destination;
    }

    public String getDestination() 
    {
        return destination;
    }
    public void setArrivalTime(Date arrivalTime) 
    {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalTime() 
    {
        return arrivalTime;
    }
    public void setTrafficType(String trafficType) 
    {
        this.trafficType = trafficType;
    }

    public String getTrafficType() 
    {
        return trafficType;
    }
    public void setBackup1(String backup1) 
    {
        this.backup1 = backup1;
    }

    public String getBackup1() 
    {
        return backup1;
    }
    public void setBackup2(String backup2) 
    {
        this.backup2 = backup2;
    }

    public String getBackup2() 
    {
        return backup2;
    }
    public void setBackup3(String backup3) 
    {
        this.backup3 = backup3;
    }

    public String getBackup3() 
    {
        return backup3;
    }
    public void setBackup4(String backup4) 
    {
        this.backup4 = backup4;
    }

    public String getBackup4() 
    {
        return backup4;
    }
    public void setBackup5(String backup5) 
    {
        this.backup5 = backup5;
    }

    public String getBackup5() 
    {
        return backup5;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("idCard", getIdCard())
            .append("phoneNumber", getPhoneNumber())
            .append("credentialsType", getCredentialsType())
            .append("registerTime", getRegisterTime())
            .append("departure", getDeparture())
            .append("destination", getDestination())
            .append("arrivalTime", getArrivalTime())
            .append("trafficType", getTrafficType())
            .append("backup1", getBackup1())
            .append("backup2", getBackup2())
            .append("backup3", getBackup3())
            .append("backup4", getBackup4())
            .append("backup5", getBackup5())
            .append("createTime", getCreateTime())
            .toString();
    }
}
