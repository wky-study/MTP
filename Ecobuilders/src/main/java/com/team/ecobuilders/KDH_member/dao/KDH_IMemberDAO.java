package com.team.ecobuilders.KDH_member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.KDH_member.dto.KDH_MemberDTO;

// DAO (Data Access Object) 데이터 접근 객체 -> DB에 쿼리문 전송하는 것과 연관이 있는 객체
// mapper인 member.xml 파일과 연결시킨다. -> KDH_IMemberDAO 위에 @Mapper 어노테이션 붙인다
// @Mapper 는 Component 에 해당하지 않음 -> 서버 실행시 자동 객체 생성이 되도록 root-context.xml 에 설정 추가
@Mapper
public interface KDH_IMemberDAO {
	
	// 회원가입 메소드
	// insert, update, delete의 경우 return 타입을 int 로 한다.
	// insert 쿼리문에 들어갈 id, pw, name, phone, email 값이 파라미터로 들어와야 한다.
	// -> MemberDTO 는 id, pw, name, phone, email 에 대한 값을 필드변수에 담을 수 있음
	int insertMember(KDH_MemberDTO member);

	// 로그인 메소드
	// select문의 경우 return 타입을 DTO 객체로 한다.
	KDH_MemberDTO loginMember(KDH_MemberDTO member);
	
	// 회원수정 메소드
	int updateMember(KDH_MemberDTO member);
	
	// id에 대한 회원정보 가져오기
	KDH_MemberDTO getMember(String memId);
	
	// 회원탈퇴 메소드
	int deleteMember(String memId);
	
	// 회원 프로필 사진 수정 메소드 (UPDATE)
	int updateProfile(KDH_MemberDTO member);
	
}