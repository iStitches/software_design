package com.demo;

import com.demo.common.StrategyEnum;
import com.demo.entity.User;
import com.demo.service.ApplicationService;
import com.demo.service.UserService;
import com.demo.strategy.StrategyUseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Demo {
    private static ApplicationContext context;
    private ApplicationService applyService;
    private StrategyUseService strategyService;
    private UserService userService;
    private User cache;

    static {
        if (context == null) {
            context = new ClassPathXmlApplicationContext("spring-config.xml");
        }
    }

    void init() {
        if (context != null) {
            applyService = (ApplicationService) context.getBean("applicationService");
            userService = (UserService) context.getBean("userService");
            strategyService = (StrategyUseService) context.getBean("strategyUserService");
        }
    }

    boolean login(String name, String pwd) {
        cache = userService.findUserByAccAndPwd(name, pwd);
        return cache == null ? false : true;
    }

    User getCache() {
        return this.cache;
    }

    //根据choice选择合适的处理策略
    StrategyEnum getStrategy(boolean isRoot, int choice) {
        if (isRoot) {
            switch (choice) {
                case 1: return StrategyEnum.REVIEW_APPLY;
                case 2: return StrategyEnum.VIEW_TOTAL_APPLY;
                default: return null;
            }
        } else {
            switch (choice) {
                case 1: return StrategyEnum.VIEW_OWN_APPLY;
                case 2: return StrategyEnum.OWN_APPLY;
                case 3: return StrategyEnum.OWN_WITHDRAW_APPLY;
                default: return null;
            }
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.init();
        Scanner sc = new Scanner(System.in);
        String username, password;
        boolean flag, isRoot;
        int choice = 0;

        while (choice != 4) {
            username = password = null;
            choice = 0;

            //login
            System.out.println("Welcome to ApplicationSystem, Please login first!");
            System.out.println("Your userName:");
            username = sc.next();
            System.out.println("Your password:");
            password = sc.next();
            flag = demo.login(username, password);
            if (!flag) {
                System.out.println("登录失败,请重试!");
            } else {
                //process
                System.out.println("登录成功,"+demo.cache.getName()+"欢迎!");
                while(choice != 4) {
                    isRoot = false;
                    if(demo.cache.getName().equals("root")) {
                        isRoot = true;
                        System.out.println("请选择您的业务:\n"+
                                "1.审阅申请\n"+"2.查看所有申请\n"+"4.退出");
                    } else {
                        isRoot = false;
                        System.out.println("请选择您的业务:\n"+
                                "1.查看个人申请\n"+"2.发起申请\n"+"3.撤回申请\n"+"4.退出");
                    }
                    choice = sc.nextInt();
                    if (choice != 4) {
                        demo.strategyService.resolveStrategy(demo.getStrategy(isRoot, choice),  demo.getCache());
                    }
                }
                System.out.println("欢迎下次使用!");
            }
        }
    }
}
