package com.hws.mall.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
* ClassName:MallCategory
* Package:com.hws.mall.model
* Description:
* @ date:2020/2/21 11:08
* @ author:hws
*/

@Data
public class Category implements Serializable {
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
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;


    public Category(){

    }

    public Category(Integer id){
        this.setId(id);
    }

    public Category(Integer id, Integer parentId, String name, Integer status, Integer sortOrder, Date createTime, Date updateTime) {
        this.setId(id);
        this.setParentId(parentId);
        this.setName(name);
        this.setStatus(status);
        this.setSortOrder(sortOrder);
        this.setCreateTime(createTime);
        this.setUpdateTime(updateTime);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", sortOrder=" + sortOrder +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    private static final long serialVersionUID = 1L;
}