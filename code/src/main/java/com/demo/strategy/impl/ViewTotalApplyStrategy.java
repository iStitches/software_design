package com.demo.strategy.impl;

import com.demo.common.StrategyEnum;
import com.demo.entity.Application;
import com.demo.service.ApplicationService;
import com.demo.strategy.IChoiceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ViewTotalApplyStrategy implements IChoiceStrategy {
    @Autowired
    ApplicationService applicationService;

    @Override
    public StrategyEnum getStrategyType() {
        return StrategyEnum.VIEW_TOTAL_APPLY;
    }

    @Override
    public void resolve(Object objparams) {
        List<Application> list = applicationService.viewTotalApplication();
        list.forEach(item->{
            System.out.println(item);
        });
        System.out.println();
    }
}
