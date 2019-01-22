package kr.green.spring.vo;

import java.sql.Date;

public class AccountVo {
	private String id;
	private String pw;
	private String email;
	private String gender;
	private String authority;
	private Date registered_date;
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
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Date getRegistered_date() {
		return registered_date;
	}
	public void setRegistered_date(Date registered_date) {
		this.registered_date = registered_date;
	}
	@Override
	public String toString() {
		return "AccountVo [id=" + id + ", pw=" + pw + ", email=" + email + ", gender=" + gender + ", authority=" + authority
				+ ", registered_date=" + registered_date + "]";
	}
public String setPw() {
	 // TODO Auto-generated method stub
	 return null;
}

}
