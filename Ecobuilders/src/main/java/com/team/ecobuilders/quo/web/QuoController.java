package com.team.ecobuilders.quo.web;

import java.sql.Date;
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
        QuoDTO quoDTO = new QuoDTO();
        System.out.println("request:"+request.getParameter("quoStart"));
        
        // 견적서 분류번호
        String quoId = request.getParameter("quoId");
        quoDTO.setQuoId((quoId != null && !quoId.isEmpty()) ? quoId : null);
        
        // 작성된 날짜 처리
//        String quoDateStr = request.getParameter("quoDate");
//        if (quoDateStr != null && !quoDateStr.isEmpty()) {
//            quoDTO.setQuoDate(Date.valueOf(quoDateStr)); 
//        } else {
//            quoDTO.setQuoDate(null);
//        }

        // 시공 시작 날짜 처리
        String quoStartdateStr = request.getParameter("quoStart");
        if (quoStartdateStr != null && !quoStartdateStr.isEmpty()) {
            quoDTO.setquoStartdate(Date.valueOf(quoStartdateStr)); // 예시: String -> Date 변환
        } else {
            quoDTO.setquoStartdate(null);
        }

        // 시공 종료 날짜 처리
        String quoEnddateStr = request.getParameter("quoEnddate");
        if (quoEnddateStr != null && !quoEnddateStr.isEmpty()) {
            quoDTO.setquoEnddate(Date.valueOf(quoEnddateStr)); // 예시: String -> Date 변환
        } else {
            quoDTO.setquoEnddate(null);
        }

        // 기타 필드 처리
        quoDTO.setQuoItems(request.getParameter("quoItems") != null && !request.getParameter("quoItems").isEmpty() ? request.getParameter("quoItems") : null);
        quoDTO.setQuoPrice(request.getParameter("quoPrice") != null && !request.getParameter("quoPrice").isEmpty() ? request.getParameter("quoPrice") : null);
        quoDTO.setQuoOpen(request.getParameter("quoOpen") != null && !request.getParameter("quoOpen").isEmpty() ? request.getParameter("quoOpen") : null);
        
     // 견적서 분류번호와 사업자 등록번호 처리
        quoDTO.setEstId(request.getParameter("est_id") != null && !request.getParameter("est_id").isEmpty() ? request.getParameter("est_id") : null);
        quoDTO.setEntBr(request.getParameter("entBr") != null && !request.getParameter("entBr").isEmpty() ? request.getParameter("entBr") : null);

        
        // 비고 처리
        quoDTO.setRemarks(request.getParameter("remarks") != null && !request.getParameter("remarks").isEmpty() ? request.getParameter("remarks") : null);

        // 서비스 메서드를 호출하여 데이터베이스에 저장
        quoService.insertQuo(quoDTO); // insertQuo 메서드 호출 (서비스에서 구현 필요)

        // 저장 후 리다이렉트
        return "redirect:/"; // 적절한 URL로 리다이렉트
    }
}
