package com.team.ecobuilders.quo.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.ecobuilders.quo.dto.QuoDTO;
import com.team.ecobuilders.quo.service.QuoService;

@Controller
public class QuoController {
	
	@Autowired
	QuoService quoService;
	
	
	@PostMapping("/insertQuo")
	public String insertQuo(HttpServletRequest request) {
		// ��û���� �Ķ���͸� ������ VO ��ü�� ����
		// VO���� �����ؾ� ��
		QuoDTO quoDTO = new QuoDTO();
        quoDTO.setQuoId(request.getParameter("quoId"));
        quoDTO.setQuoDate(java.sql.Date.valueOf(request.getParameter("quoDate"))); // ����: String -> Date ��ȯ
        quoDTO.setQuoStart(java.sql.Date.valueOf(request.getParameter("quoStart"))); // ����: String -> Date ��ȯ
        quoDTO.setQuoEnd(java.sql.Date.valueOf(request.getParameter("quoEnd"))); // ����: String -> Date ��ȯ
        quoDTO.setQuoItems(request.getParameter("quoItems"));
        quoDTO.setQuoPrice(request.getParameter("quoPrice"));
        quoDTO.setQuoOpen(request.getParameter("quoOpen"));
		// ����(BLOB) ���� �κ��� ����, �ʿ�� �߰�
		quoDTO.setEst_id(request.getParameter("est_id")); // ������ �з���ȣ
		quoDTO.setEnt_br(request.getParameter("ent_br")); // ����� ��Ϲ�ȣ
		quoDTO.setRemarks(request.getParameter("remarks")); // ���

		// ���� �޼��带 ȣ���Ͽ� �����ͺ��̽��� ����
		quoService.insertQuo(quoDTO); // insertQuo �޼��� ȣ�� (���񽺿��� ���� �ʿ�)

		// ���� �� �����̷�Ʈ �Ǵ� �� ��ȯ
		return "redirect:/success"; // �ӽ÷� ���� �������� �����̷�Ʈ (���߿� ������ URL�� ����)
	}
}