package com.example.test;


import com.example.util.DatabaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.List;

/**
 * @Author: yicg
 * @Date: 2019/5/29 17:32
 * @Version 1.0
 * 初始化参数
 */

public class InitClass {

    public static Logger logger = LoggerFactory.getLogger(InitClass.class);

    String name1="databaseConfig.xml";
    String name2="databaseConfig-001.xml";

    @Test
    public void init() {
        List list=DatabaseUtil.getSqlSession(name1).selectList("findAll");
        System.out.println(DatabaseUtil.getSqlSession(name1).selectList("findAll"));
        System.out.println(DatabaseUtil.getSqlSession(name2).selectList("findAll"));
        System.out.println(DatabaseUtil.getSqlSession(name2).selectList("findList"));

        logger.info("11111111");
        logger.warn("2222222");
        logger.debug("111111333311");
        logger.error("444444");


    }


}
