package com.hws.mall.dao;

import com.hws.mall.model.Category;
import org.apache.ibatis.annotations.Mapper;

/**
* ClassName:MallCategoryMapper
* Package:com.hws.mall.dao
* Description:
* @ date:2020/2/21 11:08
* @ author:hws
*/

@Mapper
public interface CategoryDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    int countByPrimaryKey(Integer id);
}