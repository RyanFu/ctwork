package com.example.dao.master;

import com.example.model.ChannelDeviceInfo;

public interface ChannelDeviceInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelDeviceInfo record);

    int insertSelective(ChannelDeviceInfo record);

    ChannelDeviceInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelDeviceInfo record);

    int updateByPrimaryKey(ChannelDeviceInfo record);

    int updateByUid(ChannelDeviceInfo record);

    ChannelDeviceInfo selectByUid(String uid);
}