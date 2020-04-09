package com.example.demo;


import com.example.dao.second.AutoTestCaseMapper;
import com.example.enums.CaseEnum;
import com.example.model.AutoTestCaseWithBLOBs;
import com.example.util.ApiTestUtils;
import com.example.util.DatabaseUtil;
import com.example.util.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



/**
 * @author yicg
 * @createTime 2020年03月30日 14:52:00
 * @Description
 */
@Slf4j
public class AutoTestCaseTest {


    SqlSession sqlSession;

    AutoTestCaseMapper autoTestCaseMapper;

    //返回结果字符串
    String  response=null;

    int id=16;

    /**
     * 初始化sqlSession和初始化执行状态
     */
    @BeforeTest
    public void init(){
        sqlSession=DatabaseUtil.getSqlSession("databaseConfig.xml");
        autoTestCaseMapper =sqlSession.getMapper(AutoTestCaseMapper.class);

        //初始化待测用例
        updateAutoTestCaseBeforeTest(id);

        selectByPrimaryKeyTest();
    }



    @Test
    public void selectByPrimaryKeyTest(){
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs=autoTestCaseMapper.selectByPrimaryKey(id);
        response=ApiTestUtils.doHttpRequest(autoTestCaseWithBLOBs);
        if(HttpClientUtils.resultCode==HttpStatus.SC_OK){
            updateAutoTestCaseAfterTest(id,response,CaseEnum.SUCCESS.getMessage());
        }else {
            updateAutoTestCaseAfterTest(id,response,CaseEnum.FAIL.getMessage());
            throw new RuntimeException("用例执行失败...");
        }

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
