package com.example.mbg;

import com.example.mbg.Feature;

public interface FeatureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Feature record);

    int insertSelective(Feature record);

    Feature selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Feature record);

    int updateByPrimaryKey(Feature record);
}