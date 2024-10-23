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

@Controller // Ŭ���� ��ܿ� ������̼��߰�
public class KDH_MemberController {

	@Autowired
	KDH_MemberService memberService;

	@RequestMapping("/registView")
	public String registView() {

		System.out.println("registView ����");
		

		// ȸ������ ȭ���� �����Ŵ
		return "KDH_member/KDH_registView";

	}   

	@PostMapping("/registDo") // POST ��� ��û�� ���� (���� ����)
	public String registDo(HttpServletRequest request) {


		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));

		// ����ڰ� �Է��� ��й�ȣ
		String pw = request.getParameter("pw");

		KDH_MemberDTO member = new KDH_MemberDTO();
		member.setMemId(request.getParameter("id"));
		member.setMemPassword(request.getParameter("pw")); // ��ȣȭ�� ��й�ȣ �ݿ�
        member.setMemName(request.getParameter("name"));
        member.setMemPhone(request.getParameter("phone"));
        member.setMemAddress(request.getParameter("address"));
        member.setMemEmail(request.getParameter("email"));
        member.setMemAdmin("1");

        try {
            // ���ڿ��� Date�� ��ȯ
        	Timestamp date = new Timestamp(new Date().getTime());
        	System.out.println(date);
            member.setMemDate(date);
        } catch (Exception e) {
            e.printStackTrace();
            // ���� ó�� ���� �߰�
        }

        // DB�� �ش� ȸ�������� ���� -> mybatis ���
        memberService.insertMember(member);

        return "redirect:/loginView"; // redirect:/ ���� redirect:/loginView �� ����
    }

	@RequestMapping("/loginView")
	public String loginView(HttpServletRequest request, Model model) {

		// ��� ���������� /loginView ��û�� �ߴ��� Ȯ��
		String from = request.getHeader("Referer");
		System.out.println(from + " ���κ��� ��û�� ��");

		model.addAttribute("keyFrom", from);

		return "KDH_member/KDH_loginView";
	}

	// �α��� ��û�� ����ڰ� �Է��� id�� password�� �����ͼ�
	// DB�� ��ȸ�ϱ�
	// loginView���� ���޵Ǿ���� �� ������
	// 1. HttpServletRequest ��ü�κ��� getParameter�� id, pw�� ������
	// 2. loginDo �Ķ���Ϳ� name�� id, pw �� �ۼ�
	// 3. ���̵�, ��й�ȣ ���� KDH_MemberDTO ��ü ���� �ʵ庯���� �ش�
	// KDH_MemberDTO ��ü �ϳ��� ��� ���� �� ����
	// input �±��� name�� ���� ���� KDH_MemberDTO�� �ʵ庯����� ��ġ�ؾ���
	@PostMapping("/loginDo")
	public String loginDo(KDH_MemberDTO member, Model model, HttpServletResponse response, String from,
			HttpSession session, boolean rememberId, RedirectAttributes attr) { // member �ʵ庯�� memId, memPassword�� �� ����

		// memId�� memPassword ���� ä���� ����
		System.out.println("�α��� ��û");
		System.out.println(member);
		// checkbox ���� String���� ������ on �Ǵ� null ��
		// boolean���� ������ true / false ��
		System.out.println(rememberId);

		// DB�� member ���� �� id�� ��ġ�ϴ� ������ ������ (1��)
		// members ���̺��� ȸ�� �������� �� �÷� ����
		// KDH_MemberDTO ��ü�� �� �ʵ庯���� ���ԵǾ� ä����
		KDH_MemberDTO login = memberService.loginMember(member);
		System.out.println(login); // �α��� ���н� null ���� ���ϵ�

		// �α��� ���� ���� �Ǻ�
		if (login != null) {

			// �α��� ������ ���� ��ü�� �α��� ���� ����
			// Ű��: login, ���� value��: KDH_MemberDTO ��ü
			session.setAttribute("login", login);

			// ���̵� ����ϱⰡ üũ�Ǿ� ������
			// ���̵� ������ Ŭ���̾�Ʈ(������)�� ��Ű�� ���� ����
			if (rememberId) {
				// ���̵� ����ϱ� üũ

				// ��Ű ����
				// Ű��: rememberId
				// value��: �α����� ����� ���̵�
				Cookie cookie = new Cookie("rememberId", login.getMemId());

				// ������ ��Ű�� ����(response) ��ü�� ����ش�.
				response.addCookie(cookie);
			} else {
				// ���̵� ����ϱ� üũ����
				// rememberId Ű������ ���� ���� ��Ű�� �������ֱ�

				// ��Ű ���� (���� �� �־ ��������Ƿ� empty)
				Cookie cookie = new Cookie("rememberId", "");

				// ��Ű�� ������� ���� (Ŭ���̾�Ʈ�� �������ڸ��� ��������� ��������)
				cookie.setMaxAge(0);

				response.addCookie(cookie);
			}

		} else {
			// �α��� ����
			// �α��� ���� ������ �Բ� �α��� �������� ����
			// model�� failMsg Ű������ "���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�." ���� ����
			// loginView.jsp ���� failMsg Ű���� ���� ���� ���� �� �� �ִ�.
//			model.addAttribute("failMsg", "���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");

			// RedirectAttributes�� addFlashAttribute�� �����͸� ���� �� redirect�� �ϸ�
			// �޴� �ʿ��� �ش� ������ ��� ����
			attr.addFlashAttribute("failMsg", "���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");

			// redirect:/loginView �� �ϸ� model�� ������ �����
			// forward:/loginView �� �ϸ� ���� �޼ҵ��� model, request �� ���� ���޵�
			// redirect �� �� ������ ������ ��� RedirectAttributes ��ü �̿�
			return "redirect:/loginView";
		}

		// �α��� �� Ȩȭ�� �̵� -> Ȩȭ��("/") ���� �����̷�Ʈ
		// �α��� �� ���� ȭ������ �̵� -> from ���� �����̷�Ʈ
		return "redirect:" + "/";
	}

	// �α׾ƿ��� ����
	@RequestMapping("/logoutDo")
	public String logoutDo(HttpSession session, HttpServletRequest request) {
		System.out.println("/logoutDo");
		// /logoutDo ��û�� �� ����� ������ ����
		session.invalidate();
		
		// ��� ���������� /logoutDo �� ��û�ߴ��� Ȯ��
		String from = request.getHeader("Referer");
		
		// �α׾ƿ��� ��û�ߴ� �������� �����̷�Ʈ
		return "redirect:" + from;
		
		
	}
	

	// ȸ������ ������ ��û
	@RequestMapping("/memEditView")
	public String memEditView() {
		return "KDH_member/KDH_memEditView";
	}

	// ȸ������ ��� ��û
	@PostMapping("/memEditDo")
	public String memEditDo(KDH_MemberDTO member, HttpSession session) {

		// memId, memName, memPhone, memEmail ä��������
		// memPassword �� ä�����ְų� �������
		// -> memPassword �� ä���������� ����, ��ä���������� ���� ��й�ȣ ����
		System.out.println(member);

		// DB �� update�� ����
		memberService.updateMember(member);

		// ���ǿ� ��� �α��� ������ ����� ������ ��ü�ϱ�
		// 1. DB���� ���� �α������� id�� ���� member ������ �����ͼ� ���ǿ� ����
		KDH_MemberDTO login = memberService.getMember(member.getMemId());
		session.setAttribute("login", login);

		return "redirect:/memEditView";

	}

	// ȸ������ ��� ��û
	@PostMapping("/memDelDo")
	public String memDelDo(HttpSession session) {

		// ���ǿ� ��� �α��� ������ ������.
		KDH_MemberDTO login = (KDH_MemberDTO) session.getAttribute("login");

		// DB�� DELETE�� ����
		memberService.deleteMember(login.getMemId());

		// �α��� ������ ��� �ִ� ���� ��ü ����(= �α׾ƿ�)
		session.invalidate();

		return "redirect:/";
	}
	



}
