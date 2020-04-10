package com.example.controller;

import com.example.service.AutoTestCaseService;
import com.example.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yicg
 * @createTime 2020年04月01日 14:58:00
 * @Description
 */
@RestController
public class AutoTestCaseController {

    @Autowired
    private AutoTestCaseService autoTestCaseService;

    @GetMapping(value = "/auto/test")
    public ResponseResult cseTestById(@RequestParam int id){
        //调用登录
        if(id==15){
           autoTestCaseService.loginCase(id);
           return ResponseResult.createBySuccessMessage("初始化登录成功！！！");
        }else {
             autoTestCaseService.loginCase(15);
            return autoTestCaseService.AutoTestCaseById(id);
        }
    }

}
