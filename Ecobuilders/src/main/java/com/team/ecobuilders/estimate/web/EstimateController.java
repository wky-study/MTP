package com.team.ecobuilders.estimate.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.ecobuilders.estimate.dto.EstimateDTO;
import com.team.ecobuilders.estimate.service.EstimateService;

@Controller
public class EstimateController {
    
    @Autowired
    private EstimateService estimateService;

    // 견적서 목록 조회
    @RequestMapping("/tradePost")
    public String estimatePostView(Model model) {
        List<EstimateDTO> estimateList = estimateService.fetchEstimateList();
        model.addAttribute("estimateList", estimateList);
        return "cjs/tradePost"; // 견적서 목록 페이지
    }

    // 견적서 상세 조회 - 견적서분류번호로 상세 페이지 연결해둔 상태라 분류번호 없이 작업하고 
     @RequestMapping("/estimateDetailView/{estId}")
    public String estimateDetailView(@PathVariable String estId, Model model) {
        EstimateDTO estimate = estimateService.getEstimateById(estId); // 견적서 ID로 조회
        model.addAttribute("estimate", estimate);
        return "cjs/estimateDetailView"; // 견적서 상세 페이지
    }

    // 견적서 수정 페이지 - 견적서분류번호로 수정 페이지 연결
     @RequestMapping("/estimateMod/{estId}")
    public String estimateMod(String estId, Model model) {
        EstimateDTO estimate = estimateService.getEstimateById(estId); // 견적서 ID로 조회
        model.addAttribute("estimate", estimate);
        return "cjs/estimateMod"; // 견적서 수정 페이지
    }

    // 견적서 저장
    @PostMapping("/saveEstimate")
    public String saveEstimate(@ModelAttribute EstimateDTO estimateDTO) {
        estimateService.saveEstimate(estimateDTO); // 견적서 저장
        
        return "redirect:/";  // 성공 시 메인페이지로
    }
}
