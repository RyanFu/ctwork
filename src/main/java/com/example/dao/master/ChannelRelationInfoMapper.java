package com.example.dao.master;

import com.example.model.ChannelRelationInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChannelRelationInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelRelationInfo record);

    int insertSelective(ChannelRelationInfo record);

    ChannelRelationInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelRelationInfo record);

    int updateByPrimaryKey(ChannelRelationInfo record);

    int updateByUid(ChannelRelationInfo record);

    ChannelRelationInfo selectByUidAndRelationLevel(@Param("uid") String uid,@Param("relationLevel") int relationLevel );

    List<ChannelRelationInfo> selectByUid(String uid);

}