package com.example.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author yicg
 * @date 2019-09-22 19:52
 */
public class ExcelTest {

    private static Logger logger=LoggerFactory.getLogger(ExcelTest.class);


    public void test() throws Exception {

        //指明excel文件路径
        ExcelUtility.setExcelFile("/Users/yicg/IdeaProjects/ctwork/src/main/TestData/testExcel.xlsx","login");


    }


    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {

        Object[][] testData=ExcelUtility.getTestData("demo");
      return testData;

    }

    @Test(dataProvider = "loginData")
    public void testLoginExcel(String url) throws IOException {

        HttpGet get=new HttpGet(url);
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);

        String result=EntityUtils.toString(response.getEntity(),"utf=8");
        Assert.assertNotNull(result);
    }



}
