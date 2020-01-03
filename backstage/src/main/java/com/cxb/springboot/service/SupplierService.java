package com.cxb.springboot.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.springboot.mapper.GoodsimageMapper;
import com.cxb.springboot.mapper.GoodsinfoMapper;
import com.cxb.springboot.mapper.GoodspriceMapper;
import com.cxb.springboot.mapper.GoodssizeMapper;
import com.cxb.springboot.mapper.SupplierMapper;
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
