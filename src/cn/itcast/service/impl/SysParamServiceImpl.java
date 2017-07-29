package cn.itcast.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;

import cn.itcast.entity.SysParam;
import cn.itcast.service.SysParamService;

@Service("sysParamService")
public class SysParamServiceImpl extends BaseServiceImpl<SysParam> implements SysParamService {

	//加载所有的系统参数
	@Override
	public Map<String, Object> sysParamLoad() {
		
		//用来存储系统参数
		 Map<String, Object> sysParamMap= new HashMap<String, Object>();
		 //用来存储字段类型的map
		 Map<String, Object> fieldMap= null;
		 List<SysParam> sysParamList = sysParamMapper.selectSysParamList(null);
		 for (SysParam sysParam : sysParamList) {
			 //类型为1，表示需要重新执行sql,查询其它表的数据
			 if("1".equals(sysParam.getSysParamType())){
				 //获取需要执行的sql
				 String sql = sysParam.getSysParamValue();
				 System.out.println("sql:"+sql);
				 //执行sql,查询其它表的数据
				 List<SysParam> selectOtherTableList = sysParamMapper.selectOtherTable(sql);
				 //新建字段map，用来存入其它表的数据
				 fieldMap = new HashMap<String, Object>();
				 //把其它数据遍历并存放于 字段的map
				for (SysParam sysParam2 : selectOtherTableList) {
					fieldMap.put(sysParam2.getSysParamValue(), sysParam2.getSysParamText());
				}
				//把字段的map存入到系统参数的map
				 sysParamMap.put(sysParam.getSysParamField(), fieldMap);
				 
			 }else{
				 
				/* 如果为null，表示该字段没有存在系统参数的Map,需要新建到 字段map，先存放该字段的值对字段的map，
				 * 并把字段的map存放在系统参数map里
				*/ 
				 if(sysParamMap.get(sysParam.getSysParamField())==null){
					 fieldMap = new HashMap<String, Object>();
					 //先存放该字段的值到字段的map
					 fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());
					 //再把字段的map存放到系统的参数map
					 sysParamMap.put(sysParam.getSysParamField(), fieldMap);
				 }else{
					 fieldMap = (Map<String, Object>) sysParamMap.get(sysParam.getSysParamField());
					 fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());
				 }			 
				 
			 }
			 
			
		}
		 
		
		return sysParamMap;
	}

}
