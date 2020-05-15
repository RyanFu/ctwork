package com.example.dao;

import com.example.model.cmp.TrafficUser;

import java.util.List;

public interface TrafficUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TrafficUser record);

    int insertSelective(TrafficUser record);

    TrafficUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TrafficUser record);

    int updateByPrimaryKey(TrafficUser record);

    List<TrafficUser> selectAll();
}