package com.example.service;

import com.example.vo.ResponseResult;

public interface DataSourceService {

    ResponseResult getDataSourceByServiceCode(String serviceCode);


    ResponseResult getAllDataSource();


}
