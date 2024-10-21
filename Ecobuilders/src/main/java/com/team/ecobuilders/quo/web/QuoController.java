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
        
        // ������ �з���ȣ
        String quoId = request.getParameter("quoId");
        quoDTO.setQuoId((quoId != null && !quoId.isEmpty()) ? quoId : null);
        
        // �ۼ��� ��¥ ó��
//        String quoDateStr = request.getParameter("quoDate");
//        if (quoDateStr != null && !quoDateStr.isEmpty()) {
//            quoDTO.setQuoDate(Date.valueOf(quoDateStr)); 
//        } else {
//            quoDTO.setQuoDate(null);
//        }

        // �ð� ���� ��¥ ó��
        String quoStartdateStr = request.getParameter("quoStart");
        if (quoStartdateStr != null && !quoStartdateStr.isEmpty()) {
            quoDTO.setquoStartdate(Date.valueOf(quoStartdateStr)); // ����: String -> Date ��ȯ
        } else {
            quoDTO.setquoStartdate(null);
        }

        // �ð� ���� ��¥ ó��
        String quoEnddateStr = request.getParameter("quoEnddate");
        if (quoEnddateStr != null && !quoEnddateStr.isEmpty()) {
            quoDTO.setquoEnddate(Date.valueOf(quoEnddateStr)); // ����: String -> Date ��ȯ
        } else {
            quoDTO.setquoEnddate(null);
        }

        // ��Ÿ �ʵ� ó��
        quoDTO.setQuoItems(request.getParameter("quoItems") != null && !request.getParameter("quoItems").isEmpty() ? request.getParameter("quoItems") : null);
        quoDTO.setQuoPrice(request.getParameter("quoPrice") != null && !request.getParameter("quoPrice").isEmpty() ? request.getParameter("quoPrice") : null);
        quoDTO.setQuoOpen(request.getParameter("quoOpen") != null && !request.getParameter("quoOpen").isEmpty() ? request.getParameter("quoOpen") : null);
        
     // ������ �з���ȣ�� ����� ��Ϲ�ȣ ó��
        quoDTO.setEstId(request.getParameter("est_id") != null && !request.getParameter("est_id").isEmpty() ? request.getParameter("est_id") : null);
        quoDTO.setEntBr(request.getParameter("entBr") != null && !request.getParameter("entBr").isEmpty() ? request.getParameter("entBr") : null);

        
        // ��� ó��
        quoDTO.setRemarks(request.getParameter("remarks") != null && !request.getParameter("remarks").isEmpty() ? request.getParameter("remarks") : null);

        // ���� �޼��带 ȣ���Ͽ� �����ͺ��̽��� ����
        quoService.insertQuo(quoDTO); // insertQuo �޼��� ȣ�� (���񽺿��� ���� �ʿ�)

        // ���� �� �����̷�Ʈ
        return "redirect:/"; // ������ URL�� �����̷�Ʈ
    }
}
