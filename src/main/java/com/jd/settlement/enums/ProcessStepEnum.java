package com.jd.settlement.enums;

/**
 * 入驻流程编码枚举
 */
public enum ProcessStepEnum {

    REGISTER("REGISTER", "注册步骤"),
    ENTERPRISE_AUTH("ENTERPRISE_AUTH", "企业认证步骤"),
    INDIVIDUAL_AUTH("INDIVIDUAL_AUTH", "个体认证步骤"),
    REVIEW("REVIEW", "审核步骤"),
    PAYMENT("PAYMENT", "支付步骤");

    private final String code;
    private final String name;

    ProcessStepEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }

}
