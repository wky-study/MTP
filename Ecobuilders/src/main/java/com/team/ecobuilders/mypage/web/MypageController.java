package com.team.ecobuilders.mypage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MypageController {

	// ���������� ��û
	@RequestMapping("/mypageView")
	public String mypageView() {

		System.out.println("mypageView ����");
		
		// ���������� ȭ���� �����Ŵ
		return "KDH_member/mypageView";
	}
	
	// ���ǰ����� ��û
	@RequestMapping("/mp_estimateList")
	public String my_estimateList() {

		System.out.println("mp_estimateList ����");
		
		// ���������� ȭ���� �����Ŵ
		return "KDH_member/mp_estimateList";
	}
	

	
}
