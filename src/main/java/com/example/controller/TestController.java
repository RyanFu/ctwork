package com.example.controller;


import com.example.dto.TestDto;
import com.example.service.AutoTestCaseService;
import com.example.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private AutoTestCaseService autoTestCaseService;

    /**
     * java驱动testNG运行测试用例
     */
    @RequestMapping(value = "/test.xml",method = RequestMethod.GET)
    //开启异步调用
    public ResponseResult xmlController(){
       return autoTestCaseService.xmlLoad();
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
