/**
 * All rights Reserved, Designed By 林溪开源
 * Copyright:    Copyright(C) 2016-2020
 * Company       林溪开源 Ltd.
 */

package com.boots.atomikos.business.afuser.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * 用户表表实体类
 * @author：林溪
 * @date： 2020年11月17日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "af_user")
public class AfUser extends Model<AfUser>{

    private static final long serialVersionUID = 1L;
    // 用户id    @TableId(value = "user_id", type = IdType.ASSIGN_ID)    private Long userId;    // 用户名称    @TableField(value="user_name")    private String userName;
}

