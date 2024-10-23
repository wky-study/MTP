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

@Controller // Ŭ���� ��ܿ� ������̼��߰�
public class ENT_MemberController {

	@Autowired
	ENT_MemberService memberService;

	@RequestMapping("/ENT_registView")
	public String ENT_registView() {

		System.out.println("ENT_registView ����");

		// ���ȸ������ ȭ���� �����Ŵ
		return "KDH_member/ENT_registView";

	}

	@PostMapping("/ENT_registDo") // POST ��� ��û�� ���� (���� ����)
	public String ENT_registDo(HttpServletRequest request) {

		System.out.println(request.getParameter("br"));
		System.out.println(request.getParameter("pw"));

		// ����ڰ� �Է��� ��й�ȣ
		String pw = request.getParameter("pw");

		ENT_MemberDTO ent_member = new ENT_MemberDTO();
		ent_member.setEntBr(request.getParameter("br"));
		ent_member.setEntPassword(request.getParameter("pw")); // ��ȣȭ�� ��й�ȣ �ݿ�
		ent_member.setEntName(request.getParameter("name"));
		ent_member.setEntCeo(request.getParameter("ceo"));
		ent_member.setEntPhone(request.getParameter("phone"));
		ent_member.setEntAddress(request.getParameter("address"));
		ent_member.setEntEmail(request.getParameter("email"));
		
        try {
            // ���ڿ��� Date�� ��ȯ
        	Timestamp ent_date = new Timestamp(new Date().getTime());
        	System.out.println(ent_date);
            ent_member.setEntDate(ent_date);
        } catch (Exception e) {
            e.printStackTrace();
            // ���� ó�� ���� �߰�
        }

		System.out.println(ent_member);

		// DB�� �ش� ȸ�������� ���� -> mybatis ���
		memberService.ent_insertMember(ent_member);

		return "redirect:/ENT_loginView";
	}
	
	@RequestMapping("/ENT_loginView")
	public String ENT_loginView(HttpServletRequest request, Model model) {

		// ��� ���������� /ENT_loginView ��û�� �ߴ��� Ȯ��
		String from = request.getHeader("Referer");
		System.out.println(from + " ���κ��� ��û�� ��");

		model.addAttribute("keyFrom", from);

		return "KDH_member/ENT_loginView";
	}

	@PostMapping("/ENT_loginDo")
	public String ENT_loginDo(ENT_MemberDTO ent_member, Model model, HttpServletResponse response, String from,
			HttpSession session, boolean rememberBr, RedirectAttributes attr) { 

		System.out.println("�α��� ��û");
		System.out.println(ent_member);
		// checkbox ���� String���� ������ on �Ǵ� null ��
		// boolean���� ������ true / false ��
		System.out.println(rememberBr);

		ENT_MemberDTO login = memberService.ent_loginMember(ent_member);
		System.out.println(login); // �α��� ���н� null ���� ���ϵ�

		// �α��� ���� ���� �Ǻ�
		if (login != null) {

			// �α��� ������ ���� ��ü�� �α��� ���� ����
			// Ű��: login, ���� value��: ENT_MemberDTO ��ü
			session.setAttribute("login", login);

			// ���̵� ����ϱⰡ üũ�Ǿ� ������
			// ���̵� ������ Ŭ���̾�Ʈ(������)�� ��Ű�� ���� ����
			if (rememberBr) {
				// ���̵� ����ϱ� üũ

				// ��Ű ����
				// Ű��: rememberBr
				// value��: �α����� ����� ���̵�
				Cookie cookie = new Cookie("rememberBr", login.getEntBr());

				// ������ ��Ű�� ����(response) ��ü�� ����ش�.
				response.addCookie(cookie);
			} else {
				// ���̵� ����ϱ� üũ����
				// rememberBr Ű������ ���� ���� ��Ű�� �������ֱ�

				// ��Ű ���� (���� �� �־ ��������Ƿ� empty)
				Cookie cookie = new Cookie("rememberBr", "");

				// ��Ű�� ������� ���� (Ŭ���̾�Ʈ�� �������ڸ��� ��������� ��������)
				cookie.setMaxAge(0);

				response.addCookie(cookie);
			}

		} else {
			// �α��� ����
			// �α��� ���� ������ �Բ� �α��� �������� ����
			// model�� failMsg Ű������ "���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�." ���� ����
			// ENT_loginView.jsp ���� failMsg Ű���� ���� ���� ���� �� �� �ִ�.
//			model.addAttribute("failMsg", "���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");

			// RedirectAttributes�� addFlashAttribute�� �����͸� ���� �� redirect�� �ϸ�
			// �޴� �ʿ��� �ش� ������ ��� ����
			attr.addFlashAttribute("failMsg", "���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");

			// redirect:/ENT_loginView �� �ϸ� model�� ������ �����
			// forward:/ENT_loginView �� �ϸ� ���� �޼ҵ��� model, request �� ���� ���޵�
			// redirect �� �� ������ ������ ��� RedirectAttributes ��ü �̿�
			return "redirect:/ENT_loginView";
		}

		// �α��� �� Ȩȭ�� �̵� -> Ȩȭ��("/") ���� �����̷�Ʈ
		// �α��� �� ���� ȭ������ �̵� -> from ���� �����̷�Ʈ
		return "redirect:" + "/";
	}

	// �α׾ƿ��� ����
	@RequestMapping("/ENT_logoutDo")
	public String ENT_logoutDo(HttpSession session, HttpServletRequest request) {

		// /ENT_logoutDo ��û�� �� ����� ������ ����
		session.invalidate();

		// ��� ���������� /ENT_logoutDo �� ��û�ߴ��� Ȯ��
		String from = request.getHeader("Referer");

		// �α׾ƿ��� ��û�ߴ� �������� �����̷�Ʈ
		return "redirect:" + from;
	}

	// ȸ������ ������ ��û
	@RequestMapping("/ENT_memEditView")
	public String ENT_memEditView() {
		return "KDH_member/ENT_memEditView";
	}

	// ȸ������ ��� ��û
	@PostMapping("/ENT_memEditDo")
	public String ENT_memEditDo(ENT_MemberDTO ent_member, HttpSession session) {

		System.out.println(ent_member);

		// DB �� update�� ����
		memberService.ent_updateMember(ent_member);

		// ���ǿ� ��� �α��� ������ ����� ������ ��ü�ϱ�
		// 1. DB���� ���� �α������� id�� ���� member ������ �����ͼ� ���ǿ� ����
		ENT_MemberDTO login = memberService.ent_getMember(ent_member.getEntBr());
		session.setAttribute("login", login);

		return "redirect:/ENT_memEditView";

	}
/*
	// ���ȸ������ ��� ��û
	@PostMapping("/ENT_memDelDo")
	public String ENT_memDelDo(HttpSession session) {

		// ���ǿ� ��� �α��� ������ ������.
		ENT_MemberDTO login = (ENT_MemberDTO) session.getAttribute("login");

		// DB�� DELETE�� ����
		memberService.ent_deleteMember(login.getEntBr());

		// �α��� ������ ��� �ִ� ���� ��ü ����(= �α׾ƿ�)
		session.invalidate();

		return "redirect:/";
	}
*/
}
