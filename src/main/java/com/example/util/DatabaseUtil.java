package com.example.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {


    public static SqlSession getSqlSession(String name) {
        //获取配置的资源文件,可以配置多数据源，name为相对应的配置文件名称
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //得到SqlSessionFactory，使用类加载器加载xml文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //得到sqlsession对象，这个对象就能执行配置文件中的sql语句啦,传入true,可以自动commit
        SqlSession session = factory.openSession(true);

        return session;
    }
}
