package com.hws.mall.service.impl;

import com.hws.mall.MallApplicationTests;
import com.hws.mall.enums.ResponseEnum;
import com.hws.mall.model.User;
import com.hws.mall.service.IUserService;
import com.hws.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName:UserServiceImplTest
 * Package:com.hws.mall.service.Impl
 * Description:
 *
 * @ date:2020/2/17 22:42
 * @ author:hws
 */
@Slf4j
@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    public static final String USERNAME = "HONGWS";

    public static final String PASSWORD = "qweasdzxc99";

    public static final String EMAIL = "705390493@qq.com";

    public static final Integer ROLE = 1;


    @Resource
    private IUserService userService;


    @Before
    public void registerUser() {
        User user = new User(USERNAME,PASSWORD,EMAIL,ROLE);
        userService.registerUser(user);
    }

    @Test
    public void userLogin() {
        //1、进行登录的时候必须先注册
        registerUser();

        //2、用定义的username和password进行登录，返回ResponseVo
        ResponseVo<User> responseVo = userService.userLogin(USERNAME, PASSWORD);

        //3、定义的返回成功的Status的值是0，我们用断言来进行比较（long,long）或者（Object,Object）
        //   Assert.assertEquals的前一个是 我们的预期值，后一个是实际的值，
        //   这里我们预期的前一个值是0，实际的值也是0（返回success,而success的返回值Status是0）
        //   在预期值这里我们不能写上0，不然就是Integer,
        Assert.assertEquals(ResponseEnum.SUCCESS_STATUS.getCode(),responseVo.getStatus());
    }
}