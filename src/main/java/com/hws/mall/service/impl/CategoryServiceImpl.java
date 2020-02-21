package com.hws.mall.service.impl;

import com.hws.mall.dao.CategoryDao;
import com.hws.mall.dao.UserDao;
import com.hws.mall.enums.ResponseEnum;
import com.hws.mall.model.Category;
import com.hws.mall.service.ICategoryService;
import com.hws.mall.vo.ResponseVo;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;

import static com.hws.mall.enums.ResponseEnum.CATEGORY_NOT_EXIT;

/**
 * ClassName:CategoryServiceImpl
 * Package:com.hws.mall.service.impl
 * Description:
 *
 * @ date:2020/2/21 11:34
 * @ author:hws
 */
@Mapper
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public ResponseVo<Category> getUserInfo(Integer id) {
        if(categoryDao.countByPrimaryKey(id) == 0){
            return ResponseVo.error(CATEGORY_NOT_EXIT);
        }
        Category category = categoryDao.selectByPrimaryKey(id);
        return ResponseVo.succcess(category);
    }
}
