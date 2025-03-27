package com.jd.settlement.enums;

/**
 * 店铺入驻类型枚举类
 */
public enum SettlementTypeEnum {
    ENTERPRISE("ENTERPRISE", "企业店铺"),
    INDIVIDUAL("INDIVIDUAL", "个体店铺"),
    CROSS_BORDER("CROSS_BORDER", "跨境店铺");


    private final String typeCode;
    private final String typeName;

    SettlementTypeEnum(String typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public String getTypeCode() {
        return typeCode;
    }
    public String getTypeName() {
        return typeName;
    }

    public static SettlementTypeEnum getByTypeCode(String typeCode) {
        if (typeCode == null || typeCode.isEmpty()) {
            throw new IllegalArgumentException("入驻类型编码不能为空");
        }

        SettlementTypeEnum[] values = SettlementTypeEnum.values();
        for (SettlementTypeEnum value : values) {
            if(value.getTypeCode().equals(typeCode)) {
                return value;
            }
        }
        throw new IllegalArgumentException("无效的入驻类型编码: " + typeCode);
    }
}
