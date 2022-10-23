package com.demo.strategy;

import com.demo.common.StrategyEnum;

public interface IChoiceStrategy {
    StrategyEnum getStrategyType();     //获取策略类型
    void resolve(Object objparams);     //处理策略
}
