/**
 * All rights Reserved, Designed By 林溪开源
 * Copyright:    Copyright(C) 2016-2020
 * Company       林溪开源 Ltd.
 */

package com.boots.atomikos.business.afuser.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boots.atomikos.business.afuser.model.AfUser;

import java.util.List;


/**
 * 用户表表数据服务层
 *
 * @author：林溪
 * @date： 2020年11月17日
 */
@Mapper
public interface IAfUserDao extends BaseMapper<AfUser> {

	List<AfUser> bbb();
}