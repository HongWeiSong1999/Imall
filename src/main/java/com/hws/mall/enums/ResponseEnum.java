package com.hws.mall.enums;

import lombok.Data;
import lombok.Getter;

/**
 * ClassName:ResponseEnum
 * Package:com.hws.mall.enums
 * Description:
 *
 * @ date:2020/2/18 16:10
 * @ author:hws
 */
@Getter
public enum ResponseEnum {

    SERVICE_ERROR(-1,"服务端错误"), //服务端错误，返回-1

    SUCCESS_STATUS(0,"成功"), //响应成功的状态为0

    FAIL_STATUS(1,"密码错误"), //用户密码错误的是1

    USERNAME_EXIT(2,"用户名已存在"), //用户名已存在的是2

    PARAM_ERROR(3,"参数错误"), //参数错误是3

    EMAIL_EXIT(4,"邮箱已经存在"), //邮箱已经存在的是4

    NEED_LOGIN(10,"用户未登录，请先登录"), //用户未登录为10

    USERNAME_OR_PASSWORD_ERROR(11,"用户名或密码错误"), //用户名或者密码错误为11
    ;

    private Integer code;

    private String msg;

    ResponseEnum(String msg) {
        this.msg = msg;
    }

    ResponseEnum(Integer code) {
        this.code = code;
    }

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
