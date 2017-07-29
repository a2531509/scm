package cn.itcast.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysParamServlet extends HttpServlet {

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		
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
		sysParamMap.put("goodsColor", goodsColorMap);
		
		getServletContext().setAttribute("sysParam", sysParamMap);
		System.out.println("--------------------系统参数加载完成-------------------------");*/
	}

}
