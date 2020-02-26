package com.hws.mall.dao;

import com.hws.mall.model.Category;
import com.hws.mall.vo.CategoryVo;
import com.hws.mall.vo.ResponseVo;
import org.apache.ibatis.annotations.Mapper;

import java.awt.*;
import java.util.List;

/**
* ClassName:MallCategoryMapper
* Package:com.hws.mall.dao
* Description:
* @ date:2020/2/21 11:08
* @ author:hws
*/

public interface CategoryDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    int countByPrimaryKey(Integer id);

    List<Category> selectAll();
}