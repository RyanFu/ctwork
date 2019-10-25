package com.example.service;

import com.example.pojo.TestDto;
import com.example.vo.ResponseResult;

public interface AutoTestCaseService {

     ResponseResult xmlLoad();

     ResponseResult addAutoTestCase(TestDto testDto);

     ResponseResult updateCaseInfo(TestDto testDto);

     ResponseResult selectAutoTestCase();
}
