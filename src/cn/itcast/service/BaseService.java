package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.Page;

public interface BaseService<T> {
	
	//添加一条记录
		public  int insert(T entity);
		//根据主键修改记录
		public int updateByPK(T entity);
		//删除一条记录
		public int deleteByPK(T entity);
		//根据主键列表批量删除多条记录
		public int deleteList(String pks[]) throws Exception;
		//查询多条记录
		public List<T> select(T entity);
		
		//通过关键字分页查询,返回列表数据
		public Page<T> selectPage(Page<T> page);
		
		//通过多条件分页查询,返回列表数据
		public Page<T> selectPageUseDyc(Page<T> page);
}
