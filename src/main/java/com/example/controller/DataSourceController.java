package com.example.controller;

import com.example.service.DataSourceService;
import com.example.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yicg
 * @createTime 2020年03月20日 09:31:00
 * @Description
 */
@RestController
@RequestMapping("/data")
public class DataSourceController {

    @Autowired
    private DataSourceService dataSourceService;

    @GetMapping(value = "/get/datasource")
    public ResponseResult getDataSource(@RequestParam String serviceCode){


        return dataSourceService.getDataSourceByServiceCode(serviceCode);
    }


}
