package com.cxb.springboot.mapper;

import com.cxb.springboot.pojo.Collect;
import com.cxb.springboot.pojo.CollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectMapper {
    int countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(Integer clid);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(Integer clid);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}