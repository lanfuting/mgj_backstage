package com.cxb.springboot.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.springboot.mapper.GoodsimageMapper;
import com.cxb.springboot.mapper.GoodsinfoMapper;
import com.cxb.springboot.mapper.GoodspriceMapper;
import com.cxb.springboot.mapper.GoodssizeMapper;
import com.cxb.springboot.mapper.SupplierMapper;
import com.cxb.springboot.mapper.System_SupplierMapper;
import com.cxb.springboot.pojo.Goodsimage;
import com.cxb.springboot.pojo.Goodsinfo;
import com.cxb.springboot.pojo.GoodsinfoExample;
import com.cxb.springboot.pojo.Goodsprice;
import com.cxb.springboot.pojo.Goodssize;
import com.cxb.springboot.pojo.GoodssizeExample;

@Service
public class SupplierService {

	@Autowired
	GoodspriceMapper goodspriceMapper;
	@Autowired
	GoodsinfoMapper goodsinfoMapper;
	@Autowired
	GoodssizeMapper goodssizeMapper;
	@Autowired
	GoodsimageMapper goodsimageMapper;
	@Autowired
	SupplierMapper supplierMapper;
	@Autowired
	System_SupplierMapper system_SupplierMapper;
	
	
	/**
	 * 根据前端传回来的商品名称进行查询出相应的商品，进行上架和下架操作
	 * @param gdname
	 * @return
	 */
	public List<Goodsinfo> selectSuppGoodsByGdname(String gdname){
		GoodsinfoExample example = new GoodsinfoExample();
		example.createCriteria().andGdnameLike(gdname);
		return goodsinfoMapper.selectByExample(example );
	}
	
	/**
	 * 用户下单后，商家页面可以看到的购买者信息，包括价格、数量、总价收件人信息等
	 * @param gtid 商家的id号
	 * @return
	 */
	public List<Map> selectUserOrderInSupp(Integer gtid){
		return system_SupplierMapper.getUserOrderTosupp(gtid);
	}
	
	/**
	 * 商家在添加页面添加商品信息
	 * @param gdname 商品的名称
	 * @param gimgurl 商品图片的url
	 * @param price 商品的价格
	 * @param gsid 商品的尺寸
	 * @param gtid 商家的id号
	 * @return
	 */
	@Transactional
	public boolean insertNewGoods(String gdname,String gimgurl,Double price,Integer gsid,Integer gtid){
		//添加商品信息
		Goodsinfo insert_gdname = new Goodsinfo();
		insert_gdname.setGdname(gdname);
		insert_gdname.setGtdate(new Date());
		insert_gdname.setGtkeywords(gdname);
		insert_gdname.setStid(gtid);
		goodsinfoMapper.insertSelective(insert_gdname);
		
		//添加商品图片的url
		Goodsimage insert_gimgurl = new Goodsimage();
		insert_gimgurl.setGimgurl(gimgurl);
		insert_gimgurl.setGimgtype(1);
		GoodsinfoExample example = new GoodsinfoExample();
		example.createCriteria().andGdnameEqualTo(gdname);
		List<Goodsinfo> list = goodsinfoMapper.selectByExample(example );
		Goodsinfo goodsinfo = list.get(0);
		insert_gimgurl.setGdid(goodsinfo.getGdid());
		goodsimageMapper.insertSelective(insert_gimgurl );
		
		//添加商品的价格
		Goodsprice insert_price = new Goodsprice();
		insert_price.setPrice(price);
		insert_price.setUtid(1);
		insert_price.setGdid(goodsinfo.getGdid());
		goodspriceMapper.insertSelective(insert_price);
		
		//如果尺寸不存在则添加商品尺寸大小
		Goodssize insert_size = new Goodssize();
		if(gsid>7||gsid<1){
			insert_size.setGsid(gsid);
			insert_size.setGstext("XXXL");
			goodssizeMapper.insertSelective(insert_size);
		}
		return  true;
	} 
	
	
	
}
