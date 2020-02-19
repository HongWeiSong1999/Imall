package com.hws.mall.dao;

import com.hws.mall.MallApplicationTests;
import com.hws.mall.model.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * ClassName:CategoryDaoTest
 * Package:com.hws.mall.dao
 * Description:
 *
 * @ date:2020/2/17 15:58
 * @ author:hws
 */
public class CategoryDaoTest extends MallApplicationTests {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void findByCategoryId() {
        Category categoryDao1 = categoryDao.findByCategoryId(100001);
        System.out.println(categoryDao1);
    }

    @Test
    public void findByXmlId() {
        Category categoryDao2 = categoryDao.findByXmlId(100001);
        System.out.println(categoryDao2);
    }
}