package com.team.ecobuilders.KDH_member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.KDH_member.dto.KDH_MemberDTO;

// DAO (Data Access Object) ������ ���� ��ü -> DB�� ������ �����ϴ� �Ͱ� ������ �ִ� ��ü
// mapper�� member.xml ���ϰ� �����Ų��. -> KDH_IMemberDAO ���� @Mapper ������̼� ���δ�
// @Mapper �� Component �� �ش����� ���� -> ���� ����� �ڵ� ��ü ������ �ǵ��� root-context.xml �� ���� �߰�
@Mapper
public interface KDH_IMemberDAO {
	
	// ȸ������ �޼ҵ�
	// insert, update, delete�� ��� return Ÿ���� int �� �Ѵ�.
	int insertMember(KDH_MemberDTO member);

	// �α��� �޼ҵ�
	// select���� ��� return Ÿ���� DTO ��ü�� �Ѵ�.
	KDH_MemberDTO loginMember(KDH_MemberDTO member);
	
	// ȸ������ �޼ҵ�
	int updateMember(KDH_MemberDTO member);
	
	// id�� ���� ȸ������ ��������
	KDH_MemberDTO getMember(String memId);
	
	// ȸ��Ż�� �޼ҵ�
	int deleteMember(String memId);
	
	// ȸ�� ����Ʈ
	List<KDH_MemberDTO> getMemList();
	
}