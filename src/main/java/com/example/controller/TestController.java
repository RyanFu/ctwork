package com.example.controller;


import com.example.pojo.AutoTestCase;
import com.example.pojo.TestDto;
import com.example.service.AutoTestCaseService;
import com.example.vo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

@RestController
public class TestController {

    private static Logger logger=LoggerFactory.getLogger(TestController.class);

    public static final String XMLPATH="/Users/yicg/IdeaProjects/ctwork/src/main/resources/ctWorkTestng.xml";


    @Autowired
    private AutoTestCaseService autoTestCaseService;

    /**
     * java驱动testNG运行测试用例
     */
    @RequestMapping(value = "/test.xml",method = RequestMethod.GET)
    @Async//开启异步调用
    public ResponseResult testController(){
        TestNG testng = new TestNG();
        List suites = Lists.newArrayList();
        suites.add(XMLPATH);
        testng.setTestSuites(suites);
        testng.run();

        System.out.println(testng.getReporters());

        return new ResponseResult(200,"success");

    }

    @RequestMapping(value = "/add_case",method = RequestMethod.POST)
    public ResponseResult addAutoTestCase(@RequestBody TestDto testDto){
        return autoTestCaseService.addAutoTestCase(testDto);
    }

    @RequestMapping(value = "/update_case",method = RequestMethod.POST)
    public ResponseResult updateCaseInfo(@RequestBody TestDto testDto){
        return autoTestCaseService.updateCaseInfo(testDto);
    }

    @RequestMapping(value = "get_list",method = RequestMethod.GET)
    public ResponseResult findList(){
        return autoTestCaseService.selectAutoTestCase();
    }

}
