package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.SysParam;

public interface SysParamMapper extends BaseMapper<SysParam> {
	
	//查询所有系统参数表的记录,包括了类型为1的记录
	public List<SysParam> selectSysParamList(SysParam sysParam);
	
	//查询其他表的数据
	public List<SysParam> selectOtherTable(String sql);
}