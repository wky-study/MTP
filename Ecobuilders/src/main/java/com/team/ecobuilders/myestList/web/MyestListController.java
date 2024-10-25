package com.team.ecobuilders.myestList.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.ecobuilders.myestList.dto.MyestListDTO;
/*
@Controller
@RequestMapping("/mp_estimateList")
public class MyestListController {

    @Autowired
    private MyestListController MyestListService;

    // 현재 로그인된 사용자의 견적서 리스트 가져오기
    @GetMapping("/mp_estimateList")
    public String mp_estimateList(Model model, HttpSession session) {
        
    	// 세션에서 현재 로그인된 사용자의 estId 가져오기
        String estId = (String) session.getAttribute("estId");

        // 사용자의 estId와 일치하는 견적서 목록 조회
        List<MyestListDTO> myestList = MyestListService.getEstListById(estId);

        // 조회된 견적서 목록을 모델에 추가
        model.addAttribute("keyEstList", myestList);

        // JSP로 이동
        return "KDH_member/mp_estimateList";
    }
}
*/