package com.jd.settlement.config;

import com.jd.settlement.DemoApplication;
import com.jd.settlement.enums.ProcessStepEnum;
import com.jd.settlement.enums.SettlementTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = {SettlementFlowProperties.class, DemoApplication.class})
public class SettlementFlowPropertiesTest {

//    @Qualifier("settlementFlowProperties")
    @Autowired
    SettlementFlowProperties settlementFlowProperties;

    @Test
    void shouldLoadEnterpriseFlow() {
        Map<SettlementTypeEnum, List<ProcessStepEnum>> flowMapping = settlementFlowProperties.getFlowMapping();
        assertThat("bean创建成功", flowMapping.isEmpty());
    }
}
