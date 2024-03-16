/**
 * All rights Reserved, Designed By 林溪
 * Copyright:    Copyright(C) 2016-2020
 */

package com.boots.atomikos.common.constants;

/**
 * 分布式事务常量
 * @author：林溪
 * @date：2020年11月16日
 */

public class AtomikosConstant {

    /*****************第一数据库配置****************************/

    // 数据源配置
    public final static String FIRST_DATASOURCE = "firstDataSource";

    // 会话工厂配置
    public final static String FIRST_SESSIONFACTORY = "firstSessionFactory";

    // 映射接口配置
    public final static String FIRST_DAO= "com.boots.atomikos.business.afuser.dao";

    // 数据对象路径
    public final static String FIRST_MODELS = "com.boots.atomikos.business.afuser.model";

    // 映射目录配置
    public final static String FIRST_MAPPER = "classpath:mappers/AfUserMapper.xml";

    /*****************第二数据库配置****************************/

    // 数据源配置
    public final static String SECOND_DATASOURCE = "secondDataSource";

    // 会话工厂配置
    public final static String SECOND_SESSIONFACTORY = "secondSessionFactory";

    // 映射接口配置
    public final static String SECOND_DAO= "com.boots.atomikos.business.afcustomer.dao";

    // 数据对象路径
    public final static String SECOND_MODELS = "com.boots.atomikos.business.afcustomer.model";

    // 映射目录配置
    public final static String SECOND_MAPPER = "classpath:mappers/AfCustomerMapper.xml";

}
