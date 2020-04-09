package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.common.auto.AutoTestCaseFeatureComponent;
import com.example.common.auto.TmplateParam;
import com.example.dao.second.AutoTestCaseMapper;
import com.example.enums.CaseEnum;
import com.example.model.AutoTestCaseWithBLOBs;
import com.example.service.AutoTestCaseService;
import com.example.util.ApiTestUtils;
import com.example.util.HttpClientUtils;
import com.example.vo.ResponseResult;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yicg
 * @createTime 2020年04月01日 14:54:00
 * @Description
 */

@Slf4j
@Service
public class AutoTestCaseServiceImpl implements AutoTestCaseService {

    @Autowired
    private AutoTestCaseMapper autoTestCaseMapper;

    /**
     * 调用登录接口
     * @param id
     * @return
     */
    @Override
    public ResponseResult loginCase(int id) {
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs=autoTestCaseMapper.selectByPrimaryKey(id);

        String response=ApiTestUtils.doHttpRequest(autoTestCaseWithBLOBs);
        JSONObject result=JSON.parseObject(response);
        if(HttpClientUtils.resultCode==HttpStatus.SC_OK){
            updateAutoTestCaseAfterTest(id,response,CaseEnum.SUCCESS.getMessage());
        }else {
            updateAutoTestCaseAfterTest(id,response,CaseEnum.FAIL.getMessage());
            throw new RuntimeException("用例执行失败...");
        }


        return ResponseResult.createBySuccessMessage(result);
    }


    @Override
    public ResponseResult AutoTestCaseById(int id) {

        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs=autoTestCaseMapper.selectByPrimaryKey(id);
        String response=ApiTestUtils.doHttpRequest(autoTestCaseWithBLOBs);
        JSONObject result=JSON.parseObject(response);
        if(HttpClientUtils.resultCode==HttpStatus.SC_OK){
            updateAutoTestCaseAfterTest(id,response,CaseEnum.SUCCESS.getMessage());
        }else {
            updateAutoTestCaseAfterTest(id,response,CaseEnum.FAIL.getMessage());
            throw new RuntimeException("用例执行失败...");
        }


        return ResponseResult.createBySuccessMessage(result);

    }





    /**
     * 测试用例执行前初始化执行状态
     * @param id
     * @return
     */
    private int updateAutoTestCaseBeforeTest(int id) {
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs = new AutoTestCaseWithBLOBs();
        autoTestCaseWithBLOBs.setState(CaseEnum.UNKNOW.getMessage());
        autoTestCaseWithBLOBs.setActualResult("null");
        autoTestCaseWithBLOBs.setId(id);
        int i=autoTestCaseMapper.updateByPrimaryKeySelective(autoTestCaseWithBLOBs);
        if(i>0){
            log.info("用例状态初始化成功.....");
        }else {log.error("用例状态初始化失败.....");
            throw new RuntimeException("用例状态初始化失败");
        }

        return i;
    }

    /**
     * 用例执行后更新状态到库
     * @param id
     * @param response
     * @param state
     * @return
     */
    private int updateAutoTestCaseAfterTest(int id,String response,String state) {
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs = new AutoTestCaseWithBLOBs();
        autoTestCaseWithBLOBs.setId(id);
        autoTestCaseWithBLOBs.setActualResult(response);
        autoTestCaseWithBLOBs.setState(state);

        int i=autoTestCaseMapper.updateByPrimaryKeySelective(autoTestCaseWithBLOBs);
        if(i>0){
            log.info("用例执行状态修改成功.....");
        }else {
            log.error("用例执行状态修改失败.....");
            throw new RuntimeException("用例执行状态修改失败");
        }
        return i;
    }

}
