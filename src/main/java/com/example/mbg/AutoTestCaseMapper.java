package com.example.mbg;

public interface AutoTestCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AutoTestCaseWithBLOBs record);

    int insertSelective(AutoTestCaseWithBLOBs record);

    AutoTestCaseWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutoTestCaseWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AutoTestCaseWithBLOBs record);

    int updateByPrimaryKey(AutoTestCase record);
}