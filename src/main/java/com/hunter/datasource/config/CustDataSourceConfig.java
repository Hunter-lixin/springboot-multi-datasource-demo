package com.hunter.datasource.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.hunter.dao.cust", sqlSessionTemplateRef = "custSqlSessionTemplate")
@Slf4j
public class CustDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.cust")
    public DataSourceProperties custDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource custDataSource() {
        DataSourceProperties dataSourceProperties = custDataSourceProperties();
        log.info(dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public SqlSessionFactory custSqlSessionFactory(@Qualifier("custDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/cust/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate custSqlSessionTemplate(@Qualifier("custSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @Resource
    public PlatformTransactionManager custPlatformTransactionManager(@Qualifier("custDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
