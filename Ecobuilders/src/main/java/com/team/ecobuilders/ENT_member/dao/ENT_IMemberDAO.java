package com.team.ecobuilders.ENT_member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.ENT_member.dto.ENT_MemberDTO;

@Mapper
public interface ENT_IMemberDAO {
	
	// ���ȸ������ �޼ҵ�
	int ent_insertMember(ENT_MemberDTO ent_member);

	// ����α��� �޼ҵ�
	// select���� ��� return Ÿ���� DTO ��ü�� �Ѵ�.
	ENT_MemberDTO ent_loginMember(ENT_MemberDTO ent_member);
	
	// ���ȸ������ �޼ҵ�
	int ent_updateMember(ENT_MemberDTO ent_member);
	
	// ����ڹ�ȣ�� ���� ȸ������ ��������
	ENT_MemberDTO ent_getMember(String entBr);
	
	// ȸ��Ż�� �޼ҵ�
	int ent_deleteMember(String entBr);	
	
}