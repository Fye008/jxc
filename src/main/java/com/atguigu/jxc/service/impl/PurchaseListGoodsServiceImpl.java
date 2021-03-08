package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.PurchaseListGoodsMapper;

import com.atguigu.jxc.dao.PurchaseListMapper;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import com.atguigu.jxc.vo.GoodsVo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PurchaseListGoodsServiceImpl implements PurchaseListGoodsService {

    @Autowired
    private PurchaseListGoodsMapper purchaseListGoodsMapper;

    @Autowired
    private PurchaseListMapper purchaseListMapper;

    @Override
    public void savePurchaseList(String purchaseNumber, PurchaseList purchaseList, String purchaseListGoodsStr) {

        Gson gson = new Gson();
        List<GoodsVo> goodsVos = gson.fromJson(purchaseListGoodsStr, new TypeToken<List<GoodsVo>>() {}.getType());

        purchaseList.setPurchaseNumber(purchaseNumber);

        //插入到订单表
        purchaseListMapper.insertPurchaseList(purchaseList);
        //插入到订单详情表
        System.out.println(goodsVos+ "--------------------------------------------" + purchaseList.getPurchaseListId());

        purchaseListGoodsMapper.batchInsertPurchaseGoodsList(purchaseList.getPurchaseListId(),goodsVos);

    }

    @Override
    public List<PurchaseList> list(String purchaseNumber, Integer supplierId, Integer state, String sTime, String eTime) {
        return purchaseListMapper.list(purchaseNumber, supplierId, state, sTime, eTime);


    }

    @Override
    public List<PurchaseListGoods> goodList(Integer purchaseListId) {
        return purchaseListGoodsMapper.goodListByPurchaseListId(purchaseListId);

    }
}
