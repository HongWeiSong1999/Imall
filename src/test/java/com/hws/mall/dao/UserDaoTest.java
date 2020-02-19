package com.hws.mall.dao;

import com.hws.mall.MallApplicationTests;
import com.hws.mall.model.User;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * ClassName:UserDaoTest
 * Package:com.hws.mall.dao
 * Description:
 *
 * @ date:2020/2/17 21:05
 * @ author:hws
 */
public class UserDaoTest extends MallApplicationTests {

    @Resource
    private UserDao userDao;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void countByUsername() {
        int admin1 = userDao.countByUsername("admin");
        System.out.println(admin1);
    }

    @Test
    public void countByEmail() {
        int email1 = userDao.countByEmail("705390497@qq.com");
        System.out.println(email1);
    }

    @Test
    public void selectByUsername(){
        User user1 = userDao.selectByUsername("hws");
        System.out.println(user1);
    }
}