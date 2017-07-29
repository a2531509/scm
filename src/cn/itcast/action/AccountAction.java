package cn.itcast.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.entity.Account;
import cn.itcast.entity.Supplier;
import cn.itcast.service.AccountService;

@Controller
@RequestMapping(value="/account")
public class AccountAction extends BaseAction {
	@Resource
	private AccountService accountService;
	
	//用户登陆
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request,HttpSession session,Account account){
		System.out.println("---action.account:"+account);
		try {
			Account acc = accountService.login(account);
			if(acc!=null){
				session.setAttribute("account", acc);			
			}else{
				request.setAttribute("errMsg", "用户名或密码有错！");
				return "forward:/login.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:/WEB-INF/jsp/main.jsp";
	}
	
	@RequestMapping("/doAjax")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object doAjax(Supplier supplier){
		System.out.println("---doAjax.supplier:"+supplier);
		supplier.setSupName("supName1");
		return supplier;
	}

}

