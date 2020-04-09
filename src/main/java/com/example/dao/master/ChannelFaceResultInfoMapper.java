package com.example.dao.master;

import com.example.model.ChannelFaceResultInfo;

public interface ChannelFaceResultInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelFaceResultInfo record);

    int insertSelective(ChannelFaceResultInfo record);

    ChannelFaceResultInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelFaceResultInfo record);

    int updateByPrimaryKey(ChannelFaceResultInfo record);

    int updateByUid(ChannelFaceResultInfo record);

    ChannelFaceResultInfo selectByUid(String uid);
}