package com.team.ecobuilders.KDH_member.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.ecobuilders.KDH_member.dao.KDH_IMemberDAO;
import com.team.ecobuilders.KDH_member.dto.KDH_MemberDTO;

// 일련의 DB 관련 기능에 대한 메소드를 보유
// 서버 실행시 자동으로 스캔되어 객체 생성 되도록 @Service 를 붙여준다.
@Service
public class KDH_MemberService {

	// DAO의 쿼리문 메소드에 대해 Service에서 예외처리를 해주거나
	// 트랜잭션 같이 일련의 하나의 프로세스로 구현 가능

	// 스캔되어 객체로 생성된 KDH_IMemberDAO 를 가져오기
	@Autowired
	KDH_IMemberDAO dao; // 주소에 생성된 KDH_IMemberDAO 객체를 가져옴

	// 위 작업에 대해 DI (Dependency Inject, 의존성 주입) 이라고 한다.

	// 회원가입에 대한 메소드
	public int insertMember(KDH_MemberDTO member) {

		// KDH_IMemberDAO 의 insertMember 를 실행시켜주기
		int result = dao.insertMember(member);

		return result;
	}

	// 로그인에 대한 메소드
	public KDH_MemberDTO loginMember(KDH_MemberDTO member) {

		KDH_MemberDTO result = dao.loginMember(member);

		return result;
	}

	// 회원수정에 대한 메소드
	public int updateMember(KDH_MemberDTO member) {

		int result = dao.updateMember(member);

		return result;
	}

	// id에 대한 회원 정보 가져오기
	public KDH_MemberDTO getMember(String memId) {

		KDH_MemberDTO result = dao.getMember(memId);

		return result;
	}

	// 회원 탈퇴 메소드
	public int deleteMember(String memId) {

		int result = dao.deleteMember(memId);

		return result;
	}
}
