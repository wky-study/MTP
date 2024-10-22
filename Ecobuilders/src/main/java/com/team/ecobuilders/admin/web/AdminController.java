package com.team.ecobuilders.admin.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.ecobuilders.KDH_member.dto.KDH_MemberDTO;
import com.team.ecobuilders.KDH_member.service.KDH_MemberService;
import com.team.ecobuilders.common.vo.SearchVO;
import com.team.ecobuilders.review.dto.ReviewDTO;
import com.team.ecobuilders.review.service.ReviewService;


@Controller
public class AdminController {

	@Autowired
	KDH_MemberService memService;
	
	@Autowired
	ReviewService reviewService;
	
	@RequestMapping("adminView")
	public String adminView(Model model, SearchVO search) {
		
		// �ؿ� �������� ȸ�� ����
		// List<KDH_MemberDTO> memList = memService.getMemList();
		// model.addAttribute("keyMemList" , memList);
		
		// ToDay
		int reviewCount = reviewService.getReviewCount(search);
		
		search.setReviewCount(reviewCount);
		search.setting();		
		
		List<ReviewDTO> review = reviewService.getReviewList(search);
		model.addAttribute("keyReviewList", review);
		
        // ���� ��¥ ���ϱ�
        Date today = new Date();
        
        // YYYY-MM-DD �������� ����
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String toDay = sdf.format(today);
	    model.addAttribute("keyToDay", toDay);
	    
	    System.out.println(toDay);
	    System.out.println(review);
		
		
		return "admin/adminView";
	}
	
	
	
}
