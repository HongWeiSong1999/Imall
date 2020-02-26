package com.hws.mall.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:CategoryVo
 * Package:com.hws.mall.vo
 * Description:
 *
 * @ date:2020/2/21 15:09
 * @ author:hws
 */
@Data
public class CategoryVo implements Serializable {
    /**
     * 类别Id
     */
    private Integer id;

    /**
     * 父类别id当id=0时说明是根节点,一级类别
     */
    private Integer parentId;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 类别状态1-正常,2-已废弃
     */
    private Integer status;

    /**
     * 排序编号,同类展示顺序,数值相等则自然排序
     */
    private Integer sortOrder;

    /**
     *
     */
    private List<CategoryVo> subCategories;

    public CategoryVo() {

    }

    public CategoryVo(Integer id, Integer parentId, String name, Integer status, Integer sortOrder, List<CategoryVo> subCategories) {
        this.setId(id);
        this.setParentId(parentId);
        this.setName(name);
        this.setStatus(status);
        this.setSortOrder(sortOrder);
        this.setSubCategories(subCategories);
    }
}
