package com.hws.mall.service;

import com.hws.mall.model.Category;
import com.hws.mall.vo.CategoryVo;
import com.hws.mall.vo.ResponseVo;

import java.util.List;

/**
 * ClassName:ICategoryService
 * Package:com.hws.mall.service
 * Description:
 *
 * @ date:2020/2/21 11:34
 * @ author:hws
 */
public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();

}
