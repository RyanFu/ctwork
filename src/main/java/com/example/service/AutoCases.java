package com.example.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.common.auto.AutoTestCaseFeatureComponent;
import com.example.common.auto.TmplateParam;
import com.example.dao.second.AutoTestCaseMapper;
import com.example.enums.CaseEnum;
import com.example.model.AutoTestCaseWithBLOBs;
import com.example.util.ApiTestUtils;
import com.example.util.HttpClientUtils;
import com.example.vo.ResponseResult;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yicg
 * @createTime 2020年04月02日 18:21:00
 * @Description
 */
@Service
@Slf4j
public class AutoCases {



    @Autowired
    private AutoTestCaseMapper autoTestCaseMapper;

    //定义请求头
    Map<String, Object> headers = Maps.newHashMap();
    //返回结果
    JSONObject result;


    /**
     *
     * @param id
     * @return
     *
     * post+key-value
     */
    public ResponseResult login(int id) {
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs = autoTestCaseMapper.selectByPrimaryKey(id);
        String caseName=autoTestCaseWithBLOBs.getCaseName();
        String host=autoTestCaseWithBLOBs.getHost();
        String uri=autoTestCaseWithBLOBs.getUri();
        String port= String.valueOf(autoTestCaseWithBLOBs.getPort());
        String url=host+":"+port+uri;

        //初始化待测用例
        updateAutoTestCaseBeforeTest(id);
        String response = ApiTestUtils.doHttpRequest(autoTestCaseWithBLOBs);
        result=JSON.parseObject(response);
        if(HttpClientUtils.resultCode==HttpStatus.SC_OK){
            updateAutoTestCaseAfterTest(id,response,CaseEnum.SUCCESS.getMessage());
            log.info("运行的用例名称 {},接口地址: {},参数:{},数据源返回结果 {}",caseName,url,result);
        }else {
            updateAutoTestCaseAfterTest(id,response,CaseEnum.FAIL.getMessage());
            log.error("运行的用例名称 {},接口地址: {}",caseName,url);
        }

        return ResponseResult.createBySuccessMessage(result);
    }









    private int updateAutoTestCaseBeforeTest(int id) {
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs = new AutoTestCaseWithBLOBs();
        autoTestCaseWithBLOBs.setState(CaseEnum.UNKNOW.getMessage());
        autoTestCaseWithBLOBs.setActualResult("null");
        autoTestCaseWithBLOBs.setId(id);
        int i=autoTestCaseMapper.updateByPrimaryKeySelective(autoTestCaseWithBLOBs);
        if(i>0){
            log.info("用例状态初始化成功.....");
        }else {
            log.error("用例状态初始化失败.....");
        }
        return i;
    }

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
        }
        return i;
    }
}
