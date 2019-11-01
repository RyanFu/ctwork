package com.example.service.impl;

import com.example.common.Const;
import com.example.dao.AutoTestCaseDao;
import com.example.pojo.AutoTestCase;
import com.example.pojo.TestDto;
import com.example.service.AutoTestCaseService;
import com.example.vo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

@Service
public class AutoTestCaseServiceImpl implements AutoTestCaseService {

    private static Logger logger=LoggerFactory.getLogger(AutoTestCaseServiceImpl.class);

    @Autowired
    private AutoTestCaseDao autoTestCaseDao;

    /**
     * java驱动testNG运行测试用例
     */
    @Override
    public ResponseResult xmlLoad() {
        TestNG testng = new TestNG();
        List suites = Lists.newArrayList();
        suites.add(Const.XMLPATH);
        testng.setTestSuites(suites);
        testng.run();

        System.out.println(testng.getReporters());

        return new ResponseResult(200,"success","用例执行成功，请等待");

    }

    @Override
    public ResponseResult addAutoTestCase(TestDto testDto) {
        AutoTestCase autoTestCase=new AutoTestCase();

        autoTestCase.setCaseName(testDto.getCaseName());
        autoTestCase.setHost(testDto.getHost());
        autoTestCase.setPort(testDto.getPort());
        autoTestCase.setUri(testDto.getUri());
        autoTestCase.setMethod(testDto.getMethod());
        if(null!=testDto.getHeadMap()){
            autoTestCase.setHeads(testDto.getHeadMap().toString());
        }
        autoTestCase.setParamType(testDto.getParamType());
        if(null !=testDto.getParamMap()){
            autoTestCase.setParam(testDto.getParamMap().toString());
        }
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
        autoTestCase.setHost(testDto.getHost());
        autoTestCase.setPort(testDto.getPort());
        autoTestCase.setUri(testDto.getUri());
        autoTestCase.setMethod(testDto.getMethod());
        if(null!=testDto.getHeadMap()){
            autoTestCase.setHeads(testDto.getHeadMap().toString());
        }
        autoTestCase.setParamType(testDto.getParamType());
        if(null !=testDto.getParamMap()){
            autoTestCase.setParam(testDto.getParamMap().toString());
        }
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
