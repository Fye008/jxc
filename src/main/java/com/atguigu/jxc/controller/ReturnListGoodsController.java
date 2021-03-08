package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.entity.ReturnListGoods;
import com.atguigu.jxc.service.ReturnListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/returnListGoods")
public class ReturnListGoodsController {

    @Autowired
    private ReturnListGoodsService returnListGoodsService;

    @PostMapping("/save")
    public ServiceVO returnListGoods(@RequestParam String returnNumber,
                                     ReturnList returnList,
                                     String returnListGoodsStr) {

        returnListGoodsService.returnListGoods(returnNumber, returnList, returnListGoodsStr);

        return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @PostMapping("/list")
    public Map<String, Object> list(@RequestParam(required = false) String returnNumber,
                                    @RequestParam(required = false) Integer supplierId,
                                    @RequestParam(required = false) Integer state,
                                    @RequestParam(required = false) String sTime,
                                    @RequestParam(required = false) String eTime) {
        Map<String, Object> map = new HashMap<>();
        List<ReturnList> list = returnListGoodsService.list(returnNumber, supplierId, state, sTime, eTime);
        map.put("rows", list);
        return map;

    }


    @PostMapping("/goodsList")
    public Map<String,Object> goodList(Integer returnListId){

        Map<String, Object> map = new HashMap<>();
        List<ReturnListGoods> list = returnListGoodsService.goodList(returnListId);
        map.put("rows", list);
        return map;
    }

    @PostMapping("/delete")
    public ServiceVO delete(Integer returnListId){
        returnListGoodsService.delete(returnListId);
        return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);

    }







}
