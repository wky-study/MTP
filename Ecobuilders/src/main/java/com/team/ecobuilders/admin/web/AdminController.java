package com.team.ecobuilders.admin.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.ecobuilders.KDH_member.dto.KDH_MemberDTO;
import com.team.ecobuilders.KDH_member.service.KDH_MemberService;
import com.team.ecobuilders.common.vo.SearchVO;
import com.team.ecobuilders.prodList.dto.ProdListDTO;
import com.team.ecobuilders.prodList.service.ProdListService;
import com.team.ecobuilders.review.dto.ReviewDTO;
import com.team.ecobuilders.review.service.ReviewService;


@Controller
public class AdminController {

	@Autowired
	KDH_MemberService memService;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ProdListService prodListService;
	
	
	@RequestMapping("adminView")
	public String adminView(Model model, SearchVO search) {
		
		List<KDH_MemberDTO> memList = memService.getMemList();
		model.addAttribute("keyMemList" , memList);
		
		// ToDay
		int reviewCount = reviewService.getReviewCount(search);
		
		search.setReviewCount(reviewCount);
		search.setting();		
		
		List<ReviewDTO> review = reviewService.getReviewList(search);
		model.addAttribute("keyReviewList", review);
		
        // 현재 날짜 구하기
        Date today = new Date();
        
        // YYYY-MM-DD 형식으로 포맷
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String toDay = sdf.format(today);
	    model.addAttribute("keyToDay", toDay);
	    
	    System.out.println(toDay);
	    System.out.println(review);
	    
	    // 아이템 불러오기
	    List<ProdListDTO> prodList = prodListService.getProdList(search);
	    model.addAttribute("keyProdList", prodList);
		
		
		return "admin/adminView";
	}
	
	// 회원 삭제
	@PostMapping("/delAdminDo")
	public String delAdminDo(String memId) {
		
		System.out.println("ajax로 받은 아이디 : " +memId);
		
		reviewService.noMemIdReview(memId);
		
		memService.deleteMember(memId);
	
		return "redirect:/adminView";
	}
	
	
	
}
