package com.jd.settlement.config;

import com.jd.settlement.enums.ProcessStepEnum;
import com.jd.settlement.enums.SettlementTypeEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * 读取配置，映射到settlementType:ProcessStep
 */
@Component("settlementFlowProperties")
@ConfigurationProperties(prefix = "settlement")
@Data
public class SettlementFlowProperties {
    public Map<SettlementTypeEnum, List<ProcessStepEnum>> flowMapping;
}