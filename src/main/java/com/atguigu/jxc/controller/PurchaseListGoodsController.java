package com.atguigu.jxc.controller;


import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaseListGoods")
public class PurchaseListGoodsController {

    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;


    @PostMapping("/save")
    public ServiceVO savePurchaseList(@RequestParam String purchaseNumber,
                                      PurchaseList purchaseList,
                                      String purchaseListGoodsStr) {


        purchaseListGoodsService.savePurchaseList(purchaseNumber, purchaseList, purchaseListGoodsStr);

        return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }


    @PostMapping("/list")
    public Map<String, Object> list(@RequestParam(required = false) String purchaseNumber,
                                    @RequestParam(required = false) Integer supplierId,
                                    @RequestParam(required = false) Integer state,
                                    @RequestParam(required = false) String sTime,
                                    @RequestParam(required = false) String eTime) {


        List<PurchaseList> list = purchaseListGoodsService.list(purchaseNumber, supplierId, state, sTime, eTime);
        System.out.println("++++++++++++++++++++++" + list + " +++++++++++++++++++ ");

        Map<String, Object> map = new HashMap<>();
        map.put("rows", list);
        return map;
    }

    @PostMapping("/goodsList")
    public Map<String, Object> goodsList(Integer purchaseListId) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("++++++++++++++++++" + purchaseListId + "+++++++++");
        List<PurchaseListGoods> list = purchaseListGoodsService.goodList(purchaseListId);
        map.put("rows", list);
        return map;
    }

    /**
     * 根据id删除进货单
     * @param purchaseListId
     * @return
     */
    @PostMapping("/delete")
    public ServiceVO deleteByPurchaseListId(Integer purchaseListId) {

        purchaseListGoodsService.deleteByPurchaseListId(purchaseListId);
        return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }


}
