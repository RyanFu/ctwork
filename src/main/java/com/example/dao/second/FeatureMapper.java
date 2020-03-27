package com.example.dao.second;

import com.example.model.Feature;

public interface FeatureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Feature record);

    int insertSelective(Feature record);

    Feature selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Feature record);

    int updateByPrimaryKey(Feature record);
}