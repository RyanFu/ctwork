package com.example.test;

import com.example.util.HttpClientUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstTest {

    private static  Logger logger=LoggerFactory.getLogger(FirstTest.class);

    public static String JSESSIONID;


    @DataProvider(name = "LoginData")
    public Object[][] login() {
        // 测试数据准备
        String file = "src/main/TestData/testcase.xlsx";
        Object[][] records=ExcelReader.getExpectationData(file, "login");

        return records ;
    }


    @Test(dataProvider = "LoginData")
    public void loginJDTest(String desc,String url,String method,String param,String ExpectResult) throws IOException {

        if(desc.equalsIgnoreCase("登录")){
            HttpPost post=new HttpPost(url);
            //创建post参数
            JSONObject json=new JSONObject(param);
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("username", (String) json.get("username")));
            list.add(new BasicNameValuePair("password", (String) json.get("password")));

            DefaultHttpClient client=new DefaultHttpClient();
            UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list,"utf-8");
            post.setEntity(entity);
            HttpResponse response =client.execute(post);
            String res=EntityUtils.toString(response.getEntity(),"utf-8");

            CookieStore cookies = client.getCookieStore();
            List<Cookie> cookieList = cookies.getCookies();
            for (Cookie cookie:cookieList) {
                FirstTest.JSESSIONID= cookie.getValue();
            }

            JSONObject jsonObject1=new JSONObject(res);
            JSONObject jsonObject2=new JSONObject(ExpectResult);
            logger.info("登录返回cokie={}",FirstTest.JSESSIONID);
            logger.info("这是登录接口={}",res);
            Assert.assertEquals(jsonObject1.get("status"),jsonObject2.get("status"));

        }else if(desc.equals("获取用户登录信息")){
            Map<String,String> headers =new HashMap<>();
            headers.put("Cookie","JSESSIONID="+FirstTest.JSESSIONID);
            String res=HttpClientUtils.getMethod(url,headers);
            JSONObject jsonObject1=new JSONObject(res);
            JSONObject jsonObject2=new JSONObject(ExpectResult);

            logger.info("这是查询个人信息接口={}",res);
            Assert.assertEquals(jsonObject1.get("status"),jsonObject2.get("status"));

        }

    }
}
