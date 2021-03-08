package com.atguigu.jxc.dao;


import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PurchaseListGoodsMapper {

    void batchInsertPurchaseGoodsList(@Param("purchaseListId") Integer purchaseListId, @Param("goodsVos") List<GoodsVo> goodsVos);

    List<PurchaseListGoods> goodListByPurchaseListId(Integer purchaseListId);
}
