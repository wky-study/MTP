/* ȸ������ ȭ���� ��û�ϴ� URL�� ���� �����ϴ� ��Ʈ�ѷ� ���� */
package com.team.ecobuilders.review.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


@Controller // Ŭ���� ��ܿ� ������̼��߰�
public class KDH_MemberController {
	
	//registView() �޼ҵ尡 ����Ǳ� ���� ��û���� ServletPath �ۼ�
	@RequestMapping("/registView")
	public String regisView() {
		// http://localhost:9090/ecobuilders/registView�� ��û�� ���� �������� JSP ������ ���
		return "KDH_member/KDH_registView";
	}
	
	@PostMapping("/registDo")
	public String registDo(HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		System.out.println("id = " + id);
		System.out.println("password = " + password);
		System.out.println("name = " + name);
		
		return "redirect:/";
		
	}
	

}
