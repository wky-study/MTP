package com.team.ecobuilders.prodList.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.ecobuilders.common.vo.SearchVO;
import com.team.ecobuilders.prodList.dto.ProdListDTO;
import com.team.ecobuilders.prodList.service.ProdListService;

@Controller
public class ProdListController {
	
	@Autowired
	ProdListService prodService;
	
	@RequestMapping("/prodView")
	public String prodView(Model model, SearchVO search) {
		
		int prodCount = prodService.getProdCount(search);
		
		search.setReviewCount(prodCount);
		search.prodSetting();
		System.out.println(search);
		
		List<ProdListDTO> prodList = prodService.getProdList(search);
		System.out.println(prodList);
		model.addAttribute("prodList", prodList);
		model.addAttribute("keySearch", search);
		return "prodList/prodView";
	}

}
