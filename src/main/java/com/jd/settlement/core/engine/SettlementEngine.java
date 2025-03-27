package com.jd.settlement.core.engine;

import com.jd.settlement.entity.ApplyInformationDo;
import com.jd.settlement.entity.StepResult;
import com.jd.settlement.enums.SettlementTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 核心流程协调引擎，承担着将入驻配置、流程步骤和业务规则串联起来的枢纽作用
 * 1. 准备上下文
 * 2. 获取流程实例
 * 3. 执行流程
 * 4. 后置处理
 * 5. 统一异常转换
 */
@Component
public class SettlementEngine {

    @Autowired
    SettlementTypeFactory settlementTypeFactory;

    public StepResult process(ApplyInformationDo informationDo) {
        SettlementTypeEnum typeEnum = SettlementTypeEnum.getByTypeCode(informationDo.getTypeCode());
        ProcessFlow flow = settlementTypeFactory.getFlow(typeEnum);
        return flow.execute(informationDo);
    }

}
