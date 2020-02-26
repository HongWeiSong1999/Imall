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
import java.util.Comparator;
import java.util.List;

import static com.hws.mall.consts.MallConst.ROOT_PARENT_ID;

/**
 * ClassName:CategoryServiceImpl
 * Package:com.hws.mall.service.impl
 * Description:
 *
 * @ date:2020/2/21 11:34
 * @author:hws
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryDao categoryDao;

    /**
     * @ Description 实现所有的分类信息
     * @ Points 从父目录到子目录
     * @ Date 17:19 2020/2/26
     * @ Param []
     **/
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
        categoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
        findSubCategory(categoryVoList, categories);
        return ResponseVo.succcess(categoryVoList);
    }

    //耗时：http(请求) > mysql查询 > 内存(java程序)
    //mysql(内网+磁盘的形式)
    //严禁在for循环里面写http请求或者sql语句

    /**
     * 定义查询子目录的方式
     */
    private void findSubCategory(List<CategoryVo> categoryVoList, List<Category> categories) {
        for (CategoryVo categoryVo : categoryVoList) {
            List<CategoryVo> subCategoryVoList = new ArrayList<>();

            for (Category category : categories) {
                //如果查到内容，设置subCategory, 继续往下查
                if (categoryVo.getId().equals(category.getParentId())) {
                    CategoryVo subCategoryVo = category2CategoryVo(category);
                    subCategoryVoList.add(subCategoryVo);
                }
                subCategoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
                categoryVo.setSubCategories(subCategoryVoList);

                findSubCategory(subCategoryVoList,categories);
            }
        }
    }

    private CategoryVo category2CategoryVo(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }
}
