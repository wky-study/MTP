package com.team.ecobuilders.mypage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MypageController {

	// 마이페이지 요청
	@RequestMapping("/mypageView")
	public String mypageView() {

		System.out.println("mypageView 실행");
		
		// 마이페이지 화면을 응답시킴
		return "KDH_member/mypageView";
	}
	
	// 나의견적서 요청
	@RequestMapping("/mp_estimateList")
	public String my_estimateList() {

		System.out.println("mp_estimateList 실행");
		
		// 마이페이지 화면을 응답시킴
		return "KDH_member/mp_estimateList";
	}
	

	
}
