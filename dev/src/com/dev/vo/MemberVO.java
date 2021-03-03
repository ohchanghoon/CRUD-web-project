// 회원에 대한 정보들을 저장할 목적
// private로 설정했기때문에 값을 추출할때는 getter메소드, 값을 수정할때는 setter 메소드를 사용한다.

package com.dev.vo;

public class MemberVO {

	private String id;
	private String passwd;
	private String name;
	private String mail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
