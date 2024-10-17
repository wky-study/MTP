package com.team.ecobuilders.KDH_member.dto;


//members ���̺��� ȸ�� �����͸� �����ϴµ� ���Ǵ� DTO ��ü
//�÷�: mem_id, mem_password, mem_name, mem_birthdate, mem_phone, mem_address, mem_email �� 
//�ʵ庯��: memId, memPassword, memName, memBirthdate, memPhone, memAddress, memEmail �� �������־�� �ڵ����� ��ȯ��
public class KDH_MemberDTO {
	// �ʵ庯�� ���ǳ��� �� ĸ��ȭ ���� (�ʼ�!!)
	// 1. ��� �ʵ庯���� private ���� ������ ����
	
	// �Ϲ�ȸ������
	private String memId;
	private String memPassword;
	private String memName;
	private String membirthdate;
	private String memPhone;
	private String memAddress;
	private String memEmail;

	// ���ȸ������
	
	

	// 2. �⺻�����ڿ� Ǯ������ �߰�
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
