package com.hws.mall.controller;

import com.hws.mall.enums.ResponseEnum;
import com.hws.mall.from.UserRegisterForm;
import com.hws.mall.model.User;
import com.hws.mall.service.IUserService;
import com.hws.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.hws.mall.enums.ResponseEnum.PARAM_ERROR;

/**
 * ClassName:UserController
 * Package:com.hws.mall.controller
 * Description:
 *
 * @ date:2020/2/19 15:34
 * @ author:hws
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/register")
    public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userRegisterForm,
                                     BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.info("注册提交的参数有误 {} {}",bindingResult.getFieldError().getField(),
                    bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(PARAM_ERROR,bindingResult);
        }
        User user = new User();
        BeanUtils.copyProperties(userRegisterForm,user);
        return userService.registerUser(user);
    }
}
