package cn.itcast.dao;

import cn.itcast.entity.Page;
import java.util.List;

public interface BaseMapper<T> {
	//添加一条记录
	public  int insert(T entity);
	//根据主键修改记录
	public int updateByPK(T entity);
	//删除一条记录
	public int deleteByPK(T entity);
	//根据主键列表批量删除多条记录
	public int deleteList(String pks[]);
	//查询多条记录
	public List<T> select(T entity);
	
	//通过关键字分页查询,返回列表数据
	public List<T> selectPageList(Page<T> page);
		
	//通过关键字分页查询,返回总记录数
	public Integer selectPageCount(Page<T> page);
	
	//通过多条件分页查询,返回列表数据
	public List<T> selectPageListUseDyc(Page<T> page);
			
	//通过多条件分页查询,返回总记录数
	public Integer selectPageCountUseDyc(Page<T> page);
}