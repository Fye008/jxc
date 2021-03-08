package com.atguigu.jxc.vo;

import lombok.Data;

@Data
public class GoodsVo {


    //"goodsTypeId":16,"goodsModel":"Note8",
    // "goodsUnit":"台","lastPurchasingPrice":2220,"price":"2220","goodsNum":"3","total":6660}]

    private Integer purchaseListGoodsId;
    private Integer goodsId;
    private String goodsCode;
    private String goodsName;

    private Integer goodsTypeId;
    private String goodsModel;
    private String goodsUnit;
    private double lastPurchasingPrice;
    private double price;

    private Integer goodsNum;

    private Integer purchase_list_id;
    private double total; //总价




}
