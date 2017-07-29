package cn.itcast.service;

import java.util.Map;

import cn.itcast.entity.SysParam;

public interface SysParamService extends BaseService<SysParam>{
	
	//加载系统参数
	public Map<String, Object> sysParamLoad();
	
}
