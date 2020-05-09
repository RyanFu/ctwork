package com.example.ctwork.yzd;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.common.Const;
import com.example.ctwork.aliexcelreader.DemoData;
import com.example.ctwork.aliexcelreader.Domain;
import com.example.ctwork.aliexcelreader.EasyExcelUtils;
import com.example.dao.FeatureMapper;
import com.example.dao.TrafficUserMapper;
import com.example.model.cmp.TrafficUser;
import com.example.util.*;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;


/**
 * @author yicg
 * @createTime 2020年03月30日 14:52:00
 * @Description  颜值贷模型字段批量
 *
 */
@Slf4j
public class YzdDataTest {
    SqlSession sqlSession1;
    SqlSession sqlSession2;
    FeatureMapper featureMapper;
    TrafficUserMapper trafficUserMapper;
    List<DemoData> demoDataList;



    /**
     * 测试地址
     */
    private static String URL= Const.TEST_WJ_DATA_CENTER_URL;

    /**
     * 初始化sqlSession和初始化执行状态
     */
    @BeforeTest
    public void init(){
        sqlSession1=DatabaseUtil.getSqlSession("yzdDatabaseConfig.xml");
        trafficUserMapper=sqlSession1.getMapper(TrafficUserMapper.class);

        sqlSession2=DatabaseUtil.getSqlSession("yzdFeatureConfig.xml");
        featureMapper =sqlSession2.getMapper(FeatureMapper.class);
    }


    @Test
    public void yzdModelTest(){
        String jsonPath="/Users/yicg/IdeaProjects/ctwork/src/main/json/testparam/yzd_req_json3.json";
        String reqParam="/Users/yicg/IdeaProjects/ctwork/src/main/TestData/数据copy.xlsx";
        String PHONENUM=null;
        String IDCARD=null;
        String NAME=null;
        String UID=null;
        String fields=null;
        List<TrafficUser> list=trafficUserMapper.selectAll();
        List<Domain> reqList= EasyExcelUtils.readExcelWithSheet(reqParam,"颜值贷模型字段",1);
        JSONObject jsonObject= JsonReadUtils.readJsonFile(jsonPath);
        //写入excel模版
        demoDataList= Lists.newArrayList();
        //定义一个存储结果的对象
        DemoData demoData = null;
        String res=null;
        String desc=null;

        //请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        for (TrafficUser user:list){
            PHONENUM=user.getMobileNumber();
            IDCARD=user.getIdNumber();
            NAME=user.getName();
            UID=user.getExternalId();

            JSONObject inFields=jsonObject.getJSONObject("inFields");
            inFields.put("PHONENUM",PHONENUM);
            inFields.put("IDCARD",IDCARD);
            inFields.put("NAME",NAME);
            inFields.put("CONTACNAME",NAME);
            inFields.put("UID",UID);
            jsonObject.put("uid",UID);
            for (Domain domain:reqList){
                fields=domain.getVarName();
                desc=domain.getDesc();
                jsonObject.put("fields",fields);
                String reqTime= DateTimeUtils.formatDateTime(new Date());
                String response = HttpClientUtils.doPostWithJson(URL, jsonObject, headers);
                JSONObject json= JSON.parseObject(response);
                res=json.getString("data");

                demoData=new DemoData();
                demoData.setName(NAME);
                demoData.setIdCard(IDCARD);
                demoData.setMobile(PHONENUM);
                demoData.setUid(UID);
                demoData.setVarName(fields);
                demoData.setDesc(desc);
                demoData.setResult(res);
                demoData.setNowTime(reqTime);
                demoDataList.add(demoData);

                log.info(reqTime+" "+UID+domain.getDesc()+" "+res+demoData);
            }
        }
//        demoDataList.forEach(it -> System.out.println(it));
   }

    /**
     * 结果存到excel
     */
   @AfterTest
   public void afterTest(){
       String nowTime=DateTimeUtils.formatDateTime(new Date());
       String rsultPath = "/Users/yicg/IdeaProjects/ctwork/result_excel/" + nowTime + ".xlsx";
       //写入excel
       EasyExcelUtils.writeExcelWithSheet(demoDataList,rsultPath);
   }
}
