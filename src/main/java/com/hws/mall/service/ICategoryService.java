package com.hws.mall.service;

import com.hws.mall.model.Category;
import com.hws.mall.vo.ResponseVo;

/**
 * ClassName:ICategoryService
 * Package:com.hws.mall.service
 * Description:
 *
 * @ date:2020/2/21 11:34
 * @ author:hws
 */
public interface ICategoryService {
    ResponseVo<Category> getUserInfo(Integer id);
}
