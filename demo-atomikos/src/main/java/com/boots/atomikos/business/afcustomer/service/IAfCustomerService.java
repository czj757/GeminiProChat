/**
 * All rights Reserved, Designed By 林溪开源
 * Copyright:    Copyright(C) 2016-2020
 * Company       林溪开源 Ltd.
 */

package com.boots.atomikos.business.afcustomer.service;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boots.atomikos.business.afcustomer.model.AfCustomer;
import com.boots.atomikos.business.afuser.model.AfUser;

import java.util.List;

/**
 * 客户表逻辑服务层
 * @author：林溪
 * @date： 2020年11月17日
 */
public interface IAfCustomerService extends IService<AfCustomer> {

    void test(String name);
    List<AfCustomer> aaa() ;
    List<AfUser> bbb();

}
