package com.hws.mall.service.impl;

import com.hws.mall.dao.CategoryDao;
import com.hws.mall.model.Category;
import com.hws.mall.service.ICategoryService;
import com.hws.mall.vo.CategoryVo;
import com.hws.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static com.hws.mall.consts.MallConst.ROOT_PARENT_ID;

/**
 * ClassName:CategoryServiceImpl
 * Package:com.hws.mall.service.impl
 * Description:
 *
 * @ date:2020/2/21 11:34
 * @ author:hws
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public ResponseVo<List<CategoryVo>> selectAll(){
        List<Category> categories = categoryDao.selectAll();

        List<CategoryVo> categoryVoList = new ArrayList<>();

        //先进行遍历，如果是父接口 parents = 0的话
        for (Category category : categories) {
			if (category.getParentId().equals(ROOT_PARENT_ID)) {
				CategoryVo categoryVo = new CategoryVo();
				BeanUtils.copyProperties(category, categoryVo);
				categoryVoList.add(categoryVo);
			}
		}
        return ResponseVo.succcess(categoryVoList);
    }

    /*@Override
    public ResponseVo<List<CategoryVo>> selectAll() {

        List<CategoryVo> categoryVoList = new ArrayList<>();
        //1、从数据库中查出符合条件的数据
        List<Category> categories = categoryDao.selectAll();

        //2、对查出来的数据进行比较,先查出parents_id = 0 的
        for (Category category : categories) {
            //2.1 先和parents进行比较
            if(ROOT_PARENT_ID.equals(category.getParentId())){
                //2.2 如果是的话，先构造一个CategoryVo的对象
                CategoryVo categoryVo = new CategoryVo();
                BeanUtils.copyProperties(category,categoryVo);
                categoryVoList.add(categoryVo);
            }
        }
        return ResponseVo.succcess(categoryVoList);
    }*/
}
