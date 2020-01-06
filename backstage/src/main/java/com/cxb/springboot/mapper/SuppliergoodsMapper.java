package com.cxb.springboot.mapper;

import com.cxb.springboot.pojo.Suppliergoods;
import com.cxb.springboot.pojo.SuppliergoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuppliergoodsMapper {
    int countByExample(SuppliergoodsExample example);

    int deleteByExample(SuppliergoodsExample example);

    int deleteByPrimaryKey(Integer ssuppliergoodsid);

    int insert(Suppliergoods record);

    int insertSelective(Suppliergoods record);

    List<Suppliergoods> selectByExample(SuppliergoodsExample example);

    Suppliergoods selectByPrimaryKey(Integer ssuppliergoodsid);

    int updateByExampleSelective(@Param("record") Suppliergoods record, @Param("example") SuppliergoodsExample example);

    int updateByExample(@Param("record") Suppliergoods record, @Param("example") SuppliergoodsExample example);

    int updateByPrimaryKeySelective(Suppliergoods record);

    int updateByPrimaryKey(Suppliergoods record);
}