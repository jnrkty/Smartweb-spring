package kr.green.spring.service;

import kr.green.spring.vo.AccountVo;

public interface AccountService { //코드가 두개라 인터페이스를 왜썼냐 싶지만 코드 길게쓸경우에 헷갈리니까 인터페이스를 따로 만들어서 보는거임
	public AccountVo getAccount(String id, String pw, String email, String gender);

	public boolean signup(AccountVo accountVo);

	public AccountVo login(String id, String pw);

}
	