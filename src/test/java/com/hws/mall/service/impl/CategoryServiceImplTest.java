package com.hws.mall.service.impl;

import com.hws.mall.MallApplicationTests;
import com.hws.mall.service.ICategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * ClassName:CategoryServiceImplTest
 * Package:com.hws.mall.service.impl
 * Description:
 *
 * @ date:2020/2/26 13:29
 * @ author:hws
 */
public class CategoryServiceImplTest extends MallApplicationTests {

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void selectAll() {
        categoryService.selectAll();
    }
}