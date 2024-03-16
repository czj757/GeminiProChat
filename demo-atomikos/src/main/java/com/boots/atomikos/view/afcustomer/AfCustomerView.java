/**
 * All rights Reserved, Designed By 林溪开源
 * Copyright:    Copyright(C) 2016-2020
 * Company       林溪开源 Ltd.
 */

package com.boots.atomikos.view.afcustomer;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.boots.atomikos.business.afcustomer.model.AfCustomer;
import com.boots.atomikos.business.afcustomer.service.IAfCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户表后台接口
 * @author：林溪
 * @date： 2020年11月17日
 */
//@Api(tags = { "客户表接口" })
@RestController
@RequestMapping("view/afCustomer")
public class AfCustomerView {

    @Autowired
    private IAfCustomerService afCustomerService;

//    @ApiOperation(value = "测试分布式数据源")
    @GetMapping(value = "/test/{str}")
    public String test(@PathVariable String str) {
        afCustomerService.test(str);
        return "新增成功";
    }

    @GetMapping("/query")
    public Object  query() {
        return afCustomerService.aaa();
    }

    @GetMapping("/query2")
    public Object  query2() {
        return afCustomerService.bbb();
    }
}
