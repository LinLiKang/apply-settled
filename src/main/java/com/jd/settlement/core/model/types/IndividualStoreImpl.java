package com.jd.settlement.core.model.types;

import com.jd.settlement.core.engine.ProcessFlow;
import com.jd.settlement.entity.ApplyInformationDo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 个体店铺入驻类型实现
 */
@Component
public class IndividualStoreImpl implements SettlementType {

    @Qualifier("individualFlow")
    private ProcessFlow individualFlow;
    // 通过构造函数注入流程实例


    @Override
    public String getTypeCode() {
        return "INDIVIDUAL";
    }

    @Override
    public String getTypeName() {
        return "个体店铺";
    }

    @Override
    public boolean validate(ApplyInformationDo contapplyInformationDoxt) {
        // 验证个体工商户营业执照
        Object license = contapplyInformationDoxt.getBusinessLicense();
        if (license == null) {
            System.err.println("个体店铺入驻验证失败: 缺少营业执照");
            return false;
        }

        // 验证经营者身份证
        Object operatorId = contapplyInformationDoxt.getOperatorId();
        if (operatorId == null) {
            System.err.println("个体店铺入驻验证失败: 缺少经营者身份证");
            return false;
        }

        return true;
    }
}