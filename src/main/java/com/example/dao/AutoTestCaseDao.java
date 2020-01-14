package com.example.dao;

import com.example.pojo.AutoTestCase;

import java.util.List;

public interface AutoTestCaseDao {

     AutoTestCase selectByCaseName(String caseName);

     AutoTestCase selectByCaseId(int id);

     int addAutoTestCase(AutoTestCase autoTestCase);

     int updateAutoTestCase(AutoTestCase autoTestCase);

     int updateCaseInfo(AutoTestCase autoTestCase);

     List<AutoTestCase> getAllAutoTestCase();



}
