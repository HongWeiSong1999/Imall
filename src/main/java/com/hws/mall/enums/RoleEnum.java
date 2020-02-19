package com.hws.mall.enums;

import lombok.Getter;

/**
 * ClassName:RoleEnum
 * Package:com.hws.mall.enums
 * Description: 角色0-管理员,1-普通用户
 *
 * @ date:2020/2/17 23:09
 * @ author:hws
 */
@Getter
public enum  RoleEnum {
    ADMIN(0), //管理员

    CUSTOMER(1),  //普通用户
    ;

    private Integer code;

    RoleEnum(Integer code) {
        this.code = code;
    }
}
