package com.team.ecobuilders.ENT_member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.ENT_member.dto.ENT_MemberDTO;

@Mapper
public interface ENT_IMemberDAO {
	
	// 기업회원가입 메소드
	int ent_insertMember(ENT_MemberDTO ent_member);

	// 기업로그인 메소드
	// select문의 경우 return 타입을 DTO 객체로 한다.
	ENT_MemberDTO ent_loginMember(ENT_MemberDTO ent_member);
	
	// 기업회원수정 메소드
	int ent_updateMember(ENT_MemberDTO ent_member);
	
	// 사업자번호에 대한 회원정보 가져오기
	ENT_MemberDTO ent_getMember(String entBr);
	
	// 회원탈퇴 메소드
	int ent_deleteMember(String entBr);	
	
}