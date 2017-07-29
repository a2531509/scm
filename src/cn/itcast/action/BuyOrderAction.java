package cn.itcast.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.entity.BuyOrder;
import cn.itcast.entity.BuyOrderDetail;
import cn.itcast.entity.Page;
import cn.itcast.entity.Supplier;
import cn.itcast.service.BuyOrderService;
import cn.itcast.service.SupplierService;

@Controller
@RequestMapping(value="/buyOrder")
public class BuyOrderAction extends BaseAction {
	@Resource
	private BuyOrderService buyOrderService;
	
	@RequestMapping(value="/insert")
	@ResponseBody
	public Object insert(BuyOrder buyOrder,String rows){
		System.out.println("---action.buyOrder:"+buyOrder);
		System.out.println("-------rows:"+rows);
		Integer i = 0;
		BuyOrderDetail [] buyOrderDetails=null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			buyOrderDetails = objectMapper.readValue(rows,BuyOrderDetail[].class);
			buyOrder.setBuyOrderDetails(Arrays.asList(buyOrderDetails));
			i = buyOrderService.insertBuyOrder(buyOrder);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return i;
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	

}
