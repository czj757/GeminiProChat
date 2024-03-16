/**
 * All rights Reserved, Designed By 林溪
 * Copyright:    Copyright(C) 2016-2020
 */

package com.boots.atomikos.common.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 第一数据库属性
 * @author：林溪
 * @date：2020年11月16日
 */
@Configuration
@Data
public class FirstDbData {

    @Value("${first.datasource.url}")
    private String firstUrl;

    @Value("${first.datasource.username}")
    private String firstUsername;

    @Value("${first.datasource.password}")
    private String firstPassword;

    @Value("${jasypt.password:yx98ny34r9n2y43zn98rny324-9rtn3z4y328t}")
    private String jasyptPassword;

    @Value("${common.datasource.initial-size:1}")
    private int initialSize;

    @Value("${common.datasource.max-active:30}")
    private int maxActive;

    @Value("${common.datasource.min-idle:3}")
    private int minIdle;

    @Value("${common.datasource.max-wait:60000}")
    private int maxWait;

    @Value("${common.datasource.time-between-eviction-runs-millis:60000}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${common.datasource.min-evictable-idle-time-millis:300000}")
    private int minEvictableIdleTimeMillis;

    @Value("${common.datasource.test-while-idle:true}")
    private boolean testWhileIdle;

    @Value("${common.datasource.test-on-borrow:false}")
    private boolean testOnBorrow;

    @Value("${common.datasource.test-on-return:false}")
    private boolean testOnReturn;

    @Value("${common.datasource.pool-prepared-statements:true}")
    private boolean poolPreparedStatements;

    @Value("${common.datasource.max-pool-prepared-statement-per-connection-size:20}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${common.datasource.filter-class-names:stat,slf4j}")
    private String filters;

    @Value("${common.datasource.connection-properties:druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000}")
    private String connectionProperties = "";

}
