package com.jd.settlement.core.engine;

import com.jd.settlement.core.model.steps.ProcessStep;
import com.jd.settlement.entity.ApplyInformationDo;
import com.jd.settlement.entity.StepResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 流程引擎接口
 * 负责执行入驻流程中的所有步骤
 */
public interface ProcessFlow {
    List<ProcessStep> steps = new ArrayList<>();

    void addStep(ProcessStep step);

    // 执行入驻流程
    StepResult execute(ApplyInformationDo applyInformationDo);
}
