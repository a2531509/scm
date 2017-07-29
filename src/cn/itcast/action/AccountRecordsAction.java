package cn.itcast.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.service.AccountRecordsService;

@Controller
@RequestMapping(value="/accountRecords")
public class AccountRecordsAction extends BaseAction {
	@Resource
	private AccountRecordsService accountRecordsService;
	
	//用户登陆
	@RequestMapping(value="/selectSupplier")
	@ResponseBody
	public Object selectSupplier(String start,String end){
		System.out.println("start:"+ start+"||end:"+end);
		Map<String, String> paramMap =new HashMap<String, String>();
		paramMap.put("start", start);
		paramMap.put("end", end);

		return accountRecordsService.selectSupplier(paramMap);
	}
	

}

