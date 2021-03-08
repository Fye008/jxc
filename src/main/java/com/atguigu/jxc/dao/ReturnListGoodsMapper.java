package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.entity.ReturnListGoods;
import com.atguigu.jxc.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReturnListGoodsMapper {

    void saveReturnGoodsOrder(@Param("returnListId") Integer returnListId, @Param("goods") List<GoodsVo> goodsVos);

    List<ReturnListGoods> goodList(Integer returnListId);
}
