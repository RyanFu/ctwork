package com.example.test;


import com.example.util.DatabaseUtil;
import org.testng.annotations.Test;

/**
 * @Author: yicg
 * @Date: 2019/5/29 17:32
 * @Version 1.0
 * 初始化参数
 */

public class InitClass {

    String name1="databaseConfig.xml";
    String name2="databaseConfig-001.xml";

    @Test
    public void init() {
        System.out.println(DatabaseUtil.getSqlSession(name1).selectList("findAll"));
        System.out.println(DatabaseUtil.getSqlSession(name2).selectList("findAll"));
        System.out.println(DatabaseUtil.getSqlSession(name2).selectList("findList"));



    }


}
