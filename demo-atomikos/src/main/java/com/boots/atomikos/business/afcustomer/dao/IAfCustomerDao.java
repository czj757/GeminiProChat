/**
 * All rights Reserved, Designed By 林溪开源
 * Copyright:    Copyright(C) 2016-2020
 * Company       林溪开源 Ltd.
 */

package com.boots.atomikos.business.afcustomer.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boots.atomikos.business.afcustomer.model.AfCustomer;

import java.util.List;


/**
 * 客户表数据服务层
 * @author：林溪
 * @date： 2020年11月17日
 */
@Mapper
public interface IAfCustomerDao extends BaseMapper<AfCustomer>{

	List<AfCustomer> aaa();
}