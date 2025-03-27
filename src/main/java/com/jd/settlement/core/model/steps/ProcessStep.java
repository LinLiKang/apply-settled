package com.jd.settlement.core.model.steps;

import com.jd.settlement.entity.ApplyInformationDo;
import com.jd.settlement.entity.StepResult;
import com.jd.settlement.enums.ProcessStepEnum;

/**
 * 流程步骤接口
 * 定义所有流程步骤必须实现的方法
 */
public interface ProcessStep {

    /**
     * 获取步骤编码
     * @return 步骤编码
     */
    String getStepCode();

    /**
     * 获取步骤名称
     * @return 步骤名称
     */
    String getStepName();

    /**
     * 获取步骤枚举
     * @return
     */
    ProcessStepEnum getProcessStepEnum();

    /**
     * 执行步骤
     * @param applyInformationDo 入驻上下文
     * @return 步骤执行结果
     */
    StepResult execute(ApplyInformationDo applyInformationDo);
}
