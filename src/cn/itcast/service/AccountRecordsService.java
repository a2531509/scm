package cn.itcast.service;

import java.util.List;
import java.util.Map;

import cn.itcast.entity.AccountRecords;

public interface AccountRecordsService extends BaseService<AccountRecords>{
	List<Map<String,Object>> selectSupplier(Map<String,String> paramMap);
}
