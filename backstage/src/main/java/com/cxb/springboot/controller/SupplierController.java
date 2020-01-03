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

	// 跳转到上传文件的页面
	/*@RequestMapping(value = "gouploadimg", method = RequestMethod.GET)
	public String goUploadImg() {
		// 跳转到 templates 目录下的 uploadimg.html
		return "uploadimg";
	}*/

	// 处理文件上传
	@RequestMapping(value = "testUploadimg", method = RequestMethod.POST)
	public Object uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request,String gdname, Double price, Integer gsid,HttpSession session) {
		String contentType = file.getContentType();
		String fileName = file.getOriginalFilename();
		String filePath = "D:/system_backstage/imgs/tp";
		if (file.isEmpty()) {
			return "文件为空！";
		}
		try {
			uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//把文件名字使用uuid重新排序
		String str = UUID.randomUUID().toString();
		StringBuffer buff = new StringBuffer(fileName);
		String uuidStr = str.replace("-", "");
		buff.append(str);
		String gimgurl = buff.toString();
		//得到在session中的供应商信息
		Supplier supplier = (Supplier) session.getAttribute("supplier");
		//调用service方法
		supplierService.insertNewGoods(gdname, gimgurl , price, gsid, supplier.getGtid());
		
		
		// 返回json
		return true;
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


	/*@RequestMapping(value = "getsuppliergoods")
	public Object getSupplierGoods(String gdname, String gimgid, Double price, Integer gsid) {

		return null;
	}*/

}
