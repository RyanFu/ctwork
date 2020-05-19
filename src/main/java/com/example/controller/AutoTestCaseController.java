package com.example.controller;

import com.example.model.AutoTestCase;
import com.example.service.AutoTestCaseService;
import com.example.vo.ResponseResult;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
            return autoTestCaseService.AutoTestCaseById(id);
    }

    /**
     * 批量执行用例
     * @param idsList
     * @return
     */
    @GetMapping(value = "/auto/test/list/ids")
    public ResponseResult caseByIdList(@RequestParam List idsList){
        return autoTestCaseService.AutoTestCaseByListIds(idsList);
    }

}
