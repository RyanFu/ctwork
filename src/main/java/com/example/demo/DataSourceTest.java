package com.example.demo;


import com.example.dao.second.AutoTestCaseMapper;
import com.example.model.AutoTestCaseWithBLOBs;
import com.example.util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;


/**
 * @author yicg
 * @createTime 2020年03月30日 14:52:00
 * @Description
 */
@Slf4j
public class DataSourceTest {

    SqlSession sqlSession=DatabaseUtil.getSqlSession("databaseConfig.xml");
    AutoTestCaseMapper autoTestCaseMapper=sqlSession.getMapper(AutoTestCaseMapper.class);



    @Test
    public void selectByPrimaryKeyTest(){

        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs=autoTestCaseMapper.selectByPrimaryKey(15);

        System.out.println(autoTestCaseWithBLOBs.getHost());
        System.out.println(autoTestCaseWithBLOBs.getUri());
   }

}
