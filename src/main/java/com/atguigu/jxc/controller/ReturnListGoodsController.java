package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.service.ReturnListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/returnListGoods")
public class ReturnListGoodsController {

    @Autowired
    private ReturnListGoodsService returnListGoodsService;

    @PostMapping("/save")
    @ResponseBody
    public ServiceVO returnListGoods(@RequestParam String returnNumber,
                                     ReturnList returnList,
                                     String returnListGoodsStr) {

        returnListGoodsService.returnListGoods(returnNumber,returnList, returnListGoodsStr);

        return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
}

}
