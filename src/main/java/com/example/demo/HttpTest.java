package com.example.demo;

import com.example.common.CaseNameEnum;
import com.example.enums.CaseEnum;
import com.example.pojo.AutoTestCase;
import com.example.util.DatabaseUtil;
import com.example.util.HttpUtils;
import com.example.util.JsonUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * 从数据库读取测试case
 */
public class HttpTest {

    private static Logger logger=LoggerFactory.getLogger(HttpTest.class);

    public static SqlSession sqlSession=DatabaseUtil.getSqlSession("databaseConfig-localhost.xml");

    public static  List<AutoTestCase> list=sqlSession.selectList("getAllAutoTestCase");

    @BeforeTest
    public void beforeTest(){
        sqlSession.update("updateAllState");
    }

    @Test
    public void demo1() throws IOException {


       for (AutoTestCase lists:list){

           if(lists.getCaseName().equals(CaseNameEnum.LOGIN.getMessage())){
               AutoTestCase autoTestCase=sqlSession.selectOne("selectByCaseName",CaseNameEnum.LOGIN.getMessage());
               AutoTestCase testCase=new AutoTestCase();
               testCase.setCaseName(autoTestCase.getCaseName());

               /**
                * 把String格式的参数转化为Map格式   {"password":"wangwua123","username":"wangwua"}===>Map
                */
               Map<String,Object> param=JsonUtils.stringToJson(autoTestCase.getParam());
               Map<String, Object> headers=JsonUtils.stringToJson(autoTestCase.getHeads());

              String result=HttpUtils.postForSession(autoTestCase.getUrl(),param,headers);
               JSONObject jsonObject=new JSONObject(result);
               int status= (int) jsonObject.get("status");
               logger.info("登录返回结果={}",jsonObject);
               if(status==0){
                   testCase.setState(CaseEnum.SUCCESS.getMessage());
                   sqlSession.update("updateCaseInfo",testCase);
               }else {
                   testCase.setState(CaseEnum.FAIL.getMessage());
                   sqlSession.update("updateCaseInfo",testCase);
               }
               Assert.assertEquals(jsonObject.get("status"),0);

           }else if(lists.getCaseName().equals(CaseNameEnum.GET_USER_INFO.getMessage())){
               AutoTestCase autoTestCase=sqlSession.selectOne("selectByCaseName",CaseNameEnum.GET_USER_INFO.getMessage());
               AutoTestCase testCase=new AutoTestCase();
               testCase.setCaseName(autoTestCase.getCaseName());

               String result=HttpUtils.getWithSession(autoTestCase.getUrl());
               JSONObject jsonObject=new JSONObject(result);
               logger.info("获取登录信息={}",jsonObject);
               if(jsonObject.get("status").equals(0)){
                   testCase.setState(CaseEnum.SUCCESS.getMessage());
                   sqlSession.update("updateCaseInfo",testCase);
               }else {
                   testCase.setState(CaseEnum.FAIL.getMessage());
                   sqlSession.update("updateCaseInfo",testCase);
               }
               Assert.assertEquals(jsonObject.get("status"),0);

           }

       }

    }
}
