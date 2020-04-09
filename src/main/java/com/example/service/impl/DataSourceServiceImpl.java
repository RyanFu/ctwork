package com.example.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.common.Const;
import com.example.common.datasource.FeatureComponent;
import com.example.common.datasource.TmpParam;
import com.example.dao.third.DataSourceMapper;
import com.example.model.DataSourceWithBLOBs;
import com.example.service.DataSourceService;
import com.example.util.ExcelReaderUtils;
import com.example.util.HttpClientUtils;
import com.example.vo.ResponseResult;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yicg
 * @createTime 2020年03月19日 18:55:00
 * @Description
 */
@Service
@Slf4j
public class DataSourceServiceImpl implements DataSourceService {

    @Autowired
    private DataSourceMapper dataSourceMapper;


    @Override
    public ResponseResult getDataSourceByServiceCode(String serviceCode) {
        List<String> list=Lists.newArrayList();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        DataSourceWithBLOBs bloBs=dataSourceMapper.selectByServiceCode(serviceCode);
        String url=bloBs.getUrlPattern();
        String bodyPattern=bloBs.getBodyPattern();
        //通过模版映射的请求参数
        String reqBody=HttpClientUtils.makeParamter(bodyPattern,TmpParam.tmpParam(),FeatureComponent.parameterMaps);
        JSONObject body=JSON.parseObject(reqBody);
        log.info("数据源名称 {},获取的参数 {}",serviceCode,body);
        //判断返回结果是否为空
        String response=HttpClientUtils.doPostWithKeyValue(url,body,headers);
        if(StringUtils.isEmpty(response)){
            log.error("数据源名称 {},数据源请求失败 {}",serviceCode,response);
            return ResponseResult.createByError(response);
        }
        list.add(serviceCode);
        list.add(url);
        list.add(reqBody);
        list.add(response);
        //获取当前时间
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data=sf.format(new Date());
        list.add(data);
        List<List<String>> lists=Lists.newArrayList();
        lists.add(list);
        //调用写入excel方法
        String excel_path=Const.BASE_PATH+ "/result_excel/result.xlsx";
        ExcelReaderUtils.writeExcel(lists,excel_path);
        JSONObject result=JSON.parseObject(response);
        log.info("数据源名称 {},数据源返回结果 {}",serviceCode,result);
        return ResponseResult.createBySuccess(result);

    }


}
