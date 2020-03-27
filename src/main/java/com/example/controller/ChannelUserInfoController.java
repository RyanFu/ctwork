package com.example.controller;

import com.example.service.ChannelUserInfoService;
import com.example.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yicg
 * @createTime 2020年03月24日 17:56:00
 * @Description
 */
@RestController
public class ChannelUserInfoController {

    @Autowired
    private ChannelUserInfoService channelUserInfoService;


    @GetMapping(value = "/update/userinfo")
    public ResponseResult updateUserInfo(){

      return   channelUserInfoService.updateChannelUserInfo();
    }


    @GetMapping(value = "/update/all")
    public ResponseResult updateInfoByUid(@RequestParam String uid){

        return channelUserInfoService.updateInfoByUid(uid);
    }
}
