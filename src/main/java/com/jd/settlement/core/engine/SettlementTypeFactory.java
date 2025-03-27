package com.jd.settlement.core.engine;

import com.jd.settlement.config.SettlementFlowProperties;
import com.jd.settlement.core.engine.impl.DefaultProcessFlow;
import com.jd.settlement.core.model.steps.ProcessStep;
import com.jd.settlement.enums.ProcessStepEnum;
import com.jd.settlement.enums.SettlementTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 入驻类型工厂类
 * 负责创建和管理各种入驻类型实例
 */
@Component
//@RequiredArgsConstructor
public class SettlementTypeFactory {

    // 类型到步骤列表的映射
    private final Map<SettlementTypeEnum, List<ProcessStepEnum>> flowMapping;
    // 步骤枚举到具体实现的映射
    private final Map<ProcessStepEnum, ProcessStep> stepBeans;

    @Autowired
    private DefaultProcessFlow defaultProcessFlow;

    /**
     * 构造函数式加载对应映射bean，等效于@RequiredArgsConstructor
     * @param settlementFlowProperties
     * @param stepBeans
     */
    @Autowired
    public SettlementTypeFactory(
            SettlementFlowProperties settlementFlowProperties,
            Map<ProcessStepEnum, ProcessStep> stepBeans) {
        this.flowMapping = settlementFlowProperties.getFlowMapping();
        this.stepBeans = stepBeans;
    }

    // 根据类型获取流程实例
    public ProcessFlow getFlow(SettlementTypeEnum type) {
        List<ProcessStepEnum> stepEnums = flowMapping.get(type);
        if (stepEnums == null) {
            throw new IllegalArgumentException("未配置该类型的流程: " + type);
        }

        // 转换为具体步骤实例
        // 按顺序添加步骤
        stepEnums.stream()
                .map(stepBeans::get)
                .filter(Objects::nonNull)
                .forEach(defaultProcessFlow::addStep);

        return defaultProcessFlow;
    }
}
