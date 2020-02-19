package com.hws.mall.dao;

import com.hws.mall.model.Shipping;
import org.apache.ibatis.annotations.Mapper;

public interface ShippingDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);
}