package com.demo.common;

public enum StrategyEnum {
    VIEW_OWN_APPLY("查询个人申请",1),
    OWN_APPLY("发起申请",2),
    OWN_WITHDRAW_APPLY("撤回申请",3),
    REVIEW_APPLY("审阅申请",4),
    VIEW_TOTAL_APPLY("查询所有申请",5)
    ;

    private String name;
    private Integer code;

    StrategyEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
}
