package com.hws.mall.from;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * ClassName:UserLoginFrom
 * Package:com.hws.mall.from
 * Description:
 *
 * @ date:2020/2/19 22:19
 * @ author:hws
 */
@Data
public class UserLoginFrom {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
