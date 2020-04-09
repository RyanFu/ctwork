package com.example.dao.master;

import com.example.model.ChannelUserInfo;

import java.util.List;

public interface ChannelUserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelUserInfo record);

    int insertSelective(ChannelUserInfo record);

    ChannelUserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelUserInfo record);

    int updateByPrimaryKey(ChannelUserInfo record);

    List<ChannelUserInfo> findAllChannelUserInfo();

    int updateAll(ChannelUserInfo record);


    ChannelUserInfo selectByUid(String uid);

}