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

    // ������ ��� ��ȸ
    @RequestMapping("/tradePost")
    public String estimatePostView(Model model) {
        List<EstimateDTO> estimateList = estimateService.fetchEstimateList();
        model.addAttribute("estimateList", estimateList);
        return "cjs/tradePost"; // ������ ��� ������
    }

    // ������ �� ��ȸ - �������з���ȣ�� �� ������ �����ص� ���¶� �з���ȣ ���� �۾��ϰ� 
     @RequestMapping("/estimateDetailView/{estId}")
    public String estimateDetailView(@PathVariable String estId, Model model) {
        EstimateDTO estimate = estimateService.getEstimateById(estId); // ������ ID�� ��ȸ
        model.addAttribute("estimate", estimate);
        return "cjs/estimateDetailView"; // ������ �� ������
    }

    // ������ ���� ������ - �������з���ȣ�� ���� ������ ����
     @RequestMapping("/estimateMod/{estId}")
    public String estimateMod(String estId, Model model) {
        EstimateDTO estimate = estimateService.getEstimateById(estId); // ������ ID�� ��ȸ
        model.addAttribute("estimate", estimate);
        return "cjs/estimateMod"; // ������ ���� ������
    }

    // ������ ����
    @PostMapping("/saveEstimate")
    public String saveEstimate(@ModelAttribute EstimateDTO estimateDTO) {
        estimateService.saveEstimate(estimateDTO); // ������ ����
        
        return "redirect:/";  // ���� �� ������������
    }
}
