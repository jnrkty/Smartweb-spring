package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceimp implements AccountService{
	/* Autowired는 객체생성을 자동으로 해준다 */

	@Autowired
	private AccountDao accountDao;
	@Override
	public AccountVo getAccount(String id) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(id);
	}
	@Override
	public boolean signup(AccountVo accountVo) {
		/* 아이디 중복 확인
		 * 1. accountDao를 이용하여 id정보가 주어지면 해당 id와 일치하는 객체정보를 가져온다
		 * 2. 가져온 객체정보가 null이면
		 *  	accountDao.insertAccount(accountVo)를 실행
		 *  	아니면 아무것도 처리하지 않음
		 */
		String id = accountVo.getId();
		AccountVo tmp = accountDao.getAccount(id);
		if(tmp == null) {
			accountDao.insertAccount(accountVo);
			return true;
		}
		else
			return false;
		
	}

}
