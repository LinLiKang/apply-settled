package com.jd.settlement.core.engine.impl;

import com.jd.settlement.core.engine.ProcessFlow;
import com.jd.settlement.core.model.steps.ProcessStep;
import com.jd.settlement.entity.ApplyInformationDo;
import com.jd.settlement.entity.StepResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 流程引擎实现类
 * 负责执行入驻流程中的所有步骤
 */
@Component
public class DefaultProcessFlow implements ProcessFlow {
    private final List<ProcessStep> steps = new ArrayList<>();

    @Override
    public void addStep(ProcessStep step) {
        steps.add(step);
    }

    @Override
    public StepResult execute(ApplyInformationDo applyInformationDo) {
        for (ProcessStep step : steps) {
            System.out.println("正在执行步骤: " + step.getStepName());
            StepResult result = step.execute(applyInformationDo);

            if (!result.isSuccess()) {
                System.err.println("步骤执行失败: " + result.getMessage());
                return result;
            }
        }
        return new StepResult(true, "所有步骤执行完成");
    }
}
