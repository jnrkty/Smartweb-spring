package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.AccountVo;

public interface AccountDao {
	public AccountVo getAccount(String id);

	public void setAccount(@Param("accountVo")AccountVo accountVo);

}
