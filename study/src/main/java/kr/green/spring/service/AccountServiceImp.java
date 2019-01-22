package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService{
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public AccountVo getAccount(String id, String pw, String email, String gender) {
		return accountDao.getAccount(id);
	}

	@Override
	public boolean signup(AccountVo accountVo) {
		//가입 여부 확인하여 회원정보가 있으면(null이 아니면 ) 작업중지
		 String id = accountVo.getId();
		 AccountVo tmp = accountDao.getAccount(id);
		 if(tmp == null) {
				String encPw = passwordEncoder.encode(accountVo.getPw());
				accountVo.setPw(encPw);
				accountVo.setAuthority("user");
				accountDao.setAccount(accountVo);
				return true;
		 } else
				return false;
	}

@Override
public AccountVo login(String id, String pw) {
	 AccountVo user = accountDao.getAccount(id);
	 if(user != null && passwordEncoder.matches(pw, user.getPw()))
			return user;
	 else
			return null;
}

//  @Override
//  public boolean login(AccountVo accountVo) {
//  	 if(accountDao.getAccount(accountVo.getId()) != null && accountVo.getPw() == accountVo.setPw()) {
//  			return true;
//  	 }
//  	 else
//  			return false;
//  }
//  

}
