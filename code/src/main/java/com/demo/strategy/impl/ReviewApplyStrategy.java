package com.demo.strategy.impl;

import com.demo.common.CommonEnum;
import com.demo.common.StrategyEnum;
import com.demo.entity.Application;
import com.demo.entity.User;
import com.demo.service.ApplicationService;
import com.demo.strategy.IChoiceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ReviewApplyStrategy implements IChoiceStrategy {
    @Autowired
    ApplicationService applicationService;

    @Override
    public StrategyEnum getStrategyType() {
        return StrategyEnum.REVIEW_APPLY;
    }

    //审阅一条
    Application reviewApply() {
        Application application;
        Scanner sc = new Scanner(System.in);
        String isPassed;
        int applyId;

        System.out.println("请输入待审阅的申请编号:");
        applyId = sc.nextInt();
        application = applicationService.getByApplyId(applyId);
        if (application != null) {
            System.out.println(application);
            System.out.println("是否通过? yes/no:");
            isPassed = sc.next();
            application.setStatus(isPassed.equals("yes") ? CommonEnum.PASSED.getCode() : CommonEnum.UNPASSED.getCode());
        } else {
            System.out.println("申请不存在,请检查编号!");
        }
        return application;
    }

    @Override
    public void resolve(Object objparams) {
        User root = (User) objparams;
        Scanner sc = new Scanner(System.in);
        Application application;
        List<Application> list = new ArrayList<>();
        int choice, reviewNum, line;

        System.out.println("请选择审阅方式:\n"+"1.单条审阅\n"+"2.批量审阅");
        choice = sc.nextInt();
        if (choice == 1) {
            application = reviewApply();
            if (application != null) {
                line = applicationService.changeApply(application.getId_applicant(), application.getId_application(), application.getStatus());
                System.out.println("成功审批"+line+"条数据\n");
            }
        } else {
            System.out.println("请输入审批数量:");
            reviewNum = sc.nextInt();
            while (reviewNum > 0) {
                application = reviewApply();
                if (application != null) {
                    list.add(application);
                }
                reviewNum--;
            }
            line = applicationService.reviewBatchApply(list);
            System.out.println("成功审批"+line+"条数据\n");
        }
    }
}
