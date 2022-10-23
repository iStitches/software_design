package com.demo.service;

import com.demo.entity.Application;

import java.util.List;

public interface ApplicationService {
    Application getByApplyId(int applyId);
    List<Application> viewOwnApplication(int userId);
    int apply(Application apply);
    int changeApply(int userId, int applyId, int status);
    List<Application> viewTotalApplication();
    int reviewBatchApply(List<Application> applicationList);
}
