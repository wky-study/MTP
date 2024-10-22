package com.team.ecobuilders.KDH_member.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.ecobuilders.KDH_member.dao.KDH_IMemberDAO;
import com.team.ecobuilders.KDH_member.dto.KDH_MemberDTO;

// �Ϸ��� DB ���� ��ɿ� ���� �޼ҵ带 ����
// ���� ����� �ڵ����� ��ĵ�Ǿ� ��ü ���� �ǵ��� @Service �� �ٿ��ش�.
@Service
public class KDH_MemberService {

	// DAO�� ������ �޼ҵ忡 ���� Service���� ����ó���� ���ְų�
	// Ʈ����� ���� �Ϸ��� �ϳ��� ���μ����� ���� ����

	// ��ĵ�Ǿ� ��ü�� ������ KDH_IMemberDAO �� ��������
	@Autowired
	KDH_IMemberDAO dao; // �ּҿ� ������ KDH_IMemberDAO ��ü�� ������

	// �� �۾��� ���� DI (Dependency Inject, ������ ����) �̶�� �Ѵ�.

	// ȸ�����Կ� ���� �޼ҵ�
	public int insertMember(KDH_MemberDTO member) {

		// KDH_IMemberDAO �� insertMember �� ��������ֱ�
		int result = dao.insertMember(member);

		return result;
	}

	// �α��ο� ���� �޼ҵ�
	public KDH_MemberDTO loginMember(KDH_MemberDTO member) {

		KDH_MemberDTO result = dao.loginMember(member);

		return result;
	}

	// ȸ�������� ���� �޼ҵ�
	public int updateMember(KDH_MemberDTO member) {

		int result = dao.updateMember(member);

		return result;
	}

	// id�� ���� ȸ�� ���� ��������
	public KDH_MemberDTO getMember(String memId) {

		KDH_MemberDTO result = dao.getMember(memId);

		return result;
	}

	// ȸ�� Ż�� �޼ҵ�
	public int deleteMember(String memId) {

		int result = dao.deleteMember(memId);

		return result;
	}
}
