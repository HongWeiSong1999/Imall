package com.hws.mall.dao;

import com.hws.mall.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName:CategoryDao
 * Package:com.hws.mall.dao
 * Description:
 *
 * @ date:2020/2/15 22:03
 * @ author:hws
 */
@Mapper
public interface CategoryDao {

    @Select("select * from mall_category where id = #{id}")
    Category findByCategoryId(@Param("id")Integer id);

    Category findByXmlId(Integer id);
}
