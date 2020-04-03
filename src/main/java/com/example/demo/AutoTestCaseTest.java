package com.example.demo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.common.auto.AutoTestCaseFeatureComponent;
import com.example.common.auto.TemplateUtil;
import com.example.common.auto.TmplateParam;
import com.example.dao.second.AutoTestCaseMapper;
import com.example.enums.CaseEnum;
import com.example.model.AutoTestCaseWithBLOBs;
import com.example.util.DatabaseUtil;
import com.example.util.HttpClientUtils;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.Map;


/**
 * @author yicg
 * @createTime 2020年03月30日 14:52:00
 * @Description
 */
@Slf4j
public class AutoTestCaseTest {
    Map<String,Object> headers=Maps.newHashMap();
    SqlSession sqlSession=DatabaseUtil.getSqlSession("databaseConfig.xml");
    AutoTestCaseMapper autoTestCaseMapper=sqlSession.getMapper(AutoTestCaseMapper.class);

    //返回结果字符串
    String  response;





    @Test
    public void selectByPrimaryKeyTest(){
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs=autoTestCaseMapper.selectByPrimaryKey(15);
        String caseName=autoTestCaseWithBLOBs.getCaseName();
        String host=autoTestCaseWithBLOBs.getHost();
        String uri=autoTestCaseWithBLOBs.getUri();
        String port= String.valueOf(autoTestCaseWithBLOBs.getPort());
        String method=autoTestCaseWithBLOBs.getMethod();
        String param_type=autoTestCaseWithBLOBs.getParamType();
        String param=autoTestCaseWithBLOBs.getParam();

        String url=host+":"+port+uri;
        //通过模版映射的请求参数
        String reqBody=TemplateUtil.makeParamter(param,TmplateParam.tmpParam(),AutoTestCaseFeatureComponent.paramMap);
        JSONObject body=JSON.parseObject(reqBody);
        //JSONObject head=JSON.parseObject(heads);
        if(method.equalsIgnoreCase("POST") && CaseEnum.KEY_VALUE.getMessage().equalsIgnoreCase(param_type)){
            //判断返回结果是否为空
             response=HttpClientUtils.postForSession(url,body, headers);
             JSONObject result=JSON.parseObject(response);
             log.info("运行的用例名称 {},接口地址: {},参数:{},数据源返回结果 {}",caseName,url,reqBody,result);
        }
   }

}
