package com.cxb.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.springboot.service.ScrollimgsService;

@Configuration // 1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling // 2.开启定时任务
@RestController
public class Scrollimgs_Cron {
	@Autowired
	ScrollimgsService scrollimgsService;
	//初始化定义一个页数
	private Integer page = 0;
	

	// 3.添加定时任务
	@Scheduled(cron = "0 */2 * * * ?")
	// 或直接指定时间间隔，例如：2小时
	@RequestMapping(value="/changescrollimgs")
	private Object changeScrollimgs() {
		Integer rows = 3;
		//进行自增长
		page++;
		//得到滚动图片的总页数
		int count = scrollimgsService.getScrollimgsPage(rows);
		//条件判断，不满足返回原值
		if(page>count){
			page=1;
		}
		return scrollimgsService.getScrollimgsByPage(rows, page);
	}

	/*@EventListener
    public void event(Object event){
        
    }*/

	
}
