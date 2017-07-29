package cn.itcast.action;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.entity.Page;
import cn.itcast.entity.Supplier;
import cn.itcast.entity.SysParam;
import cn.itcast.service.SupplierService;
import cn.itcast.service.SysParamService;

@Controller
@RequestMapping(value="/sysParam")
public class SysParamAction extends BaseAction {
	@Resource
	private SysParamService sysParamService;
	
	@PostConstruct
	private void sysParamInit() {
		/*Map<String, Object> sysParamMap = new HashMap<String, Object>();
		Map<String, String> supTypeMap = new HashMap<String, String>();
		supTypeMap.put("1", "一级供应商");
		supTypeMap.put("2", "二级供应商");
		supTypeMap.put("3", "三级供应商");
		sysParamMap.put("supType", supTypeMap);
		
		Map<String, String> goodsColorMap = new HashMap<String, String>();
		goodsColorMap.put("1", "绿色");
		goodsColorMap.put("2", "红色");
		goodsColorMap.put("1", "蓝色");
		sysParamMap.put("goodsColor", goodsColorMap);*/
		
		application.setAttribute("sysParam", sysParamService.sysParamLoad());

	}
	
	
	
	@RequestMapping("/doAjax")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object doAjax(Supplier supplier){
		System.out.println("---doAjax.supplier:"+supplier);
		supplier.setSupName("supName1");
		return supplier;
	}
	
	

}
