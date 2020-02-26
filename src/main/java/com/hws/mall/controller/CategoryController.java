package com.hws.mall.controller;

import com.hws.mall.model.Category;
import com.hws.mall.service.ICategoryService;
import com.hws.mall.vo.CategoryVo;
import com.hws.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:CategoryController
 * Package:com.hws.mall.controller
 * Description:
 *
 * @ date:2020/2/21 12:13
 * @ author:hws
 */
@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories")
    public ResponseVo<List<CategoryVo>> selectAll() {
        return categoryService.selectAll();
    }
}
