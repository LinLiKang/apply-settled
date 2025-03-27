package com.jd.settlement.core.model.steps;

import com.jd.settlement.entity.ApplyInformationDo;
import com.jd.settlement.entity.StepResult;
import com.jd.settlement.enums.ProcessStepEnum;
import org.springframework.stereotype.Component;

/**
 * 注册步骤实现
 */
@Component
public class RegisterStepImpl implements ProcessStep {
    @Override
    public String getStepCode() {
        return ProcessStepEnum.REGISTER.getCode();
    }

    @Override
    public String getStepName() {
        return ProcessStepEnum.REGISTER.getName();
    }

    @Override
    public ProcessStepEnum getProcessStepEnum() {
        return ProcessStepEnum.REGISTER;
    }

    @Override
    public StepResult execute(ApplyInformationDo applyInformation) {
        System.out.println("执行用户注册步骤...");
        // 模拟注册逻辑
        String username = applyInformation.getUsername();
        String password = applyInformation.getPassword();

        if (username == null || password == null) {
            return new StepResult(false, "用户名或密码不能为空");
        }

        // 注册成功，保存用户ID到上下文
        applyInformation.setUserId(generateUserId());
        return new StepResult(true, "注册成功");
    }

    private String generateUserId() {
        return "UID_" + System.currentTimeMillis();
    }
}