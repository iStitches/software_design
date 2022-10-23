package com.demo.strategy.impl;

import com.demo.common.CommonEnum;
import com.demo.common.StrategyEnum;
import com.demo.entity.User;
import com.demo.service.ApplicationService;
import com.demo.strategy.IChoiceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class OwnWithdrawApplyStrategy implements IChoiceStrategy {
    @Autowired
    ApplicationService applicationService;

    @Override
    public StrategyEnum getStrategyType() {
        return StrategyEnum.OWN_WITHDRAW_APPLY;
    }

    @Override
    public void resolve(Object objparams) {
        User user = (User) objparams;
        Integer applyId;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入申请编号:");
        applyId = sc.nextInt();
        int line = applicationService.changeApply(user.getId(), applyId, CommonEnum.WITHDRAWED.getCode());
        if (line == 0) {
            System.out.println("申请不存在,撤回失败!");
        } else {
            System.out.println("成功撤回申请");
        }
    }
}
