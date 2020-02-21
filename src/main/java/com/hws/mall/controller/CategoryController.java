package com.hws.mall.controller;

import com.hws.mall.model.Category;
import com.hws.mall.service.ICategoryService;
import com.hws.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName:CategoryController
 * Package:com.hws.mall.controller
 * Description:
 *
 * @ date:2020/2/21 12:13
 * @ author:hws
 */
@RestController
@Slf4j
public class CategoryController {

    @Resource
    private ICategoryService categoryService;

    @GetMapping("/categories")
    public ResponseVo<Category> getUserInfo(Integer id){
        categoryService.getUserInfo(id);
        return ResponseVo.succcess();
    }

}
