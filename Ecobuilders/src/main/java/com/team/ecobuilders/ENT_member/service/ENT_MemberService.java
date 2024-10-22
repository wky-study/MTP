package com.team.ecobuilders.ENT_member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.ecobuilders.ENT_member.dao.ENT_IMemberDAO;
import com.team.ecobuilders.ENT_member.dto.ENT_MemberDTO;

// �Ϸ��� DB ���� ��ɿ� ���� �޼ҵ带 ����
// ���� ����� �ڵ����� ��ĵ�Ǿ� ��ü ���� �ǵ��� @Service �� �ٿ��ش�.
@Service
public class ENT_MemberService {
	
	// DAO�� ������ �޼ҵ忡 ���� Service���� ����ó���� ���ְų�
	// Ʈ����� ���� �Ϸ��� �ϳ��� ���μ����� ���� ����
	
	// ��ĵ�Ǿ� ��ü�� ������ ENT_IMemberDAO �� ��������
	@Autowired
	ENT_IMemberDAO dao;  // �ּҿ� ������ ENT_IMemberDAO ��ü�� ������
	
	// �� �۾��� ���� DI (Dependency Inject, ������ ����) �̶�� �Ѵ�.
	
	
	// ȸ�����Կ� ���� �޼ҵ�
	public int ent_insertMember(ENT_MemberDTO ent_member) {
		
		// ENT_IMemberDAO �� insertMember �� ��������ֱ�
		int result = dao.ent_insertMember(ent_member);
		
		return result;
	}
	
	
	// ����α��ο� ���� �޼ҵ�
	public ENT_MemberDTO ent_loginMember(ENT_MemberDTO ent_member) {
		
		ENT_MemberDTO result = dao.ent_loginMember(ent_member);
		
		return result;
	}
	
	
	// ���ȸ�������� ���� �޼ҵ�
	public int ent_updateMember(ENT_MemberDTO ent_member) {
		
		int result = dao.ent_updateMember(ent_member);
		
		return result;
	}
	
	
	// id�� ���� ȸ�� ���� ��������
	public ENT_MemberDTO ent_getMember(String entBr) {
		
		ENT_MemberDTO result = dao.ent_getMember(entBr);
		
		return result;
	}
	
	
	// ȸ�� Ż�� �޼ҵ�
	public int ent_deleteMember(String entBr) {
		
		int result = dao.ent_deleteMember(entBr);
		
		return result;
	}	
	
}
