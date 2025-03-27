package com.jd.settlement.entity;

/**
 * 入驻申请信息
 */

public class ApplyInformationDo {
    /**
     * 营业执照号
     */
    public String businessLicense;

    /**
     * 身份证
     */
    public String operatorId;

    /**
     *
     */
    public String username;

    /**
     *
     */
    public String password;

    /**
     * 用户注册唯一ID
     */
    public String userId;

    /**
     * 认证状态
     */
    public Boolean enterpriseAuthStatus;

    /**
     * 入驻类型code
     */
    public String typeCode;

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getEnterpriseAuthStatus() {
        return enterpriseAuthStatus;
    }

    public void setEnterpriseAuthStatus(Boolean enterpriseAuthStatus) {
        this.enterpriseAuthStatus = enterpriseAuthStatus;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
