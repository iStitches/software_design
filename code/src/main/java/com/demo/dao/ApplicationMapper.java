package com.demo.dao;

import com.demo.entity.Application;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplicationMapper {
    int addOne(Application application);
    Application getByApplyId(int applyId);
    Application getOneByUserIdAndApplyId(@Param("userId") int userId, @Param("applyId") int applyId);
    List<Application> getAllByUserId(int userId);
    List<Application> getAll();
    int deleteOne(@Param("userId") int userId,@Param("applyId") int applyId);
    int updateBatch(List<Application> applicationList);
    int updateOne(Application application);
}
