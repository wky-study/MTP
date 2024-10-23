package com.team.ecobuilders.mypage.web;

import org.springframework.web.bind.annotation.RequestMapping;

public class MypageController {

	// 마이페이지 요청
	@RequestMapping("/mypageView")
	public String mypageView() {

		System.out.println("mypageView 실행");
		
		// 마이페이지 화면을 응답시킴
		return "KDH_member/mypageView";
	}
}
