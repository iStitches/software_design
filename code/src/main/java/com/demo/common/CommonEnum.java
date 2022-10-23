package com.demo.common;


public enum CommonEnum {
    //审核状态
    REVIEWING(0,"审批中"),   //审批中
    UNPASSED(1,"申请未通过"),    //未通过
    PASSED(2,"申请已通过"),      //通过
    WITHDRAWED(3,"申请被撤回")   //撤回
    ;

    private Integer code;
    private String status;

    CommonEnum(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }
}
