package com.example.demo;


import com.example.pojo.AutoTestCase;
import com.example.util.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class UserTest {

    SqlSession sqlSession= DatabaseUtil.getSqlSession("databaseConfig-localhost.xml");

    ResourceBundle bundle = ResourceBundle.getBundle("param", Locale.CHINA);

    public String host = bundle.getString("login.host");

    public String loginUri = bundle.getString("login.uri");

    public String username = bundle.getString("login.username");

    public String password = bundle.getString("login.password");


    public static String JSESSIONID;
    public static CookieStore cookieStore;

    List<AutoTestCase> list=sqlSession.selectList("findList");


    @Test(groups = "loginTrue")
    public void loginTest() throws IOException {
        String Url = host + loginUri;

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(Url);

        Map<String, Object> param = new HashMap<>();
        param.put("username", username);
        param.put("password", password);
        //装配post请求参数，key-value
        List<NameValuePair> list = new ArrayList<>();
        for (String key : param.keySet()) {
            list.add(new BasicNameValuePair(key, String.valueOf(param.get(key))));
        }

        //将参数进行编码为合适的格式,如将键值对编码为param1=value1&param2=value2
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
        post.setEntity(entity);

        HttpResponse response = httpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
       /*
         CookieStore cookieStore = httpClient.getCookieStore();
        //List<Cookie> cookieList = cookies.getCookies();
        List<Cookie> cookieList = httpClient.getCookieStore().getCookies();
        //cookieList.forEach(i-> System.out.println(i.getValue()));
        for (Cookie cookie:cookieList) {
          this.JSESSIONID= cookie.getValue();
        }
        Assert.assertNotNull(JSESSIONID);*/
        cookieStore = httpClient.getCookieStore();
        System.out.println(cookieStore);
    }


    @Test(dependsOnGroups = "loginTrue")
    public void getInfo() throws IOException {


        String getUserInfoUrl = host + bundle.getString("get.user.info.uri");

    /*    Map<String, String> head = new HashMap<>();
        head.put("Cookie", "JSESSIONID="+JSESSIONID);

        String vo = HttpClientUtils.getMethod(getUserInfoUrl, head);
        JSONObject jsonObject=new JSONObject(vo);
        JSONObject data= (JSONObject) jsonObject.get("data");
        int status= (int) jsonObject.get("status");

        System.out.println(status);
        Assert.assertEquals(data.get("username"),username);

        AutoTestCase autoTestCase=new AutoTestCase();
        autoTestCase.setState(CaseEnum.SUCCESS.getMessage());
        autoTestCase.setId(4);
        sqlSession.update("updateByState",autoTestCase);
        */

        HttpGet get=new HttpGet(getUserInfoUrl);
        DefaultHttpClient client=new DefaultHttpClient();
        client.setCookieStore(cookieStore);
        HttpResponse response=client.execute(get);
        String result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

    }

}
