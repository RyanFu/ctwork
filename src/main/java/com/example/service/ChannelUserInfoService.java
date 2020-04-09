package com.example.service;

import com.example.vo.ResponseResult;

public interface ChannelUserInfoService {

    ResponseResult updateChannelUserInfo();


    ResponseResult updateInfoByUid(String uid);

}
