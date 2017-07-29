package cn.itcast.dao;

import java.util.List;
import java.util.Map;

import cn.itcast.entity.AccountRecords;

public interface AccountRecordsMapper extends BaseMapper<AccountRecords> {
	
	List<Map<String,Object>> selectSupplier(Map<String,String> paramMap);
}