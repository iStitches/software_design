package com.demo.strategy.impl;

import com.demo.common.StrategyEnum;
import com.demo.entity.Application;
import com.demo.entity.User;
import com.demo.service.ApplicationService;
import com.demo.strategy.IChoiceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ViewOwnApplyStrategy implements IChoiceStrategy {
    @Autowired
    ApplicationService applicationService;

    @Override
    public StrategyEnum getStrategyType() {
        return StrategyEnum.VIEW_OWN_APPLY;
    }

    @Override
    public void resolve(Object objparams) {
        User user = (User) objparams;
        List<Application> list = applicationService.viewOwnApplication(user.getId());
        list.forEach(apply -> {
            System.out.println(apply);
        });
        System.out.println();
    }
}
