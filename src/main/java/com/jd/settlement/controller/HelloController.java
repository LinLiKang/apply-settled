package com.jd.settlement.controller;

import com.jd.settlement.core.engine.ProcessFlow;
import com.jd.settlement.core.engine.SettlementTypeFactory;
import com.jd.settlement.enums.SettlementTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    SettlementTypeFactory settlementTypeFactory;
    @GetMapping("/hello")
    public String hello(String code) {
        SettlementTypeEnum typeEnum = SettlementTypeEnum.getByTypeCode(code);


        ProcessFlow flow = settlementTypeFactory.getFlow(typeEnum);

        return "Hello, Spring Boot!";
    }
}
