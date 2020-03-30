package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author yicg
 * @createTime 2020年03月27日 14:36:00
 * @Description
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = ThirdDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "thirdSqlSessionFactory")
public class ThirdDataSourceConfig {

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.example.dao.third";
    static final String MAPPER_LOCATION = "classpath:mapper/third/*.xml";

    @Value("${third.spring.datasource.url}")
    private String url;

    @Value("${third.spring.datasource.username}")
    private String user;

    @Value("${third.spring.datasource.password}")
    private String password;

    @Value("${third.spring.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "thirdDataSource")
    public DataSource clusterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "thirdTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "thirdSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("thirdDataSource") DataSource clusterDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ThirdDataSourceConfig.MAPPER_LOCATION));

        //开启驼峰命名
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactory.setConfiguration(configuration);
        return sessionFactory.getObject();
    }
}