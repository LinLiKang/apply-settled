package com.jd.settlement.entity;

/**
 * 步骤执行结果封装类
 */
public class StepResult {
    private final boolean success;
    private final String message;

    public StepResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
