package com.cxb.springboot.mapper;

import com.cxb.springboot.pojo.Scrollimgs;
import com.cxb.springboot.pojo.ScrollimgsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScrollimgsMapper {
    int countByExample(ScrollimgsExample example);

    int deleteByExample(ScrollimgsExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(Scrollimgs record);

    int insertSelective(Scrollimgs record);

    List<Scrollimgs> selectByExample(ScrollimgsExample example);

    Scrollimgs selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") Scrollimgs record, @Param("example") ScrollimgsExample example);

    int updateByExample(@Param("record") Scrollimgs record, @Param("example") ScrollimgsExample example);

    int updateByPrimaryKeySelective(Scrollimgs record);

    int updateByPrimaryKey(Scrollimgs record);
}