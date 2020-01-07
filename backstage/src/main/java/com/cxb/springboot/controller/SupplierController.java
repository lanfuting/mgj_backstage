package com.cxb.springboot.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cxb.springboot.pojo.Supplier;
import com.cxb.springboot.service.SupplierService;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	
	
	
	
	/**
	 * 把当前供应商的添加的商品在页面上显示
	 * @param gtid
	 * @return
	 */
	@RequestMapping(value = "selectsuppliergoods")
	public Object selectSupplierGoods(HttpSession session){
		Supplier supplier = (Supplier) session.getAttribute("supplier");
		return supplierService.selectSuppGoods(supplier.getGtid());
	}
	
	/**
	 * 显示出当前的这件商品信息
	 * 需要传回的值是商品的名称
	 * @param gdname
	 * @return
	 */
	@RequestMapping(value = "changesuppgoods")
	public Object changeSuppGoods(Integer statuc,String gdname){
		StringBuffer buffer = new StringBuffer("%");
		buffer.append(gdname).append("%");
		System.out.println(statuc+"--"+buffer.toString());
		
		return supplierService.changeSuppGoodsStatuc(statuc,buffer.toString());
	}
	
	
	/**
	 * 这是用户下订单后，显示在商家页面上的发货单
	 * @param session 在session 中的当前供应商信息
	 * @return
	 */
	@RequestMapping(value = "selectusersorderbysuppId")
	public Object selectUsersOrderBySuppId(HttpSession session){
		Supplier supplier = (Supplier) session.getAttribute("supplier");
		return supplierService.selectUserOrderInSupp(supplier.getGtid());
	}
	

	// 跳转到上传文件的页面
	/*@RequestMapping(value = "gouploadimg", method = RequestMethod.GET)
	public String goUploadImg() {
		// 跳转到 templates 目录下的 uploadimg.html
		return "uploadimg";
	}*/

	/**
	 * 这是供应商添加商品的页面信息
	 * @param file 添加的是图片，保存到后台对应的目录中
	 * @param request 用于添加图片的辅助功能
	 * @param gdname 传过来的商品名称
	 * @param price 商品的价格
	 * @param gsid 商品的尺寸
	 * @param session 获得session 中的当前供应商信息
	 * @return
	 */
	@RequestMapping(value = "testUploadimg", method = RequestMethod.POST)
	public Object uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request,String gdname, Double price, Integer gsid,HttpSession session) {
		String contentType = file.getContentType();
		String fileName = file.getOriginalFilename();
		String filePath = "D:/system_backstage/imgs/tp";
		if (file.isEmpty()) {
			return "请查看信息是否填写完全！";
		}
		try {
			uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
			// TODO: handle exception
		}
		/*//把文件名字使用uuid重新排序
		String str = UUID.randomUUID().toString();
		StringBuffer buff = new StringBuffer(fileName);
		String uuidStr = str.replace("-", "");
		buff.append(str);
		String gimgurl = buff.toString();*/
		//得到在session中的供应商信息
		Supplier supplier = (Supplier) session.getAttribute("supplier");
		//调用service方法
		supplierService.insertNewGoods(gdname, fileName , price, gsid, supplier.getGtid());
		// 返回json
		return "添加成功请点击返回!";
	}

	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath + "/" + fileName);
		out.write(file);
		out.flush();
		out.close();
	}



}
