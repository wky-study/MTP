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
		// 요청에서 파라미터를 가져와 VO 객체를 생성
		// VO파일 생성해야 함
		QuoDTO quoDTO = new QuoDTO();
        quoDTO.setQuoId(request.getParameter("quoId"));
        quoDTO.setQuoDate(java.sql.Date.valueOf(request.getParameter("quoDate"))); // 예시: String -> Date 변환
        quoDTO.setQuoStart(java.sql.Date.valueOf(request.getParameter("quoStart"))); // 예시: String -> Date 변환
        quoDTO.setQuoEnd(java.sql.Date.valueOf(request.getParameter("quoEnd"))); // 예시: String -> Date 변환
        quoDTO.setQuoItems(request.getParameter("quoItems"));
        quoDTO.setQuoPrice(request.getParameter("quoPrice"));
        quoDTO.setQuoOpen(request.getParameter("quoOpen"));
		// 도면(BLOB) 저장 부분은 생략, 필요시 추가
		quoDTO.setEst_id(request.getParameter("est_id")); // 견적서 분류번호
		quoDTO.setEnt_br(request.getParameter("ent_br")); // 사업자 등록번호
		quoDTO.setRemarks(request.getParameter("remarks")); // 비고

		// 서비스 메서드를 호출하여 데이터베이스에 저장
		quoService.insertQuo(quoDTO); // insertQuo 메서드 호출 (서비스에서 구현 필요)

		// 저장 후 리다이렉트 또는 뷰 반환
		return "redirect:/success"; // 임시로 성공 페이지로 리다이렉트 (나중에 적절한 URL로 변경)
	}
}