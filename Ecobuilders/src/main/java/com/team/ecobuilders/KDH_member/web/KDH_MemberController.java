package com.team.ecobuilders.KDH_member.web;

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

import com.team.ecobuilders.KDH_member.dto.KDH_MemberDTO;
import com.team.ecobuilders.KDH_member.service.KDH_MemberService;

@Controller // 클래스 상단에 어노테이션추가
public class KDH_MemberController {

	@Autowired
	KDH_MemberService memberService;

	@RequestMapping("/registView")
	public String registView() {

		System.out.println("registView 실행");
		

		// 회원가입 화면을 응답시킴
		return "KDH_member/KDH_registView";

	}   

	@PostMapping("/registDo") // POST 방식 요청만 받음 (위와 같음)
	public String registDo(HttpServletRequest request) {


		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));

		// 사용자가 입력한 비밀번호
		String pw = request.getParameter("pw");

		KDH_MemberDTO member = new KDH_MemberDTO();
		member.setMemId(request.getParameter("id"));
		member.setMemPassword(request.getParameter("pw")); // 암호화된 비밀번호 반영
        member.setMemName(request.getParameter("name"));
        member.setMemPhone(request.getParameter("phone"));
        member.setMemAddress(request.getParameter("address"));
        member.setMemEmail(request.getParameter("email"));
        member.setMemAdmin("1");

        try {
            // 문자열을 Date로 변환
        	Timestamp date = new Timestamp(new Date().getTime());
        	System.out.println(date);
            member.setMemDate(date);
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 처리 로직 추가
        }

        // DB에 해당 회원정보를 저장 -> mybatis 사용
        memberService.insertMember(member);

        return "redirect:/loginView"; // redirect:/ 에서 redirect:/loginView 로 변경
    }

	@RequestMapping("/loginView")
	public String loginView(HttpServletRequest request, Model model) {

		// 어느 페이지에서 /loginView 요청을 했는지 확인
		String from = request.getHeader("Referer");
		System.out.println(from + " 으로부터 요청이 옴");

		model.addAttribute("keyFrom", from);

		return "KDH_member/KDH_loginView";
	}

	// 로그인 요청시 사용자가 입력한 id와 password를 가져와서
	// DB에 조회하기
	// loginView에서 전달되어오는 값 꺼내기
	// 1. HttpServletRequest 객체로부터 getParameter로 id, pw값 꺼내기
	// 2. loginDo 파라미터에 name의 id, pw 를 작성
	// 3. 아이디, 비밀번호 값은 KDH_MemberDTO 객체 내부 필드변수에 해당
	// KDH_MemberDTO 객체 하나면 모두 담을 수 있음
	// input 태그의 name에 적힌 값이 KDH_MemberDTO의 필드변수명과 일치해야함
	@PostMapping("/loginDo")
	public String loginDo(KDH_MemberDTO member, Model model, HttpServletResponse response, String from,
			HttpSession session, boolean rememberId, RedirectAttributes attr) { // member 필드변수 memId, memPassword에 값 들어옴

		// memId와 memPassword 값이 채워져 있음
		System.out.println("로그인 요청");
		System.out.println(member);
		// checkbox 값을 String으로 받으면 on 또는 null 임
		// boolean으로 받으면 true / false 임
		System.out.println(rememberId);

		// DB에 member 전달 후 id가 일치하는 데이터 가져옴 (1개)
		// members 테이블의 회원 데이터의 각 컬럼 값이
		// KDH_MemberDTO 객체의 각 필드변수에 대입되어 채워짐
		KDH_MemberDTO login = memberService.loginMember(member);
		System.out.println(login); // 로그인 실패시 null 값이 리턴됨

		// 로그인 성공 여부 판별
		if (login != null) {

			// 로그인 성공시 세션 객체에 로그인 정보 저장
			// 키값: login, 들어가는 value값: KDH_MemberDTO 객체
			session.setAttribute("login", login);

			// 아이디 기억하기가 체크되어 있으면
			// 아이디 정보를 클라이언트(브라우저)에 쿠키로 만들어서 전송
			if (rememberId) {
				// 아이디 기억하기 체크

				// 쿠키 생성
				// 키값: rememberId
				// value값: 로그인한 사람의 아이디
				Cookie cookie = new Cookie("rememberId", login.getMemId());

				// 생성된 쿠키를 응답(response) 객체에 담아준다.
				response.addCookie(cookie);
			} else {
				// 아이디 기억하기 체크안함
				// rememberId 키값으로 만들어서 보낸 쿠키를 제거해주기

				// 쿠키 생성 (값을 뭘 넣어도 상관없으므로 empty)
				Cookie cookie = new Cookie("rememberId", "");

				// 쿠키의 유통기한 설정 (클라이언트에 도달하자마자 유통기한이 끝나도록)
				cookie.setMaxAge(0);

				response.addCookie(cookie);
			}

		} else {
			// 로그인 실패
			// 로그인 실패 문구와 함께 로그인 페이지가 열림
			// model에 failMsg 키값으로 "아이디 혹은 비밀번호가 올바르지 않습니다." 값을 저장
			// loginView.jsp 에서 failMsg 키값을 통해 값을 꺼내 쓸 수 있다.
//			model.addAttribute("failMsg", "아이디 혹은 비밀번호가 올바르지 않습니다.");

			// RedirectAttributes의 addFlashAttribute에 데이터를 담은 후 redirect를 하면
			// 받는 쪽에서 해당 데이터 사용 가능
			attr.addFlashAttribute("failMsg", "아이디 혹은 비밀번호가 올바르지 않습니다.");

			// redirect:/loginView 를 하면 model의 내용이 사라짐
			// forward:/loginView 를 하면 현재 메소드의 model, request 값 등이 전달됨
			// redirect 할 때 데이터 보내는 경우 RedirectAttributes 객체 이용
			return "redirect:/loginView";
		}

		// 로그인 후 홈화면 이동 -> 홈화면("/") 으로 리다이렉트
		// 로그인 후 이전 화면으로 이동 -> from 으로 리다이렉트
		return "redirect:" + "/";
	}

	// 로그아웃시 실행
	@RequestMapping("/logoutDo")
	public String logoutDo(HttpSession session, HttpServletRequest request) {
		System.out.println("/logoutDo");
		// /logoutDo 요청을 한 사람의 세션을 제거
		session.invalidate();
		
		// 어느 페이지에서 /logoutDo 를 요청했는지 확인
		String from = request.getHeader("Referer");
		
		// 로그아웃을 요청했던 페이지로 리다이렉트
		return "redirect:" + from;
		
		
	}
	

	// 회원수정 페이지 요청
	@RequestMapping("/memEditView")
	public String memEditView() {
		return "KDH_member/KDH_memEditView";
	}

	// 회원수정 기능 요청
	@PostMapping("/memEditDo")
	public String memEditDo(KDH_MemberDTO member, HttpSession session) {

		// memId, memName, memPhone, memEmail 채워져있음
		// memPassword 는 채워져있거나 비어있음
		// -> memPassword 가 채워져있으면 변경, 안채워져있으면 기존 비밀번호 유지
		System.out.println(member);

		// DB 에 update문 실행
		memberService.updateMember(member);

		// 세션에 담긴 로그인 정보를 변경된 정보로 교체하기
		// 1. DB에서 현재 로그인중인 id에 대한 member 데이터 가져와서 세션에 저장
		KDH_MemberDTO login = memberService.getMember(member.getMemId());
		session.setAttribute("login", login);

		return "redirect:/memEditView";

	}

	// 회원삭제 기능 요청
	@PostMapping("/memDelDo")
	public String memDelDo(HttpSession session) {

		// 세션에 담긴 로그인 정보를 꺼낸다.
		KDH_MemberDTO login = (KDH_MemberDTO) session.getAttribute("login");

		// DB에 DELETE문 전송
		memberService.deleteMember(login.getMemId());

		// 로그인 정보를 담고 있는 세션 객체 제거(= 로그아웃)
		session.invalidate();

		return "redirect:/";
	}
	



}
