package com.hws.mall.service.impl;

import com.hws.mall.MallApplicationTests;
import com.hws.mall.model.User;
import com.hws.mall.service.IUserService;
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
@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    @Resource
    private IUserService userService;


    @Test
    public void register() {

    }
}