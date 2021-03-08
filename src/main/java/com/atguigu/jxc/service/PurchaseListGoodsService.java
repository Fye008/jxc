package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;

import java.util.List;
import java.util.Map;

public interface PurchaseListGoodsService {
    void savePurchaseList(String purchaseNumber, PurchaseList purchaseList, String purchaseListGoodsStr);

    List<PurchaseList> list(String purchaseNumber, Integer supplierId, Integer state, String sTime, String eTime);
}
