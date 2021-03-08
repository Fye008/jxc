package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.ReturnList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReturnListMapper {
    void saveReturnOrder(ReturnList returnList);
}
