package com.team.ecobuilders.mypage.web;

import org.springframework.web.bind.annotation.RequestMapping;

public class MypageController {

	// ���������� ��û
	@RequestMapping("/mypageView")
	public String mypageView() {

		System.out.println("mypageView ����");
		
		// ���������� ȭ���� �����Ŵ
		return "KDH_member/mypageView";
	}
}
