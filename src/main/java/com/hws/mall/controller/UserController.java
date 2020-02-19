package com.hws.mall.controller;

import com.hws.mall.enums.ResponseEnum;
import com.hws.mall.from.UserLoginFrom;
import com.hws.mall.from.UserRegisterForm;
import com.hws.mall.model.User;
import com.hws.mall.service.IUserService;
import com.hws.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.hws.mall.consts.MallConst.CURRENT_USER;
import static com.hws.mall.enums.ResponseEnum.NEED_LOGIN;
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
@Slf4j
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * @ Author hongweisong
     * @ Description 用户注册
     * @ Points 用bindingResult来显示提示
     * @ Date 22:16 2020/2/19
     * @ Param [userRegisterForm, bindingResult]
     **/
    @PostMapping("/user/register")
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

    /**
     * @ Author hongweisong
     * @ Description 用户登录
     * @ Points 返回用户，同时设置用户的状态session
     * @ Date 22:18 2020/2/19
     * @ Param
     **/
    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginFrom userLoginFrom,
                                  BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            log.error("登录失败 {} {}",bindingResult.getFieldError().getField(),
                    bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        ResponseVo<User> userResponseVo = userService.userLogin(userLoginFrom.getUsername(), userLoginFrom.getPassword());

        //设置data,这里的话，只设置用户的data就好了，类似于是 (key,value)形式的
        session.setAttribute(CURRENT_USER,userResponseVo.getData());

        return userResponseVo;
    }

    /**
     * @ Author hongweisong
     * @ Description 输出用户信息
     * @ Points 刚刚上面是设置用户信息，这里给它拿到用户信息
     * @ Date 22:48 2020/2/19
     * @ Param [session]
     **/
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session){

        //1、这里的话，就只要拿到这个CURRENT_USER的值就好了
        //(key,value)，这里的话，只要拿到这个key的值，就可以得到这个User的值
        User sessionAttribute = (User)session.getAttribute(CURRENT_USER);

        //2、判断是不是为空
        if(sessionAttribute == null){
            return ResponseVo.error(NEED_LOGIN);
        }

        return ResponseVo.succcess(sessionAttribute);
    }


}
