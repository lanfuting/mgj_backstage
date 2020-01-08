package com.cxb.springboot.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.springboot.mapper.CollectMapper;
import com.cxb.springboot.mapper.Sys_CollectionMapper;
import com.cxb.springboot.mapper.Sys_PageMapper;
import com.cxb.springboot.pojo.Collect;
import com.cxb.springboot.pojo.CollectExample;
import com.cxb.springboot.pojo.User;


@Service
public class Collect_Service {
	
	@Autowired
	Sys_CollectionMapper sys_CollectionMapper;
	
	@Autowired
	Sys_PageMapper sys_PageMapper;
	
	@Autowired
	CollectMapper collectMapper;
	
	/**
	 * 根据指定页码获取商品信息的方法
	 * @param rowcount 每页加载信息数量
	 * @param pagenum 指定页码
	 * @return		pageCommodityInformation
	 */
	public List<Map> pageCommodityInformation(Integer rowcount,Integer pagenum){
		RowBounds bounds=new RowBounds(((pagenum-1)*rowcount),rowcount);
		return sys_PageMapper.getPage(bounds);
	}
	
	/**
	 * 将指定商品放入收藏商品
	 * @param info 封装有收藏商品信息的对象
	 */
	public Boolean collection(Collect info){
	
			// 如果是新商品，添加收藏商品信息
			return collectMapper.insertSelective(info)==1;

	}
	
	/**
	 * 根据用户获取 商品收藏相关信息展示
	 * @param user 指定用户对象
	 * @return 封装有 编号、图片、单价等信息的列表
	 */
	public List<Map> getProductDisplay(User user){
		return sys_CollectionMapper.getCollectionByUserID(user.getUserid());
	}
	
	/**
	 * 根据商品的id来删除商品
	 * @param clid
	 * @return
	 */
	public boolean deleteId(Integer gdid){
		CollectExample example = new CollectExample();
		example.createCriteria().andGdidEqualTo(gdid);
		return (collectMapper.deleteByExample(example )==1);
	}

}
