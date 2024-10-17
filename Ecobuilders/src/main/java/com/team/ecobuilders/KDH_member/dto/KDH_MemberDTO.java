package com.team.ecobuilders.KDH_member.dto;


//members ���̺��� ȸ�� �����͸� �����ϴµ� ���Ǵ� DTO ��ü
//�÷�: mem_id, mem_password, mem_name, mem_phone, mem_email �� 
//�ʵ庯��: memId, memPassword, memName, memPhone, memEmail �� �������־�� �ڵ����� ��ȯ��
public class KDH_MemberDTO {
	// �ʵ庯�� ���ǳ��� �� ĸ��ȭ ���� (�ʼ�!!)
	// 1. ��� �ʵ庯���� private ���� ������ ����
	private String memId;
	private String memPassword;
	private String memName;
	private String memPhone;
	private String memEmail;
	private String memProfileImg;

	// 2. �⺻�����ڿ� Ǯ������ �߰�
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
