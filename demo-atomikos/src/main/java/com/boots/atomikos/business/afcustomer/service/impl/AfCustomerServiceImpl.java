/**
 * All rights Reserved, Designed By 林溪开源
 * Copyright:    Copyright(C) 2016-2020
 * Company       林溪开源 Ltd.
 */

package com.boots.atomikos.business.afcustomer.service.impl;

import javax.transaction.Transactional;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boots.atomikos.business.afcustomer.dao.IAfCustomerDao;
import com.boots.atomikos.business.afcustomer.model.AfCustomer;
import com.boots.atomikos.business.afcustomer.service.IAfCustomerService;
import com.boots.atomikos.business.afuser.dao.IAfUserDao;
import com.boots.atomikos.business.afuser.model.AfUser;

import java.util.List;

/**
 * 客户表逻辑服务实现层
 * @author：林溪
 * @date： 2020年11月17日
 */
@Transactional
@Service
public class AfCustomerServiceImpl extends ServiceImpl<IAfCustomerDao, AfCustomer> implements IAfCustomerService {

    @Autowired
    private IAfCustomerDao afCustomerDao;

    @Autowired
    private IAfUserDao afUserDao;

    @Override
    public void test(String name) {
        final AfCustomer afCustomer = AfCustomer.builder().customerName("客户1").build();
        final AfUser afUser = AfUser.builder().userName("用户1").build();
        final int i = afCustomerDao.insert(afCustomer);
        afUserDao.insert(afUser);
        System.out.println(name.split("")[3]);
    }

    @Override
    public List<AfCustomer> aaa() {
        List<AfUser> bbb = afUserDao.bbb();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return afCustomerDao.aaa();
    }

    @Override
    public List<AfUser> bbb() {
//        List<AfUser> bbb = afUserDao.bbb();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return afUserDao.bbb();
    }
}
