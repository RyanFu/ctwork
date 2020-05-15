package com.example.service;


import com.example.vo.ResponseResult;

import java.util.List;

public interface AutoTestCaseService {

     ResponseResult loginCase(int id);

     ResponseResult AutoTestCaseById(int id);

     ResponseResult AutoTestCaseByListIds(List<Integer> ids);




}
