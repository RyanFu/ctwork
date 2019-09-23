package com.example.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstTest {


    @DataProvider(name = "LoginData")
    public Object[][] login() {
        // 测试数据准备
        String file = "/Users/yicg/IdeaProjects/ctwork/src/main/TestData/testcase.xlsx";
        Object[][] records;
        records = ExcelReader.getExpectationData(file, "login");
        System.out.println(records);
        return records ;
    }



    @Test(dataProvider = "LoginData")
    public void loginJDTest(){

        //String caseDecription,String url,String param,String method
      //  System.out.println(caseDecription);



    }

}
