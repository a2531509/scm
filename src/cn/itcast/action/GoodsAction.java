package cn.itcast.action;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.entity.Goods;
import cn.itcast.entity.Page;
import cn.itcast.service.GoodsService;

@Controller
@RequestMapping(value="/goods")
public class GoodsAction extends BaseAction {
	@Resource
	private GoodsService goodsService;
	
	
	//通过多个关键字分页查询
	@RequestMapping("/selectPageUseDyc")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object selectPageUseDyc(Page<Goods> page, Goods goods){
		page.setParamEntity(goods);
		
		return goodsService.selectPageUseDyc(page).getPageMap();
	}
	
}
