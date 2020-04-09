package com.example.dao.master;

import com.example.model.ChannelOcrInfo;
import com.example.model.ChannelOcrInfoWithBLOBs;

import java.util.List;

public interface ChannelOcrInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelOcrInfoWithBLOBs record);

    int insertSelective(ChannelOcrInfoWithBLOBs record);

    ChannelOcrInfoWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelOcrInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ChannelOcrInfoWithBLOBs record);

    int updateByPrimaryKey(ChannelOcrInfo record);

    int updateByUid(ChannelOcrInfoWithBLOBs record);

    ChannelOcrInfoWithBLOBs selectByUid(String  uid);
}