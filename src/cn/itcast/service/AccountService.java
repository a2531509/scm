package cn.itcast.service;

import cn.itcast.entity.Account;

public interface AccountService extends BaseService<Account>{
	
	public Account login(Account account);
}
