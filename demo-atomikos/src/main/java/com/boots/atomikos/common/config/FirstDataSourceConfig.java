/**
 * All rights Reserved, Designed By 林溪
 * Copyright:    Copyright(C) 2016-2020
 */

package com.boots.atomikos.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mariadb.jdbc.MariaDbDataSource;
import org.mariadb.jdbc.MariaDbPoolDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.boots.atomikos.common.constants.AtomikosConstant;
import com.boots.atomikos.common.data.FirstDbData;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

/**
 * 第一数据源配置
 * @author：林溪
 * @date：2020年11月19日
 */
@Configuration
@MapperScan(basePackages = AtomikosConstant.FIRST_DAO, sqlSessionFactoryRef = AtomikosConstant.FIRST_SESSIONFACTORY)
@Slf4j
public class FirstDataSourceConfig {

    @Autowired
    private FirstDbData firstDbData;

    /**
     * first数据源配置
     * @author OprCalf
     * @return DataSource
     */
    @Bean(AtomikosConstant.FIRST_DATASOURCE)
    @Primary
    public DataSource firstDataSource() throws SQLException {
        final MariaDbPoolDataSource mysqlXaDataSource = new MariaDbPoolDataSource();
        mysqlXaDataSource.setUrl(firstDbData.getFirstUrl());
        mysqlXaDataSource.setPassword(firstDbData.getFirstPassword());
        mysqlXaDataSource.setUser(firstDbData.getFirstUsername());
        mysqlXaDataSource.setMinPoolSize(firstDbData.getMinIdle());
        mysqlXaDataSource.setMaxPoolSize(firstDbData.getMaxActive());
        final AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName(AtomikosConstant.FIRST_DATASOURCE);
        xaDataSource.setPoolSize(firstDbData.getMaxPoolPreparedStatementPerConnectionSize());
        xaDataSource.setMinPoolSize(firstDbData.getMinIdle()-1);
//        xaDataSource.setMinPoolSize(2);
        xaDataSource.setMaxPoolSize(firstDbData.getMaxActive()-5);
//        xaDataSource.setMaxPoolSize(5);
        xaDataSource.setMaxIdleTime(firstDbData.getMinIdle());
        xaDataSource.setMaxLifetime(firstDbData.getMinEvictableIdleTimeMillis());
        xaDataSource.setConcurrentConnectionValidation(true);
        xaDataSource.setTestQuery("select 1 from dual");
        log.info("初始化第一数据库成功");
        return xaDataSource;
    }

    /**
     * 创建第一个SqlSessionFactory
     * @param firstDataSource
     * @return
     * @throws Exception
     */
    @Primary
    @Bean(AtomikosConstant.FIRST_SESSIONFACTORY)
    @SneakyThrows(Exception.class)
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier(AtomikosConstant.FIRST_DATASOURCE) DataSource firstDataSource) {
        final MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(firstDataSource);
        // 设置mapper位置
        bean.setTypeAliasesPackage(AtomikosConstant.FIRST_MODELS);
        // 设置mapper.xml文件的路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(AtomikosConstant.FIRST_MAPPER));
        return bean.getObject();
    }

}
