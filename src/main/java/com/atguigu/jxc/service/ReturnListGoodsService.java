package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.ReturnList;

public interface ReturnListGoodsService {
    void returnListGoods(String returnNumber, ReturnList returnList, String returnListGoodsStr);
}
