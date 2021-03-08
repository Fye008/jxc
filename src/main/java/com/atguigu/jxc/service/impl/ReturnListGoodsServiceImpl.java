package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.ReturnListGoodsMapper;
import com.atguigu.jxc.dao.ReturnListMapper;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.atguigu.jxc.vo.GoodsVo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReturnListGoodsServiceImpl implements ReturnListGoodsService {


    @Autowired
    private ReturnListGoodsMapper returnListGoodsMapper;

    @Autowired
    private ReturnListMapper returnListMapper;

    @Override
    public void returnListGoods(String returnNumber, ReturnList returnList, String returnListGoodsStr) {

        returnList.setReturnNumber(returnNumber);
        //新增退款订单
        returnListMapper.saveReturnOrder(returnList);


        Gson gson = new Gson();
        List<GoodsVo> goodsVos = gson.fromJson(returnListGoodsStr, new TypeToken<List<GoodsVo>>() {
        }.getType());


        System.out.println(returnList.getReturnListId() + "+++++++++++++++++++++++++++++++++++++");
        //新增退款详情订单
        returnListGoodsMapper.saveReturnGoodsOrder(returnList.getReturnListId(), goodsVos);

        //todo 对应库存减少

    }

    @Override
    public List<ReturnList> list(String returnNumber, Integer supplierId, Integer state, String sTime, String eTime) {

        return returnListMapper.list(returnNumber, supplierId, state, sTime, eTime);

    }
}
