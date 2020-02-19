package com.hws.mall.dao;

import com.hws.mall.MallApplicationTests;
import com.hws.mall.model.Shipping;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * ClassName:ShippingDaoTest
 * Package:com.hws.mall.dao
 * Description:
 *
 * @ date:2020/2/17 16:59
 * @ author:hws
 */
public class ShippingDaoTest extends MallApplicationTests {

    @Resource
    private ShippingDao shippingDao;

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
        Shipping shipping1 = shippingDao.selectByPrimaryKey(4);
        System.out.println(shipping1.toString());
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}