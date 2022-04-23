package com.care.root.member.dto;

public class MemberDTO {
	private String id;
	private String pw;
	private String addr;
	private java.sql.Date limitTime;
	private String sessionId;

	//alt+shift+s > getter.setter 추가
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public java.sql.Date getLimitTime() {
		return limitTime;
	}
	public void setLimitTime(java.sql.Date limitTime) {
		this.limitTime = limitTime;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
}
