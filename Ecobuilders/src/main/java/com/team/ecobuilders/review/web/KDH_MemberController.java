/* 회원가입 화면을 요청하는 URL에 대해 응답하는 컨트롤러 생성 */
package com.team.ecobuilders.review.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


@Controller // 클래스 상단에 어노테이션추가
public class KDH_MemberController {
	
	//registView() 메소드가 실행되기 위해 요청받을 ServletPath 작성
	@RequestMapping("/registView")
	public String regisView() {
		// http://localhost:9090/ecobuilders/registView로 요청이 오면 응답해줄 JSP 파일의 경로
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
