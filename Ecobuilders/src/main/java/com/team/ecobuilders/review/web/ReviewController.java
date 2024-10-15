package com.team.ecobuilders.review.web;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.ecobuilders.review.dto.ReviewDTO;
import com.team.ecobuilders.review.service.ReviewService;
import com.team.ecobuilders.review.vo.SearchVO;


@Controller
public class ReviewController {
	
	// ���� ���� ��ü ����
	@Autowired
	ReviewService reviewService;

	// ������ ������
	@RequestMapping("/reviewView")
	public String reviewView(Model model, SearchVO search) {
		
		int reviewCount = reviewService.getReviewCount();
		
		System.out.println(reviewCount);
		
		search.setReviewCount(reviewCount);
		search.setting();
		
		List<ReviewDTO> review = reviewService.getReviewList(search);
		
		System.out.println(review);
		System.out.println(search);
		
		model.addAttribute("keyReview", review);
		model.addAttribute("keySearch", search);

		
		return "review/reviewView";
	}
	
	// ���� �Խñ� �߰��� ��������
	@ResponseBody
	@PostMapping("/loadMoreDO")
	public List<ReviewDTO> loadMoreDO(SearchVO search) {
		
		System.out.println(search);
		
		search.setting();
		
		List<ReviewDTO> review = reviewService.getReviewList(search);
		
		return review;
	}
	
	// ���� �� �ۼ� ������ (���� �α��� ��� ����� Ȯ�� �ؾ���)
	@RequestMapping("/reviewWriteView")
	public String reviewWriteView(HttpSession session) {
		
		System.out.println(session.getAttribute("login"));
		
//		if(session.getAttribute("login") == null) {
//			return "redirect:/loginView";
//		}
		
		return "review/reviewWriteView";
	}
	
	// ���� �� �� ������
	@RequestMapping("/reviewDetailView")
	public String reviewDetailView(int no, Model model) {
		System.out.println("Ŭ���� �Խñ� ��ȣ" + no);
		
		ReviewDTO review = null;
		review = reviewService.getReview(no);
		
		System.out.println(review);
		
		return "review/reviewDetailView?no="  + no;
	}
	
	
	
	
	
	
}
