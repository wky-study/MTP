package com.team.ecobuilders.estimate.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.ecobuilders.estimate.dto.EstimateDTO;
import com.team.ecobuilders.estimate.service.EstimateService;

@Controller
public class EstimateController {
	
	@Autowired
	EstimateService estimateService;
	
	@RequestMapping("/tradePost")
	public String estimatePostView(Model model) {
		
		List<EstimateDTO> estimateList = estimateService.getEstimateList();
		
		model.addAttribute("estimateList", estimateList);
		
		return "cjs/tradePost";
	}

}
