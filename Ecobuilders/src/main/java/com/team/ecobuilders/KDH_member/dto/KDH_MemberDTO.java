package com.team.ecobuilders.KDH_member.dto;


//members 테이블의 회원 데이터를 매핑하는데 사용되는 DTO 객체
//컬럼: mem_id, mem_password, mem_name, mem_birthdate, mem_phone, mem_address, mem_email 을 
//필드변수: memId, memPassword, memName, memBirthdate, memPhone, memAddress, memEmail 로 설정해주어야 자동으로 변환됨
public class KDH_MemberDTO {
	// 필드변수 정의내린 후 캡슐화 적용 (필수!!)
	// 1. 모든 필드변수에 private 접근 제어자 적용
	
	// 일반회원정보
	private String memId;
	private String memPassword;
	private String memName;
	private String membirthdate;
	private String memPhone;
	private String memAddress;
	private String memEmail;

	// 기업회원정보
	
	

	// 2. 기본생성자와 풀생성자 추가
	// 	  Alt + Shift + S
	public KDH_MemberDTO() {
	}

	public KDH_MemberDTO(String memId, String memPassword, String memName, String memBirthdate, String memPhone, String memAddress,
			String memEmail) {
		super();
		this.memId = memId;
		this.memPassword = memPassword;
		this.memName = memName;
		this.memName = memBirthdate;
		this.memPhone = memPhone;
		this.memAddress = memAddress;
		this.memEmail = memEmail;
		
	}

	public String toString() {
		return "KDH_MemberDTO [memId=" + memId + ", memPassword=" + memPassword + ", memName=" + memName + ", memPhone="
				+ memPhone + ", memAddress=" + memAddress + ", memEmail=" + memEmail + "]";
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

	public String getMemAddress() {
		return memAddress;
	}

	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	

}
