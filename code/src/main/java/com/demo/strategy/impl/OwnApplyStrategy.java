package com.demo.strategy.impl;

import com.demo.common.StrategyEnum;
import com.demo.entity.Application;
import com.demo.entity.User;
import com.demo.service.ApplicationService;
import com.demo.strategy.IChoiceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class OwnApplyStrategy implements IChoiceStrategy {
    @Autowired
    ApplicationService applicationService;

    @Override
    public StrategyEnum getStrategyType() {
        return StrategyEnum.OWN_APPLY;
    }

    @Override
    public void resolve(Object objparams) {
        User user = (User) objparams;
        Scanner sc = new Scanner(System.in);
        String description;
        System.out.println("请输入申请信息:");
        description = sc.next();
        Application application = new Application(user.getId(), description);
        int line = applicationService.apply(application);
        if (line > 0) {
            System.out.println("提交成功,请耐心等待审核!");
        } else {
            System.out.println("提交失败,请检查重试");
        }
    }
}
