package com.team.ecobuilders.review.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.ecobuilders.review.dto.ReviewDTO;
import com.team.ecobuilders.review.service.ReviewService;


@Controller
public class ReviewController {
	
	// ���� ���� ��ü ����
	@Autowired
	ReviewService reviewService;

	// ������ ������
	@RequestMapping("/reviewView")
	public String reviewView(Model model) {
		
		List<ReviewDTO> review = reviewService.getReviewList();
		
		System.out.println(review);
		
		model.addAttribute("keyReview", review);
		
		return "review/reviewView";
	}
	
	// ���� �� ������ ������
	@RequestMapping("/reviewDetailView")
	public String reviewDetailView(int no) {
		
	
		
		return "review/reviewDetailView?no="  + no;
	}
	
	
	
	
	
}
