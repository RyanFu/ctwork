package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.common.auto.AutoTestCaseFeatureComponent;
import com.example.common.auto.TmplateParam;
import com.example.dao.second.AutoTestCaseMapper;
import com.example.enums.CaseEnum;
import com.example.model.AutoTestCaseWithBLOBs;
import com.example.service.AutoTestCaseService;
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


    //定义请求头
    Map<String, Object> headers = Maps.newHashMap();
    //返回结果
    JSONObject result;


    /**
     * 调用登录接口
     * @param id
     * @return
     */
    @Override
    public ResponseResult loginCase(int id) {
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs = autoTestCaseMapper.selectByPrimaryKey(id);
        String caseName=autoTestCaseWithBLOBs.getCaseName();
        String host=autoTestCaseWithBLOBs.getHost();
        String uri=autoTestCaseWithBLOBs.getUri();
        String port= String.valueOf(autoTestCaseWithBLOBs.getPort());
        String param=autoTestCaseWithBLOBs.getParam();
        String url=host+":"+port+uri;

        //初始化待测用例
        updateAutoTestCaseBeforeTest(id);
        //通过模版映射的请求参数
        String reqBody = HttpClientUtils.makeParamter(param, TmplateParam.tmpParam(), AutoTestCaseFeatureComponent.paramMap);
        JSONObject body = JSON.parseObject(reqBody);
        String response = HttpClientUtils.postForSession(url, body, headers);
        result=JSON.parseObject(response);
        if(HttpClientUtils.resultCode==HttpStatus.SC_OK){
            updateAutoTestCaseAfterTest(id,response,CaseEnum.SUCCESS.getMessage());
            log.info("运行的用例名称 {},接口地址: {},参数:{},数据源返回结果 {}",caseName,url,reqBody,result);
        }else {
            updateAutoTestCaseAfterTest(id,response,CaseEnum.FAIL.getMessage());
            log.error("运行的用例名称 {},接口地址: {}",caseName,url);
        }

        return ResponseResult.createBySuccessMessage(result);
    }


    @Override
    public ResponseResult AutoTestCaseById(int id) {
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs=autoTestCaseMapper.selectByPrimaryKey(id);
        String caseName=autoTestCaseWithBLOBs.getCaseName();
        String host=autoTestCaseWithBLOBs.getHost();
        String uri=autoTestCaseWithBLOBs.getUri();
        String port= String.valueOf(autoTestCaseWithBLOBs.getPort());
        String method=autoTestCaseWithBLOBs.getMethod();
        String param_type=autoTestCaseWithBLOBs.getParamType();
        String param=autoTestCaseWithBLOBs.getParam();
        String url=host+":"+port+uri;
        //初始化待测用例
        updateAutoTestCaseBeforeTest(id);

        if(method.equalsIgnoreCase("POST") && CaseEnum.KEY_VALUE.getMessage().equalsIgnoreCase(param_type)){
            //通过模版映射的请求参数
            String reqBody=HttpClientUtils.makeParamter(param,TmplateParam.tmpParam(),AutoTestCaseFeatureComponent.paramMap);
            JSONObject body=JSON.parseObject(reqBody);
            String response=HttpClientUtils.postForSession(url,body, headers);
            result=JSON.parseObject(response);
            if(HttpClientUtils.resultCode==HttpStatus.SC_OK){
                //更改状态
                updateAutoTestCaseAfterTest(id,response,CaseEnum.SUCCESS.getMessage());
                log.info("运行的用例名称 {},接口地址: {},参数:{},数据源返回结果 {}",caseName,url,reqBody,result);
            }else {
                updateAutoTestCaseAfterTest(id,response,CaseEnum.FAIL.getMessage());
                log.error("运行的用例名称 {},接口地址: {}",caseName,url);
            }
        }if(method.equalsIgnoreCase("get") && StringUtils.isEmpty(param)){
            String response=HttpClientUtils.getWithSession(url);
             result=JSON.parseObject(response);
            if(HttpClientUtils.resultCode==HttpStatus.SC_OK){
                updateAutoTestCaseAfterTest(id,response,CaseEnum.SUCCESS.getMessage());
                log.info("运行的用例名称 {},接口地址: {},数据源返回结果 {}",caseName,url,result);
            }else {
                updateAutoTestCaseAfterTest(id,response,CaseEnum.FAIL.getMessage());
                log.error("运行的用例名称 {},接口地址: {}",caseName,url);
            }
        }
       return ResponseResult.createBySuccess(result);
    }



    public int updateAutoTestCaseBeforeTest(int id) {
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs = new AutoTestCaseWithBLOBs();
        autoTestCaseWithBLOBs.setState(CaseEnum.UNKNOW.getMessage());
        autoTestCaseWithBLOBs.setActualResult("null");
        autoTestCaseWithBLOBs.setId(id);
        int i=autoTestCaseMapper.updateByPrimaryKeySelective(autoTestCaseWithBLOBs);
        if(i>0){
            log.info("用例状态初始化成功.....");
        }else log.error("用例状态初始化失败.....");

        return i;
    }

    public int updateAutoTestCaseAfterTest(int id,String response,String state) {
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs = new AutoTestCaseWithBLOBs();

        autoTestCaseWithBLOBs.setId(id);
        autoTestCaseWithBLOBs.setActualResult(response);
        autoTestCaseWithBLOBs.setState(state);

        int i=autoTestCaseMapper.updateByPrimaryKeySelective(autoTestCaseWithBLOBs);
        if(i>0){
            log.info("用例执行状态修改成功.....");
        }else log.error("用例执行状态修改失败.....");

        return i;
    }
}
