package com.jd.settlement.core.model.steps;

import com.jd.settlement.entity.ApplyInformationDo;
import com.jd.settlement.entity.StepResult;
import com.jd.settlement.enums.ProcessStepEnum;
import org.springframework.stereotype.Component;

/**
 * 企业认证步骤实现
 */
@Component
public class EnterpriseAuthStepImpl implements ProcessStep {
    @Override
    public String getStepCode() {
        return ProcessStepEnum.ENTERPRISE_AUTH.getCode();
    }

    @Override
    public String getStepName() {
        return ProcessStepEnum.ENTERPRISE_AUTH.getName();
    }

    @Override
    public ProcessStepEnum getProcessStepEnum() {
        return ProcessStepEnum.ENTERPRISE_AUTH;
    }

    @Override
    public StepResult execute(ApplyInformationDo applyInformation) {
        System.out.println("执行企业实名认证步骤...");
        // 模拟认证逻辑
        Object businessLicense = applyInformation.getBusinessLicense();
        Object legalPersonId = applyInformation.getOperatorId();

        if (businessLicense == null || legalPersonId == null) {
            return new StepResult(false, "企业认证材料不完整");
        }

        // 模拟调用第三方认证服务
        boolean authSuccess = mockEnterpriseAuthService(businessLicense, legalPersonId);

        if (authSuccess) {
            applyInformation.setEnterpriseAuthStatus(true);
            return new StepResult(true, "企业认证成功");
        } else {
            return new StepResult(false, "企业认证失败");
        }
    }

    private boolean mockEnterpriseAuthService(Object license, Object id) {
        // 模拟认证服务，实际中应调用真实服务
        return true;
    }
}