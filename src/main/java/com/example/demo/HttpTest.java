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

import java.util.List;
import java.util.Map;


/**
 * 从数据库读取测试case并执行
 */
public class HttpTest {

    private static Logger logger=LoggerFactory.getLogger(HttpTest.class);

    public static SqlSession sqlSession=DatabaseUtil.getSqlSession("databaseConfig.xml");

    public static  List<AutoTestCase> list=sqlSession.selectList("findAll");

    @BeforeTest
    public void beforeTest(){
      sqlSession.update("updateAllState");
    }

    @Test(groups = "login")
    public void login(){
        AutoTestCase autoTestCase=sqlSession.selectOne("findByCaseName",CaseNameEnum.LOGIN.getMessage());
        AutoTestCase testCase=new AutoTestCase();
        testCase.setCaseName(autoTestCase.getCaseName());

        /**
         * 把String格式的参数转化为Map<key,values>格式   {"password":"wangwua123","username":"wangwua"}===>Map
         */
        Map<String,Object> params=JsonUtils.stringToJson(autoTestCase.getParam());
        Map<String, Object> headers=JsonUtils.stringToJson(autoTestCase.getHeads());

        String url=autoTestCase.getHost()+":"+autoTestCase.getPort()+autoTestCase.getUri();
        String result=HttpUtils.postForSession(url,params,headers);
        JSONObject jsonObject=new JSONObject(result);
        int status= (int) jsonObject.get("status");
        logger.info("登录返回结果={}",jsonObject);
        Assert.assertEquals(status,0);

        if(status==0){

            testCase.setState(CaseEnum.SUCCESS.getMessage());
            testCase.setActualResult(result);
            sqlSession.update("updateState",testCase);
        }else {
            testCase.setState(CaseEnum.FAIL.getMessage());
            testCase.setActualResult(result);
            sqlSession.update("updateState",testCase);
        }

    }
    @Test(dependsOnGroups = "login")
    public void demo1() {
               AutoTestCase autoTestCase=sqlSession.selectOne("findByCaseName",CaseNameEnum.GET_USER_INFO.getMessage());
               AutoTestCase testCase=new AutoTestCase();
               testCase.setCaseName(autoTestCase.getCaseName());

               String result=HttpUtils.getWithSession(autoTestCase.getHost()+":"+autoTestCase.getPort()+autoTestCase.getUri());
               JSONObject jsonObject=new JSONObject(result);
               logger.info("获取登录信息={}",jsonObject);
               if(jsonObject.get("status").equals(0)){
                   testCase.setState(CaseEnum.SUCCESS.getMessage());
                   testCase.setActualResult(result);
                   sqlSession.update("updateState",testCase);
               }else {
                   testCase.setState(CaseEnum.FAIL.getMessage());
                   testCase.setActualResult(result);
                   sqlSession.update("updateState",testCase);
               }
               Assert.assertEquals(jsonObject.get("status"),0);

           }

}
