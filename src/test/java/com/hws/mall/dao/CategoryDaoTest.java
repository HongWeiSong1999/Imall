package com.hws.mall.dao;

import com.hws.mall.MallApplicationTests;
import com.hws.mall.model.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:CategoryDaoTest
 * Package:com.hws.mall.dao
 * Description:
 *
 * @ date:2020/2/17 15:58
 * @ author:hws
 */
@Transactional
public class CategoryDaoTest extends MallApplicationTests {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void selectByPrimaryKey() {
        Category category = categoryDao.selectByPrimaryKey(100001);
        System.out.println(category.toString());
    }
}