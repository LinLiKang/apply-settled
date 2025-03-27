package com.jd.settlement.core.model.steps;

import com.jd.settlement.entity.ApplyInformationDo;
import com.jd.settlement.entity.StepResult;
import com.jd.settlement.enums.ProcessStepEnum;
import org.springframework.stereotype.Component;

/**
 * 审核步骤实现
 */
@Component
public class ReviewStepImpl implements ProcessStep {
    @Override
    public String getStepCode() {
        return "";
    }

    @Override
    public String getStepName() {
        return "";
    }

    @Override
    public ProcessStepEnum getProcessStepEnum() {
        return ProcessStepEnum.REVIEW;
    }

    @Override
    public StepResult execute(ApplyInformationDo applyInformationDo) {
        return new StepResult(true, "审核成功");
    }
}
