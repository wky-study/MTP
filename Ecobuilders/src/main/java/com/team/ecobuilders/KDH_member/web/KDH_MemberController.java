/* 회원가입 화면을 요청하는 URL에 대해 응답하는 컨트롤러 생성 */
package com.team.ecobuilders.KDH_member.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.ecobuilders.KDH_member.dto.KDH_MemberDTO;
import com.team.ecobuilders.KDH_member.service.KDH_MemberService;


@Controller // 클래스 상단에 어노테이션추가
public class KDH_MemberController {
	
	// KDH_MemberService 내 메소드를 사용하기 위해 KDH_MemberService를 불러옴 (DI)
	@Autowired
	KDH_MemberService memberService;
	
	/*
	// 회원가입시 비밀번호 암호화를 위해 context-security.xml 에서 생성한 passwordEncoder 가져오기
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	*/
	
	// 주소 뒤에 /registView 로 요청이 오면 실행될 메소드 생성
	@RequestMapping("/registView")
	public String registView() {
		
		System.out.println("registView 실행");
		
		// 회원가입 화면을 응답시킴
		return "KDH_member/KDH_registView";
	}
	
	
	// 주소 뒤에 /registDo 로 요청이 오면 실행될 메소드 생성
	// 요청시 전달되어 오는 Request 객체 내에 데이터가 들어있음
	// 메소드 내에서 Request 객체를 사용할거면 파라미터에 넣어준다.
	// 요청시 생성된 Request 객체가 메소드 실행될때 파라미터에 들어감
	// 회원가입의 경우 POST 방식으로 요청을 보내고, 요청을 받아야 하므로
	// RequestMapping 에 method를 넣어준다.
//	@RequestMapping("/registDo")  // registDo 에 대한 GET, POST 둘 다 받음 
//	@RequestMapping(value = "/registDo", method = RequestMethod.POST)  // POST 방식 요청만 받음
	@PostMapping("/registDo")  // POST 방식 요청만 받음 (위와 같음)
	public String registDo(HttpServletRequest request) {  
		
		// request로부터 getParameter로 값을 꺼내기 전에 인코딩 설정해야 한글 안깨짐
		// web.xml에 인코딩 필터를 적용하면 생략 가능
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		// 회원가입시 입력한 id, pw, name 값을 불러와야 함
		// GET 방식이든, POST 방식이든 같은 방법으로 꺼냄
		// GET 방식은 한글이 깨지지 않지만 POST 방식은 한글이 깨짐
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		System.out.println(request.getParameter("name"));
		
		// 사용자가 입력한 비밀번호
		String pw = request.getParameter("pw");
		
/*		
		// passwordEncoder 를 이용하여 비밀번호 암호화
		String encodePw = passwordEncoder.encode(pw);
*/		
		// 각 파라미터로 꺼낸 값을 하나의 MemberDTO 객체에 담은 후 insertMember에 넣어준다.
		KDH_MemberDTO member = new KDH_MemberDTO();
		member.setMemId(request.getParameter("id"));
		member.setMemPassword(request.getParameter("pw"));  // 암호화된 비밀번호 반영
		member.setMemName(request.getParameter("name"));
		member.setMemPhone(request.getParameter("phone"));
		member.setMemEmail(request.getParameter("email"));
		
		System.out.println(member);
		
		
		// DB에 해당 회원정보를 저장 -> mybatis 사용
		memberService.insertMember(member);
		
		
		// 홈 화면으로 보내기
		// 그냥 home.jsp에 대한 home을 리턴하면
		// HomeController의 home 메소드가 실행되지 않음
		// -> HomeController의 home 메소드가 실행되도록 함 
		// -> ("/") 에 대해 redirect를 시킨다.
		return "redirect:/loginView";  // redirect:/ 에서 redirect:/loginView 로 변경
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
	// 3. 아이디, 비밀번호 값은 MemberDTO 객체 내부 필드변수에 해당
	//    MemberDTO 객체 하나면 모두 담을 수 있음
	//    input 태그의 name에 적힌 값이 MemberDTO의 필드변수명과 일치해야함
	@PostMapping("/loginDo")
	public String loginDo(KDH_MemberDTO member, Model model, HttpServletResponse response, String from
			, HttpSession session, boolean rememberId, RedirectAttributes attr) {  // member 필드변수 memId, memPassword에 값 들어옴
		
		// 1.
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pw"));

		// 2.
//		System.out.println(id);
//		System.out.println(pw);

		// 3. memId와 memPassword 값이 채워져 있음
		System.out.println("로그인 요청");
		System.out.println(member);
		// checkbox 값을 String으로 받으면 on 또는 null 임
		// boolean으로 받으면 true / false 임
		System.out.println(rememberId);  
		
		// DB에 member 전달 후 id가 일치하는 데이터 가져옴 (1개)
		// members 테이블의 회원 데이터의 각 컬럼 값이 
		// MemberDTO 객체의 각 필드변수에 대입되어 채워짐
		KDH_MemberDTO login = memberService.loginMember(member);
		System.out.println(login);  // 로그인 실패시 null 값이 리턴됨
		
		 
		// 로그인 성공 여부 판별
		if(login != null) {
			
			// passwordEncoder 를 이용하여
			// 사용자가 입력한 비밀번호와 DB에 암호화된 비밀번호를 비교
			
/*			
			// 일치하면 true, 틀리면 false 리턴
			boolean isMatch = passwordEncoder.matches(member.getMemPassword(), login.getMemPassword());

			
			if(isMatch == false) {
				attr.addFlashAttribute("failMsg", "아이디 혹은 비밀번호가 올바르지 않습니다.");
				return "redirect:/loginView";
			}
*/			
			
			// 로그인 성공시 세션 객체에 로그인 정보 저장
			// 키값: login, 들어가는 value값: KDH_MemberDTO 객체
			session.setAttribute("login", login);
			
			// 아이디 기억하기가 체크되어 있으면  
			// 아이디 정보를 클라이언트(브라우저)에 쿠키로 만들어서 전송
			if(rememberId) {
				// 아이디 기억하기 체크
				
				// 쿠키 생성
				// 키값: rememberId
				// value값: 로그인한 사람의 아이디
				Cookie cookie = new Cookie("rememberId", login.getMemId());
				
				// 생성된 쿠키를 응답(response) 객체에 담아준다.
				response.addCookie(cookie);
			}else {
				// 아이디 기억하기 체크안함
				// rememberId 키값으로 만들어서 보낸 쿠키를 제거해주기
				
				// 쿠키 생성 (값을 뭘 넣어도 상관없으므로 empty)
				Cookie cookie = new Cookie("rememberId", "");
				
				// 쿠키의 유통기한 설정 (클라이언트에 도달하자마자 유통기한이 끝나도록)
				cookie.setMaxAge(0);
				
				response.addCookie(cookie);
			}
			
		}else {
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
		return "redirect:" + from;
	}

	// 로그아웃시 실행
	@RequestMapping("/logoutDo")
	public String logoutDo(HttpSession session, HttpServletRequest request) {
		
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
	

}
