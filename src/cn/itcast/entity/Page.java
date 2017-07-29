package cn.itcast.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> implements Serializable {
	
	//查询的开始记录数
	private Integer start;
	//页大小
	private Integer rows;
	//查询关键字(单条件)
	private String keyWord;
	//页面列表数据
	private List<T> list;
	//总记录数
	private Integer totalRecords;
	//当前页
	private Integer page;
	//查询条件,支持多个
	private T paramEntity;
	//返回界面数据的封装(total和rows数据)
	private Map<String,Object> pageMap = new HashMap<String,Object>();
	
	
	public Map<String, Object> getPageMap() {
		return pageMap;
	}
/*	public void setPageMap(Map<String, Object> pageMap) {
		this.pageMap = pageMap;
	}*/
	public T getParamEntity() {
		return paramEntity;
	}
	public void setParamEntity(T paramEntity) {
		this.paramEntity = paramEntity;
	}
	public Integer getStart() {
		start = (page-1)*rows;
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
/*	public List<T> getList() {
		return list;
	}*/
	public void setList(List<T> list) {
		pageMap.put("rows", list);
		this.list = list;
	}
/*	public Integer getTotalRecords() {
		return totalRecords;
	}*/
	public void setTotalRecords(Integer totalRecords) {
		pageMap.put("total",totalRecords);
		this.totalRecords = totalRecords;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "Page [start=" + start + ", rows=" + rows + ", keyWord=" + keyWord + ", list=" + list + ", totalRecords="
				+ totalRecords + ", page=" + page + ", paramEntity=" + paramEntity + "]";
	}

	
	
}
