package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.ReturnList;

import java.util.List;

public interface ReturnListGoodsService {

    void returnListGoods(String returnNumber, ReturnList returnList, String returnListGoodsStr);

    List<ReturnList> list(String returnNumber, Integer supplierId, Integer state, String sTime, String eTime);
}
