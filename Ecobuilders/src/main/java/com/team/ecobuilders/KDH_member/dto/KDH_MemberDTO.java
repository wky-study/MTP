package com.team.ecobuilders.KDH_member.dto;
public class KDH_MemberDTO {
  
	private String memId;
	private String memPassword;
	private String memName;
	private String membirthdate;
	private String memPhone;
	private String memAddress;
	private String memEmail;
  
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
