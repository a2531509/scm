package cn.itcast.action;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.entity.Page;
import cn.itcast.entity.Supplier;
import cn.itcast.service.SupplierService;

@Controller
@RequestMapping(value="/supplier")
public class SupplierAction extends BaseAction {
	@Resource
	private SupplierService supplierService;
	
	@RequestMapping(value="/insert")
	@ResponseBody
	public Object insert(Supplier supplier){
		System.out.println("---action.supplier:"+supplier);
		Integer i = 0;
		try {
			i = supplierService.insert(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	public Object update(Supplier supplier){
		System.out.println("---action.supplier:"+supplier);
		Integer i = 0;
		try {
			i = supplierService.updateByPK(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
/*	@RequestMapping("/supplierlist")
	//@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public String supplierList(){

		return "forward:/WEB-INF/supplier/supplierlist.jsp";
	}*/
	
	
	@RequestMapping(value="/deleteList")
	@ResponseBody
	public Object deleteList(String pks[]){
		Integer i = 0;
		try {
			supplierService.deleteList(pks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	//通过单个关键字分页查询
	@RequestMapping("/selectPage")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object selectPage(Page<Supplier> page){
		
		return supplierService.selectPage(page).getPageMap();
	}
	
	//通过多个关键字分页查询
	@RequestMapping("/selectPageUseDyc")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object selectPageUseDyc(Page<Supplier> page, Supplier supplier){
		page.setParamEntity(supplier);
		
		return supplierService.selectPageUseDyc(page).getPageMap();
	}
	
	@RequestMapping("/doAjax")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object doAjax(Supplier supplier){
		System.out.println("---doAjax.supplier:"+supplier);
		supplier.setSupName("supName1");
		return supplier;
	}
	
	

}
