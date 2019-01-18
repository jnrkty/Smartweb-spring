package kr.green.spring.vo;

import java.sql.Date;

public class AccountVo {
	//硫ㅻ쾭蹂��닔�쓽 �씠由꾩� �뀒�씠釉� �냽�꽦�쓽 �씠由꾧낵 �씪移� �떆耳쒖＜�뒗 寃껋씠 醫뗫떎
	//�떒 �븘�닔�뒗 �븘�땲吏�留� �씪移섑븯吏� �븡�쑝硫� mapper�뿉�꽌 異붽� �옉�뾽�쓣 �빐�빞�븳�떎
	private String id;
	private String pw;
	private String email;
	private String gender;
	private Date registered_date;
	private String authority;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getRegistered_date() {
		return registered_date;
	}
	public void setRegistered_date(Date registered_date) {
		this.registered_date = registered_date;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String toString() {
		return "AccountVo [id=" + id + ", pw=" + pw + ", email=" + email + ", gender=" + gender + ", registered_date="
				+ registered_date + ", authority=" + authority + "]";
	}

}
