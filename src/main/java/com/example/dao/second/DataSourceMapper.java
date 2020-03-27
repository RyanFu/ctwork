package com.example.dao.second;

import com.example.model.DataSource;
import com.example.model.DataSourceWithBLOBs;

import java.util.List;

public interface DataSourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataSourceWithBLOBs record);

    int insertSelective(DataSourceWithBLOBs record);

    DataSourceWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataSourceWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DataSourceWithBLOBs record);

    int updateByPrimaryKey(DataSource record);

    DataSourceWithBLOBs selectByServiceCode(String serviceCode);

    List<DataSourceWithBLOBs> selectAllDataSource();
}