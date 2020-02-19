package com.hws.mall.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * mall_shipping
 * @ hws
 */
@Data
public class Shipping implements Serializable {
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 收货姓名
     */
    private String receiverName;

    /**
     * 收货固定电话
     */
    private String receiverPhone;

    /**
     * 收货移动电话
     */
    private String receiverMobile;

    /**
     * 省份
     */
    private String receiverProvince;

    /**
     * 城市
     */
    private String receiverCity;

    /**
     * 区/县
     */
    private String receiverDistrict;

    /**
     * 详细地址
     */
    private String receiverAddress;

    /**
     * 邮编
     */
    private String receiverZip;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}