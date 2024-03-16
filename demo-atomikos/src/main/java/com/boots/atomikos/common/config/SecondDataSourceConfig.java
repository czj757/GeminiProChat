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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.boots.atomikos.common.constants.AtomikosConstant;
import com.boots.atomikos.common.data.SecondDbData;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

/**
 * 第二数据源配置
 * @author：林溪
 * @date：2020年11月19日
 */
@Configuration
@MapperScan(basePackages = AtomikosConstant.SECOND_DAO, sqlSessionFactoryRef = AtomikosConstant.SECOND_SESSIONFACTORY)
@Slf4j
public class SecondDataSourceConfig {

    @Autowired
    private SecondDbData secondDbData;

    /**
     * second数据源配置
     * @author OprCalf
     * @return DataSource
     */
    @Bean(AtomikosConstant.SECOND_DATASOURCE)
    public DataSource secondDataSource() throws SQLException {
        // 使用mysql的分布式驱动，支持MySql5.*、MySql8.* 以上版本
        final MariaDbPoolDataSource mysqlXaDataSource = new MariaDbPoolDataSource();
        mysqlXaDataSource.setUrl(secondDbData.getSecondUrl());
        mysqlXaDataSource.setPassword(secondDbData.getSecondPassword());
        mysqlXaDataSource.setUser(secondDbData.getSecondUsername());
        mysqlXaDataSource.setMinPoolSize(secondDbData.getMinIdle());
        mysqlXaDataSource.setMaxPoolSize(secondDbData.getMaxActive());
        final AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName(AtomikosConstant.SECOND_DATASOURCE);
        xaDataSource.setPoolSize(secondDbData.getMaxPoolPreparedStatementPerConnectionSize());
        xaDataSource.setMinPoolSize(secondDbData.getMinIdle()-1);
//        xaDataSource.setMinPoolSize(2);
        xaDataSource.setMaxPoolSize(secondDbData.getMaxActive()-5);
//        xaDataSource.setMaxPoolSize(5);
        xaDataSource.setMaxIdleTime(secondDbData.getMinIdle());
        xaDataSource.setMaxLifetime(secondDbData.getMinEvictableIdleTimeMillis());
        xaDataSource.setConcurrentConnectionValidation(true);
        xaDataSource.setTestQuery("select 1 from dual");
        log.info("初始化第二数据库成功");
        return xaDataSource;
    }

    /**
     * 创建第一个SqlSessionFactory
     * @param secondDataSource
     * @return
     * @throws Exception
     */
    @Bean(AtomikosConstant.SECOND_SESSIONFACTORY)
    @SneakyThrows(Exception.class)
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier(AtomikosConstant.SECOND_DATASOURCE) DataSource secondDataSource) {
        final MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(secondDataSource);
        // 设置mapper位置
        bean.setTypeAliasesPackage(AtomikosConstant.SECOND_MODELS);
        // 设置mapper.xml文件的路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(AtomikosConstant.SECOND_MAPPER));
        return bean.getObject();
    }

}
