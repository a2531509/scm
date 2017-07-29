package cn.itcast.service.impl;



import org.springframework.stereotype.Service;

import cn.itcast.entity.Account;
import cn.itcast.service.AccountService;

@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
	

	@Override
	public Account login(Account account) {
		
		return accountMapper.login(account);
	}

	

}

