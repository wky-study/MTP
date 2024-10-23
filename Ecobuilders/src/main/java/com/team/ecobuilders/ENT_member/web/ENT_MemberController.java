package com.team.ecobuilders.ENT_member.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.ecobuilders.ENT_member.dto.ENT_MemberDTO;
import com.team.ecobuilders.ENT_member.service.ENT_MemberService;

@Controller // 클래스 상단에 어노테이션추가
public class ENT_MemberController {

	@Autowired
	ENT_MemberService memberService;

	@RequestMapping("/ENT_registView")
	public String ENT_registView() {

		System.out.println("ENT_registView 실행");

		// 기업회원가입 화면을 응답시킴
		return "KDH_member/ENT_registView";

	}

	@PostMapping("/ENT_registDo") // POST 방식 요청만 받음 (위와 같음)
	public String ENT_registDo(HttpServletRequest request) {

		System.out.println(request.getParameter("br"));
		System.out.println(request.getParameter("pw"));

		// 사용자가 입력한 비밀번호
		String pw = request.getParameter("pw");

		ENT_MemberDTO ent_member = new ENT_MemberDTO();
		ent_member.setEntBr(request.getParameter("br"));
		ent_member.setEntPassword(request.getParameter("pw")); // 암호화된 비밀번호 반영
		ent_member.setEntName(request.getParameter("name"));
		ent_member.setEntCeo(request.getParameter("ceo"));
		ent_member.setEntPhone(request.getParameter("phone"));
		ent_member.setEntAddress(request.getParameter("address"));
		ent_member.setEntEmail(request.getParameter("email"));
		
        try {
            // 문자열을 Date로 변환
        	Timestamp ent_date = new Timestamp(new Date().getTime());
        	System.out.println(ent_date);
            ent_member.setEntDate(ent_date);
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 처리 로직 추가
        }

		System.out.println(ent_member);

		// DB에 해당 회원정보를 저장 -> mybatis 사용
		memberService.ent_insertMember(ent_member);

		return "redirect:/ENT_loginView";
	}
	
	@RequestMapping("/ENT_loginView")
	public String ENT_loginView(HttpServletRequest request, Model model) {

		// 어느 페이지에서 /ENT_loginView 요청을 했는지 확인
		String from = request.getHeader("Referer");
		System.out.println(from + " 으로부터 요청이 옴");

		model.addAttribute("keyFrom", from);

		return "KDH_member/ENT_loginView";
	}

	@PostMapping("/ENT_loginDo")
	public String ENT_loginDo(ENT_MemberDTO ent_member, Model model, HttpServletResponse response, String from,
			HttpSession session, boolean rememberBr, RedirectAttributes attr) { 

		System.out.println("로그인 요청");
		System.out.println(ent_member);
		// checkbox 값을 String으로 받으면 on 또는 null 임
		// boolean으로 받으면 true / false 임
		System.out.println(rememberBr);

		ENT_MemberDTO login = memberService.ent_loginMember(ent_member);
		System.out.println(login); // 로그인 실패시 null 값이 리턴됨

		// 로그인 성공 여부 판별
		if (login != null) {

			// 로그인 성공시 세션 객체에 로그인 정보 저장
			// 키값: login, 들어가는 value값: ENT_MemberDTO 객체
			session.setAttribute("login", login);

			// 아이디 기억하기가 체크되어 있으면
			// 아이디 정보를 클라이언트(브라우저)에 쿠키로 만들어서 전송
			if (rememberBr) {
				// 아이디 기억하기 체크

				// 쿠키 생성
				// 키값: rememberBr
				// value값: 로그인한 사람의 아이디
				Cookie cookie = new Cookie("rememberBr", login.getEntBr());

				// 생성된 쿠키를 응답(response) 객체에 담아준다.
				response.addCookie(cookie);
			} else {
				// 아이디 기억하기 체크안함
				// rememberBr 키값으로 만들어서 보낸 쿠키를 제거해주기

				// 쿠키 생성 (값을 뭘 넣어도 상관없으므로 empty)
				Cookie cookie = new Cookie("rememberBr", "");

				// 쿠키의 유통기한 설정 (클라이언트에 도달하자마자 유통기한이 끝나도록)
				cookie.setMaxAge(0);

				response.addCookie(cookie);
			}

		} else {
			// 로그인 실패
			// 로그인 실패 문구와 함께 로그인 페이지가 열림
			// model에 failMsg 키값으로 "아이디 혹은 비밀번호가 올바르지 않습니다." 값을 저장
			// ENT_loginView.jsp 에서 failMsg 키값을 통해 값을 꺼내 쓸 수 있다.
//			model.addAttribute("failMsg", "아이디 혹은 비밀번호가 올바르지 않습니다.");

			// RedirectAttributes의 addFlashAttribute에 데이터를 담은 후 redirect를 하면
			// 받는 쪽에서 해당 데이터 사용 가능
			attr.addFlashAttribute("failMsg", "아이디 혹은 비밀번호가 올바르지 않습니다.");

			// redirect:/ENT_loginView 를 하면 model의 내용이 사라짐
			// forward:/ENT_loginView 를 하면 현재 메소드의 model, request 값 등이 전달됨
			// redirect 할 때 데이터 보내는 경우 RedirectAttributes 객체 이용
			return "redirect:/ENT_loginView";
		}

		// 로그인 후 홈화면 이동 -> 홈화면("/") 으로 리다이렉트
		// 로그인 후 이전 화면으로 이동 -> from 으로 리다이렉트
		return "redirect:" + "/";
	}

	// 로그아웃시 실행
	@RequestMapping("/ENT_logoutDo")
	public String ENT_logoutDo(HttpSession session, HttpServletRequest request) {

		// /ENT_logoutDo 요청을 한 사람의 세션을 제거
		session.invalidate();

		// 어느 페이지에서 /ENT_logoutDo 를 요청했는지 확인
		String from = request.getHeader("Referer");

		// 로그아웃을 요청했던 페이지로 리다이렉트
		return "redirect:" + from;
	}

	// 회원수정 페이지 요청
	@RequestMapping("/ENT_memEditView")
	public String ENT_memEditView() {
		return "KDH_member/ENT_memEditView";
	}

	// 회원수정 기능 요청
	@PostMapping("/ENT_memEditDo")
	public String ENT_memEditDo(ENT_MemberDTO ent_member, HttpSession session) {

		System.out.println(ent_member);

		// DB 에 update문 실행
		memberService.ent_updateMember(ent_member);

		// 세션에 담긴 로그인 정보를 변경된 정보로 교체하기
		// 1. DB에서 현재 로그인중인 id에 대한 member 데이터 가져와서 세션에 저장
		ENT_MemberDTO login = memberService.ent_getMember(ent_member.getEntBr());
		session.setAttribute("login", login);

		return "redirect:/ENT_memEditView";

	}
/*
	// 기업회원삭제 기능 요청
	@PostMapping("/ENT_memDelDo")
	public String ENT_memDelDo(HttpSession session) {

		// 세션에 담긴 로그인 정보를 꺼낸다.
		ENT_MemberDTO login = (ENT_MemberDTO) session.getAttribute("login");

		// DB에 DELETE문 전송
		memberService.ent_deleteMember(login.getEntBr());

		// 로그인 정보를 담고 있는 세션 객체 제거(= 로그아웃)
		session.invalidate();

		return "redirect:/";
	}
*/
}
