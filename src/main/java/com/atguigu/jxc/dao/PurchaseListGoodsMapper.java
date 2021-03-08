package com.atguigu.jxc.dao;


import com.atguigu.jxc.entity.PurchaseListGoods;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PurchaseListGoodsMapper {

    void batchInsertPurchaseGoodsList(@Param("purchaseListId") Integer purchaseListId, @Param("goodsVos") List<PurchaseListGoods> goodsVos);

    List<PurchaseListGoods> goodListByPurchaseListId(Integer purchaseListId);


}
