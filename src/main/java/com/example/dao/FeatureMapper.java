package com.example.dao;

import com.example.model.Feature;

import java.util.List;

public interface FeatureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Feature record);

    int insertSelective(Feature record);

    Feature selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Feature record);

    int updateByPrimaryKey(Feature record);

    List<Feature> findAllFeature();
}