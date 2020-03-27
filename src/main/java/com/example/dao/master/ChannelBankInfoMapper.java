package com.example.dao.master;

import com.example.model.ChannelBankInfo;

public interface ChannelBankInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelBankInfo record);

    int insertSelective(ChannelBankInfo record);

    ChannelBankInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelBankInfo record);

    int updateByPrimaryKey(ChannelBankInfo record);

    int updateByUid(ChannelBankInfo record);

    ChannelBankInfo selectByUid(String uid);

}