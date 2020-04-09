package com.example.controller;

import com.example.service.ChannelOcrInfoService;
import com.example.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yicg
 * @createTime 2020年03月24日 17:31:00
 * @Description
 */
@RestController
public class ChannelOcrInfoController {

    @Autowired
    private ChannelOcrInfoService channelOcrInfoService;

    @GetMapping(value = "/insert/channel-ocr-info")
    public ResponseResult insertChannelOcrInfo(){

        return channelOcrInfoService.creatChannelOcrInfo();
    }
}
