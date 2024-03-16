/**
 * All rights Reserved, Designed By 林溪开源
 * Copyright:    Copyright(C) 2016-2020
 * Company       林溪开源 Ltd.
 */

package com.boots.atomikos.business.afuser.service.impl;


import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boots.atomikos.business.afuser.dao.IAfUserDao;
import com.boots.atomikos.business.afuser.model.AfUser;
import com.boots.atomikos.business.afuser.service.IAfUserService;


/**
 * 用户表表逻辑服务实现层
 * @author：林溪
 * @date： 2020年11月17日
 */
@Service
public class AfUserServiceImpl extends ServiceImpl<IAfUserDao, AfUser> implements IAfUserService {

}
