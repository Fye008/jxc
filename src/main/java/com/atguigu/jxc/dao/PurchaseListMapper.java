package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface PurchaseListMapper {
    void insertPurchaseList(PurchaseList purchaseList);

    List<PurchaseList> list(@Param("purchaseNumber") String purchaseNumber, @Param("supplierId") Integer supplierId,
                                 @Param("state") Integer state, @Param("sTime") String sTime, @Param("eTime") String eTime);
}
