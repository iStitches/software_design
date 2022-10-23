package com.demo.entity;

import com.demo.common.CommonEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    int id_applicant;
    int id_application;
    String description;
    int status;
    Date time;

    public Application(int id_applicant, String description) {
        this.id_applicant = id_applicant;
        this.description = description;
        this.status = CommonEnum.REVIEWING.getCode();
        this.time = new Date();
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(time);
        String stateStr = null;
        switch (status) {
            case 0: stateStr = CommonEnum.REVIEWING.getStatus();break;
            case 1: stateStr = CommonEnum.UNPASSED.getStatus();break;
            case 2: stateStr = CommonEnum.PASSED.getStatus();break;
            case 3: stateStr = CommonEnum.WITHDRAWED.getStatus();break;
            default:break;
        }
        return "Application{" +
                "申请编号: " + id_application +
                ", 申请人编号: " +  id_applicant+
                ", 申请信息: '" + description + '\'' +
                ", 申请状态: " + stateStr +
                ", 申请时间: " + date +
                '}';
    }
}
