package kr.green.spring.dao;

import kr.green.spring.vo.AccountVo;

public interface AccountDao {
	public AccountVo getAccount(String id);
	
	public void insertAccount(AccountVo accountVo);

}
