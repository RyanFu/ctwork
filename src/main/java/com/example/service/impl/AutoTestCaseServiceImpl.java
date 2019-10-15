package com.example.service.impl;

import com.example.dao.AutoTestCaseDao;
import com.example.pojo.AutoTestCase;
import com.example.pojo.TestDto;
import com.example.service.AutoTestCaseService;
import com.example.vo.ResponseResult;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoTestCaseServiceImpl implements AutoTestCaseService {

    private static Logger logger=LoggerFactory.getLogger(AutoTestCaseServiceImpl.class);

    @Autowired
    private AutoTestCaseDao autoTestCaseDao;

    @Override
    public ResponseResult addAutoTestCase(TestDto testDto) {
        AutoTestCase autoTestCase=new AutoTestCase();

        autoTestCase.setCaseName(testDto.getCaseName());
        autoTestCase.setUrl(testDto.getUrl());
        autoTestCase.setMethod(testDto.getMethod());
        autoTestCase.setHeads(new JSONObject(testDto.getHeadMap()).toString());
        autoTestCase.setParam(new JSONObject(testDto.getParamMap()).toString());
        autoTestCase.setState(testDto.getState());

        AutoTestCase testCase = autoTestCaseDao.selectByCaseName(autoTestCase.getCaseName());
        if (testCase !=null) {
            return new ResponseResult(400, "用例名称已存在，请修改");
        } else {
            int i = autoTestCaseDao.addAutoTestCase(autoTestCase);
            if (i == 0) {
                return new ResponseResult(400, "添加用例失败");
            }
            logger.info("添加案例成功={}", autoTestCase.toString());
            return new ResponseResult(200, "添加用例成功",autoTestCase);
        }
    }

    @Override
    public ResponseResult updateCaseInfo(TestDto testDto) {
        AutoTestCase autoTestCase=new AutoTestCase();
        autoTestCase.setCaseName(testDto.getCaseName());
        autoTestCase.setUrl(testDto.getUrl());
        autoTestCase.setMethod(testDto.getMethod());
        autoTestCase.setHeads(new JSONObject(testDto.getHeadMap()).toString());
        autoTestCase.setParam(new JSONObject(testDto.getParamMap()).toString());
        autoTestCase.setState(testDto.getState());
        if(testDto.getCaseName().equals(null)){
            return new ResponseResult(400, "用例名称不能为空");
        }
        int i=autoTestCaseDao.updateCaseInfo(autoTestCase);
        if(i==0){
            return new ResponseResult(400, "修改用例失败");
        }else {
            AutoTestCase caseInfo=autoTestCaseDao.selectByCaseName(autoTestCase.getCaseName());
            logger.info("修改用例={}",caseInfo);
            return new ResponseResult(200, "修改用例成功",caseInfo);
        }

    }

    @Override
    public ResponseResult selectAutoTestCase() {
        List<AutoTestCase> list=autoTestCaseDao.getAllAutoTestCase();
        return new ResponseResult(200,"success",list);
    }


}
