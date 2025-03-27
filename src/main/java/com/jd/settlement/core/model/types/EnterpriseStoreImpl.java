package com.jd.settlement.core.model.types;

import com.jd.settlement.core.engine.ProcessFlow;
import com.jd.settlement.enums.SettlementTypeEnum;
import com.jd.settlement.entity.ApplyInformationDo;
import org.springframework.stereotype.Component;

/**
 * 企业店铺入驻类型实现
 */
@Component
public class EnterpriseStoreImpl implements SettlementType {
    @Override
    public String getTypeCode() {
        return SettlementTypeEnum.ENTERPRISE.getTypeCode();
    }

    @Override
    public String getTypeName() {
        return SettlementTypeEnum.ENTERPRISE.getTypeName();
    }

    @Override
    public boolean validate(ApplyInformationDo applyInformationDo) {
        // 验证企业营业执照
        Object businessLicense = applyInformationDo.getBusinessLicense();
        if (businessLicense == null) {
            System.err.println("企业店铺入驻验证失败: 缺少营业执照");
            return false;
        }

        // 验证法人身份证
        Object legalPersonId = applyInformationDo.getOperatorId();
        if (legalPersonId == null) {
            System.err.println("企业店铺入驻验证失败: 缺少法人身份证");
            return false;
        }

        return true;
    }


}
