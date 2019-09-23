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
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class UserTest {

    ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public String host = bundle.getString("login.host");

    public String loginUri = bundle.getString("login.uri");

    public String username = bundle.getString("login.username");

    public String password = bundle.getString("login.password");


    public static String JSESSIONID;


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
        CookieStore cookies = httpClient.getCookieStore();
        //List<Cookie> cookieList = cookies.getCookies();
        List<Cookie> cookieList = httpClient.getCookieStore().getCookies();
        //cookieList.forEach(i-> System.out.println(i.getValue()));
        for (Cookie cookie:cookieList) {
          this.JSESSIONID= cookie.getValue();
        }
        Assert.assertNotNull(JSESSIONID);
    }


    @Test(dependsOnGroups = "loginTrue")
    public void getInfo() {
        String getUserInfoUrl = host + bundle.getString("get.user.info.uri");

        Map<String, String> head = new HashMap<>();
        head.put("Cookie", "JSESSIONID="+JSESSIONID);

        String result = HttpClientUtils.getMethod(getUserInfoUrl, head);
        JSONObject jsonObject=new JSONObject(result);
        JSONObject data= (JSONObject) jsonObject.get("data");
        System.out.println(data.get("username"));
        Assert.assertEquals(data.get("username"),username);
    }

}
