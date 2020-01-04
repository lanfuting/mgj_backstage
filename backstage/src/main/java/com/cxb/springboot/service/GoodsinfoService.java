package com.cxb.springboot.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.springboot.exception.Logname_UsedException;
import com.cxb.springboot.exception.Password_ErroerException;
import com.cxb.springboot.exception.User_StatusBanException;
import com.cxb.springboot.exception.Username_isNullException;
import com.cxb.springboot.mapper.CartMapper;
import com.cxb.springboot.mapper.GoodspriceMapper;
import com.cxb.springboot.mapper.GoodssizeMapper;
import com.cxb.springboot.mapper.OrderinfoMapper;
import com.cxb.springboot.mapper.OrderlistMapper;
import com.cxb.springboot.mapper.System_CartMapper;
import com.cxb.springboot.mapper.System_GoodsinfoMapper;
import com.cxb.springboot.mapper.System_OrderInfoMapper;
import com.cxb.springboot.mapper.System_SupplierMapper;
import com.cxb.springboot.mapper.UserMapper;
import com.cxb.springboot.pojo.Cart;
import com.cxb.springboot.pojo.CartExample;
import com.cxb.springboot.pojo.Goodsprice;
import com.cxb.springboot.pojo.GoodspriceExample;
import com.cxb.springboot.pojo.Goodssize;
import com.cxb.springboot.pojo.GoodssizeExample;
import com.cxb.springboot.pojo.Orderinfo;
import com.cxb.springboot.pojo.Orderlist;
import com.cxb.springboot.pojo.OrderlistExample;
import com.cxb.springboot.pojo.User;
import com.cxb.springboot.pojo.UserExample;



@Service
public class GoodsinfoService {

	@Autowired
	System_GoodsinfoMapper system_GoodsinfoMapper;
	@Autowired
	GoodssizeMapper goodssizeMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	CartMapper cartMapper;
	@Autowired
	System_CartMapper system_CartMapper;
	@Autowired
	OrderinfoMapper orderinfoMapper;
	@Autowired
	GoodspriceMapper goodspriceMapper;
	@Autowired
	OrderlistMapper orderlistMapper;
	@Autowired
	System_OrderInfoMapper system_OrderInfoMapper;
	
	
	
	
	/**
	 * 使用支付宝付款之后，把付款的信息删除掉
	 * @param ofid
	 */
	@Transactional
	public void changeOrderinfo(String ofid){
		Orderinfo orderinfo = orderinfoMapper.selectByPrimaryKey(ofid);
		orderinfo.setOfstate(2);
		orderinfoMapper.updateByPrimaryKey(orderinfo);
		OrderlistExample example = new OrderlistExample();
		example.createCriteria().andOfidEqualTo(ofid);
		List<Orderlist> list = orderlistMapper.selectByExample(example );
		for (Orderlist orlt : list) {
			Integer gdid = orlt.getGdid();
			Integer gsid = orlt.getGsid();
			Integer userid = orderinfo.getUserid();
			CartExample ex_cart = new CartExample();
			ex_cart.createCriteria().andGdidEqualTo(gdid).andGsidEqualTo(gsid).andUseridEqualTo(userid);
			cartMapper.deleteByExample(ex_cart );
		}
	}
	
	/**
	 * 根据用户的id 显示订单信息和金额
	 * @param userid
	 * @return
	 */
	public List<Map> getOrderinfoByUserid(Integer userid){
		return system_OrderInfoMapper.getOrderinfoByUserid(userid);
	}
	
	/**
	 * 获取指定编号的订单信息及其金额
	 * @param ofid
	 * @return
	 */
	public Map getOrderInfoByOfid(String ofid){
		return system_OrderInfoMapper.getOrderinfoByOfid(ofid);
	}
	
	/**
	 * 给订单和详细类目添加信息
	 * @param orderinfo 订单信息
	 * @param ctids 商品的ctid
	 * @return
	 */
	@Transactional
	public String getOrderinfos(Orderinfo orderinfo,Integer[] ctids){
		//订单日期
		orderinfo.setOfdate(new Date());
		//订单的状态
		orderinfo.setOfstate(1);
		//订单编号，不能重复
		StringBuffer buffer = new StringBuffer("of_");
		buffer.append(UUID.randomUUID().toString());
		orderinfo.setOfid(buffer.toString());
		orderinfoMapper.insert(orderinfo);
		
		CartExample example = new CartExample();
		List<Integer> values = Arrays.asList(ctids);
		example.createCriteria().andCtidIn(values);
		List<Cart> list = cartMapper.selectByExample(example);
		for(int i =0;i<list.size();i++){
			Cart cart = list.get(i);
			Orderlist orderlist = new Orderlist();
			StringBuffer buffer2 = new StringBuffer("OL_");
			buffer2.append(buffer.toString()).append("_").append((i+1));
			orderlist.setOlid(buffer2.toString());
			orderlist.setOfid(orderinfo.getOfid());
			orderlist.setGsid(cart.getGsid());
			orderlist.setGdcount(cart.getGdcount());
			orderlist.setGdid(cart.getGdid());
			GoodspriceExample example2 = new GoodspriceExample();
			example2.createCriteria().andGdidEqualTo(cart.getGdid()).andUtidEqualTo(1);
			List<Goodsprice> price = goodspriceMapper.selectByExample(example2 );
			orderlist.setPrice(price.get(0).getPrice());
			orderlistMapper.insert(orderlist);
		}
		return orderinfo.getOfid();		
	}
	
	/**
	 * 进入订单页面，编辑订单业务，根据商品的id和接收到的商品数量，来修改数据
	 * @param ctid
	 * @param count
	 * @return
	 */
	@Transactional
	public boolean updateCartCount(Integer ctid,Integer count){
		Cart cart = cartMapper.selectByPrimaryKey(ctid);
		if(cart!=null){
			if(count==0){
				return cartMapper.deleteByPrimaryKey(ctid)==1;
			}else{
				cart.setGdcount(count);
				return cartMapper.updateByPrimaryKey(cart)==1;
			}
			
		}
		return false;
	}
	
	/*
	 *根据商品的id来删除商品
	 */
	public boolean deleteCartById(Integer ctid){
		return (cartMapper.deleteByPrimaryKey(ctid)==1);
	}
	
	/**
	 * 当前用户的订单情况，根据客户的id活的用户的信息，在页面上进行显示
	 * 包含订单编号，商品的图片url，商品价格，商品大小，商品名字，商品数量
	 * @param user
	 * @return
	 */
	@Transactional
	public List<Map> selectUserCart(User user,Integer rows,Integer page){
		RowBounds bounds = new RowBounds((page-1)*rows, rows);
		return system_CartMapper.getUserCart(user.getUserid(),bounds );
	}
	/**
	 * 用户购物车页面根据每页行数 获取 总页数
	 * @param rows
	 * @return
	 */
	public Integer getPage(Integer rows,User user){
		Integer userid = user.getUserid();
		Integer count = system_CartMapper.getPageCart(userid);
		return (count%rows==0)?(count/rows):(count/rows)+1;
	}
	
	/**
	 * 添加购物车方法，先判断在同一用户下，是否存在商品类型及尺寸都一样的，存在则更新，不存在则添加
	 * @param cart
	 */
	@Transactional
	public void putUserCart(Cart cart){
		CartExample example = new CartExample();
		example.createCriteria().andUseridEqualTo(cart.getUserid()).andGdidEqualTo(cart.getGdid()).andGsidEqualTo(cart.getGsid());
		List<Cart> list = cartMapper.selectByExample(example );
		if(list!=null&&list.size()==1){
			Cart cart2 = list.get(0);
			cart2.setGdcount(cart2.getGdcount()+cart.getGdcount());
			cartMapper.updateByPrimaryKey(cart2);
		}else {
			cartMapper.insert(cart);
		}
	}
	
	/**
	 * 用于登录页面，获取账号密码等，通过账号获取集合，在通过各类异常进行判断
	 * @param logname 账号
	 * @param password 密码
	 * @throws Password_ErroerException 密码错误异常
	 * @throws Username_isNullException 用户名不存在异常
	 * @throws User_StatusBanException 用户禁用异常
	 */
	@Transactional
	public User selectCurrentUser(String logname,String password) throws Password_ErroerException, Username_isNullException, User_StatusBanException{
		UserExample example = new UserExample();
		example.createCriteria().andLognameEqualTo(logname);
		List<User> list = userMapper.selectByExample(example );
		if(list==null||list.size()==0){
			throw new Username_isNullException();
		}
		User user = list.get(0);
		
		if(user.getStatus()!=1){
			throw new User_StatusBanException();
		}
		
		String salt = user.getSalt();
		Md5Hash md5 = new Md5Hash(password, salt);
		if(!user.getPassword().equals(md5.toString())){
			throw new Password_ErroerException();
		}
		return user;
	}
	
	/**
	 * 通过页面接受信息，对密码进行加密
	 * @param logname
	 * @param password
	 * @throws Logname_UsedException 自定义异常
	 */
	@Transactional
	public void getinfoInsertUser(String logname,String password) throws Logname_UsedException{
		UserExample example = new UserExample();
		example.createCriteria().andLognameEqualTo(logname);
		int countByExample = userMapper.countByExample(example );
		if(countByExample==0){
			String salt = UUID.randomUUID().toString();
			Md5Hash md = new Md5Hash(password, salt);
			User user = new User();
			user.setLogname(logname);
			user.setPassword(md.toString());
			user.setUtid(1);
			user.setSalt(salt);
			user.setStatus(1);
			userMapper.insert(user);
		}else {
			throw new Logname_UsedException();
		}
	}
	
	/**
	 * 获取衣服尺寸大小
	 * @param gdid
	 * @return
	 */
	public List<Goodssize> getGoodssize(){
		GoodssizeExample example = new GoodssizeExample();
		return goodssizeMapper.selectByExample(example );
	}
	
	/**
	 * 根据当前商品的id获取单独信息，包含id，商品名称，图片url，价格等
	 * @param gdid
	 * @return
	 */
	public Map selectOnlyGoodsinfo(Integer gdid){
		return system_GoodsinfoMapper.selectOnlyGoodsinfo(gdid);
	}
	
	/**
	 * 根据下拉框搜索信息返回，进行like搜索相似信息进行显示
	 * @param keyword
	 * @return
	 */
	public List<Map> selectByKeyword(String keyword){
		return system_GoodsinfoMapper.selectByKeyword(keyword);
	}
	
	/**
	 * 根据滚动获取页面页数，从而获得内容
	 */
	public List<Map> selectGoodsinfo(Integer rows,Integer page){
		RowBounds bounds = new RowBounds((page-1)*rows, rows);
		return system_GoodsinfoMapper.selectGoodsinfoByPage(bounds );
	}
}
