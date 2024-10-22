package com.team.ecobuilders.ENT_member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.ecobuilders.ENT_member.dao.ENT_IMemberDAO;
import com.team.ecobuilders.ENT_member.dto.ENT_MemberDTO;

// 일련의 DB 관련 기능에 대한 메소드를 보유
// 서버 실행시 자동으로 스캔되어 객체 생성 되도록 @Service 를 붙여준다.
@Service
public class ENT_MemberService {
	
	// DAO의 쿼리문 메소드에 대해 Service에서 예외처리를 해주거나
	// 트랜잭션 같이 일련의 하나의 프로세스로 구현 가능
	
	// 스캔되어 객체로 생성된 ENT_IMemberDAO 를 가져오기
	@Autowired
	ENT_IMemberDAO dao;  // 주소에 생성된 ENT_IMemberDAO 객체를 가져옴
	
	// 위 작업에 대해 DI (Dependency Inject, 의존성 주입) 이라고 한다.
	
	
	// 회원가입에 대한 메소드
	public int ent_insertMember(ENT_MemberDTO ent_member) {
		
		// ENT_IMemberDAO 의 insertMember 를 실행시켜주기
		int result = dao.ent_insertMember(ent_member);
		
		return result;
	}
	
	
	// 기업로그인에 대한 메소드
	public ENT_MemberDTO ent_loginMember(ENT_MemberDTO ent_member) {
		
		ENT_MemberDTO result = dao.ent_loginMember(ent_member);
		
		return result;
	}
	
	
	// 기업회원수정에 대한 메소드
	public int ent_updateMember(ENT_MemberDTO ent_member) {
		
		int result = dao.ent_updateMember(ent_member);
		
		return result;
	}
	
	
	// id에 대한 회원 정보 가져오기
	public ENT_MemberDTO ent_getMember(String entBr) {
		
		ENT_MemberDTO result = dao.ent_getMember(entBr);
		
		return result;
	}
	
	
	// 회원 탈퇴 메소드
	public int ent_deleteMember(String entBr) {
		
		int result = dao.ent_deleteMember(entBr);
		
		return result;
	}	
	
}
