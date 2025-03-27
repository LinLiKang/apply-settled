package com.jd.settlement.core.model.types;

import com.jd.settlement.core.engine.ProcessFlow;
import com.jd.settlement.entity.ApplyInformationDo;

/**
 * 入驻类型接口
 * 定义所有入驻类型必须实现的方法
 */
public interface SettlementType {

    /**
     * 获取入驻类型编码
     *
     * @return 类型编码字符串
     */
    String getTypeCode();

    /**
     * 获取入驻类型名称
     *
     * @return 类型名称
     */
    String getTypeName();


    /**
     * 验证入驻申请是否有效
     *
     * @param applyInformationDo 入驻上下文，包含申请数据
     * @return 验证结果
     */
    boolean validate(ApplyInformationDo applyInformationDo);


}