package com.jd.settlement.core.engine.impl;

import com.jd.settlement.core.model.steps.EnterpriseAuthStepImpl;
import com.jd.settlement.core.model.steps.RegisterStepImpl;
import com.jd.settlement.core.model.steps.ReviewStepImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 通过@Qualifier 注解控制入驻类型需要执行那些流程步骤
 */
@Component
@Qualifier("individualFlow")
public class IndividualFlow  extends DefaultProcessFlow{
    @Autowired
    public IndividualFlow(RegisterStepImpl registerStepImpl,
                          EnterpriseAuthStepImpl enterpriseAuthStepImpl,
                          ReviewStepImpl reviewStepImpl) {
        addStep(registerStepImpl);
        addStep(enterpriseAuthStepImpl);
        addStep(reviewStepImpl);

    }
}
