package com.demo.strategy;

import com.demo.common.StrategyEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//把多种策略注册进ioc容器
@Component("strategyUserService")
public class StrategyUseService implements ApplicationContextAware {
    private Map<StrategyEnum, IChoiceStrategy> choiceStrategyMap = new ConcurrentHashMap<>();

    public void resolveStrategy(StrategyEnum strategyEnum, Object param) {
        IChoiceStrategy iChoiceStrategy = choiceStrategyMap.get(strategyEnum);
        if (iChoiceStrategy != null) {
            iChoiceStrategy.resolve(param);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, IChoiceStrategy> beans = applicationContext.getBeansOfType(IChoiceStrategy.class);
        beans.values().forEach(strategyService->choiceStrategyMap.put(strategyService.getStrategyType(),strategyService));
    }
}
