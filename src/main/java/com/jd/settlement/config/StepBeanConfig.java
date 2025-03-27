package com.jd.settlement.config;

import com.jd.settlement.core.model.steps.ProcessStep;
import com.jd.settlement.enums.ProcessStepEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * 自动收集所有入驻步骤Bean配置类，并建立和ProcessStepEnum的映射
 */
@Configuration
public class StepBeanConfig {

    /**
     * 自动构建步骤枚举到实现类的映射
     * @param steps 所有实现ProcessStep接口的Bean
     * @return Map<ProcessStepEnum, ProcessStep>
     */
    @Bean
    public Map<ProcessStepEnum, ProcessStep> stepBeans(List<ProcessStep> steps) {
        Map<ProcessStepEnum, ProcessStep> map = new EnumMap<>(ProcessStepEnum.class);

        for (ProcessStep step : steps) {
            ProcessStepEnum enumKey = step.getProcessStepEnum();
            if (map.containsKey(enumKey)) {
                throw new IllegalStateException("重复的步骤枚举: " + enumKey);
            }
            map.put(enumKey, step);
        }

        return map;
    }
}
