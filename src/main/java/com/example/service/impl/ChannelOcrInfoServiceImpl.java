package com.example.service.impl;

import com.example.dao.ChannelOcrInfoMapper;
import com.example.dao.ChannelUserInfoMapper;
import com.example.model.ChannelOcrInfoWithBLOBs;
import com.example.model.ChannelUserInfo;
import com.example.service.ChannelOcrInfoService;
import com.example.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yicg
 * @createTime 2020年03月24日 17:17:00
 * @Description
 */
@Service
public class ChannelOcrInfoServiceImpl implements ChannelOcrInfoService {

    @Autowired
    private ChannelUserInfoMapper channelUserInfoMapper;

    @Autowired
    private ChannelOcrInfoMapper channelOcrInfoMapper;

    @Override
    public ResponseResult creatChannelOcrInfo() {
        ChannelOcrInfoWithBLOBs ocrInfoWithBLOBs=new ChannelOcrInfoWithBLOBs();

        List<ChannelUserInfo> channelUserInfoList=channelUserInfoMapper.findAllChannelUserInfo();

        for (ChannelUserInfo channelUserInfo:channelUserInfoList){

            ocrInfoWithBLOBs.setUid(channelUserInfo.getUid());
            ocrInfoWithBLOBs.setName(channelUserInfo.getUserName());
            ocrInfoWithBLOBs.setCardIdNo(channelUserInfo.getIdCardNo());
            ocrInfoWithBLOBs.setCardInvalidDate(channelUserInfo.getCardInvalidDate());
            ocrInfoWithBLOBs.setAddress(channelUserInfo.getProvince());
            ocrInfoWithBLOBs.setFetchPhotoMethod("auto");
            ocrInfoWithBLOBs.setDetail("auto test");
            channelOcrInfoMapper.insert(ocrInfoWithBLOBs);

        }

        return ResponseResult.createBySuccess("脚本结束");
    }
}
