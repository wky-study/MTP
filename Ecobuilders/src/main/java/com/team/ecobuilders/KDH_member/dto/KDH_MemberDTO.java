package com.team.ecobuilders.KDH_member.dto;


//members 테이블의 회원 데이터를 매핑하는데 사용되는 DTO 객체
//컬럼: mem_id, mem_password, mem_name, mem_phone, mem_email 을 
//필드변수: memId, memPassword, memName, memPhone, memEmail 로 설정해주어야 자동으로 변환됨
public class KDH_MemberDTO {
	// 필드변수 정의내린 후 캡슐화 적용 (필수!!)
	// 1. 모든 필드변수에 private 접근 제어자 적용
	private String memId;
	private String memPassword;
	private String memName;
	private String memPhone;
	private String memEmail;
	private String memProfileImg;

	// 2. 기본생성자와 풀생성자 추가
	// 	  Alt + Shift + S
	public KDH_MemberDTO() {
	}

	public KDH_MemberDTO(String memId, String memPassword, String memName, String memPhone, String memEmail,
			String memProfileImg) {
		super();
		this.memId = memId;
		this.memPassword = memPassword;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memEmail = memEmail;
		this.memProfileImg = memProfileImg;
	}

	public String toString() {
		return "MemberDTO [memId=" + memId + ", memPassword=" + memPassword + ", memName=" + memName + ", memPhone="
				+ memPhone + ", memEmail=" + memEmail + ", memProfileImg=" + memProfileImg + "]";
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPassword() {
		return memPassword;
	}

	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemProfileImg() {
		return memProfileImg;
	}

	public void setMemProfileImg(String memProfileImg) {
		this.memProfileImg = memProfileImg;
	}

}
