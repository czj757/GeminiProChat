/**
 * All rights Reserved, Designed By 林溪
 * Copyright:    Copyright(C) 2016-2020
 */

package com.boots.atomikos.common.config;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

import lombok.SneakyThrows;

/**
 * Atomikos事务管理器
 * @author：林溪
 * @date：2020年11月17日
 */
@Configuration
@EnableTransactionManagement
public class AtomikosConfig {

    /**
     * 初始化JTA事务管理器
     * @author 林溪
     * @return UserTransaction
     */
    @Bean(name = "userTransaction")
    @SneakyThrows(Exception.class)
    public UserTransaction userTransaction() {
        final UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(20000);
        return userTransactionImp;
    }

    /**
     * 初始化Atomikos事务管理器
     * @author 林溪
     * @return TransactionManager
     */
    @Bean(name = "atomikosTransactionManager")
    @SneakyThrows(Exception.class)
    public TransactionManager atomikosTransactionManager() {
        final UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        return userTransactionManager;
    }

    /**
     * 加载事务管理
     * @author 林溪
     * @param atomikosTransactionManager
     * @param userTransaction
     * @return PlatformTransactionManager
     */
    @Bean(name = "transactionManager")
    @SneakyThrows(Throwable.class)
    public PlatformTransactionManager transactionManager(@Qualifier("atomikosTransactionManager") TransactionManager atomikosTransactionManager, @Qualifier("userTransaction") UserTransaction userTransaction) {
        return new JtaTransactionManager(userTransaction(), atomikosTransactionManager());
    }

}
