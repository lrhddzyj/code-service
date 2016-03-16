package com.mind.code.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lrh on 2015/12/30.
 */
public class TCodeBuilder implements Serializable {

    /**企业id**/
    private String companyId;

    /**应用标示**/
    private String appCode;

    /**业务类型**/
    private String businessType;

    /**业务标示**/
    private String businessKey;

    /**有效期**/
    private Date startTime;

    /**有效期**/
    private Date endTime;

    /**验证回调url**/
    private String notifyUrl;

    /**生成数量**/
    private int count;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
