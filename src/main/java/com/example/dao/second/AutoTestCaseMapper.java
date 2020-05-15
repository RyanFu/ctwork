package com.example.dao.second;

import com.example.model.AutoTestCase;
import com.example.model.AutoTestCaseWithBLOBs;

import java.util.List;

public interface AutoTestCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AutoTestCaseWithBLOBs record);

    int insertSelective(AutoTestCaseWithBLOBs record);

    AutoTestCaseWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutoTestCaseWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AutoTestCaseWithBLOBs record);

    int updateByPrimaryKey(AutoTestCase record);

    List<AutoTestCase> findAutoTestCaseIdList(List<Integer> ids);
}