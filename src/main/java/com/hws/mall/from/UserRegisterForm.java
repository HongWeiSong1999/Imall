package com.hws.mall.from;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * ClassName:UserRegisterForm
 * Package:com.hws.mall.from
 * Description:
 *
 * @ date:2020/2/19 15:52
 * @ author:hws
 */
@Data
public class UserRegisterForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String email;


}
