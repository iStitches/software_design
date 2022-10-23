package com.demo.service.impl;

import com.demo.dao.ApplicationMapper;
import com.demo.entity.Application;
import com.demo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationMapper applicationMapper;

    @Override
    public Application getByApplyId(int applyId) {
        return applicationMapper.getByApplyId(applyId);
    }

    @Override
    public List<Application> viewOwnApplication(int userId) {
        return applicationMapper.getAllByUserId(userId);
    }

    @Override
    public int apply(Application apply) {
        return applicationMapper.addOne(apply);
    }

    @Override
    public int changeApply(int userId, int applyId, int status) {
        Application apply = applicationMapper.getOneByUserIdAndApplyId(userId, applyId);
        if (apply == null) {
            return 0;
        }
        apply.setStatus(status);
        return applicationMapper.updateOne(apply);
    }

    @Override
    public List<Application> viewTotalApplication() {
        return applicationMapper.getAll();
    }

    @Override
    public int reviewBatchApply(List<Application> applicationList) {
        return applicationMapper.updateBatch(applicationList);
    }
}
