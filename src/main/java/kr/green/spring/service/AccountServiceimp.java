package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceimp implements AccountService{
	/* Autowired�뒗 媛앹껜�깮�꽦�쓣 �옄�룞�쑝濡� �빐以��떎 */

	@Autowired
	private AccountDao accountDao;
	@Override
	public AccountVo getAccount(String id) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(id);
	}
	@Override
	public boolean signup(AccountVo accountVo) {
		/* �븘�씠�뵒 以묐났 �솗�씤
		 * 1. accountDao瑜� �씠�슜�븯�뿬 id�젙蹂닿� 二쇱뼱吏�硫� �빐�떦 id�� �씪移섑븯�뒗 媛앹껜�젙蹂대�� 媛��졇�삩�떎
		 * 2. 媛��졇�삩 媛앹껜�젙蹂닿� null�씠硫�
		 *  	accountDao.insertAccount(accountVo)瑜� �떎�뻾
		 *  	�븘�땲硫� �븘臾닿쾬�룄 泥섎━�븯吏� �븡�쓬
		 */
		String id = accountVo.getId();
		AccountVo tmp = accountDao.getAccount(id);
		if(tmp == null) {
			accountVo.setAuthority("user");
			accountDao.insertAccount(accountVo);
			return true;
		}
		else
			return false;
		
	}

}
