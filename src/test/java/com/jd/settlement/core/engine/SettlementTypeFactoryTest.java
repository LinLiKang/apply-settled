package com.jd.settlement.core.engine;

import com.jd.settlement.enums.SettlementTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SettlementTypeFactoryTest {

    @Autowired
    private SettlementTypeFactory settlementTypeFactory;

    @Test
    public void factoryTest() {
        ProcessFlow flow = settlementTypeFactory.getFlow(SettlementTypeEnum.ENTERPRISE);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
