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
	
	// 리뷰 서비스 객체 생성
	@Autowired
	ReviewService reviewService;

	// 리뷰목록 페이지
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
	
	// 리뷰 게시글 추가로 가져오기
	@ResponseBody
	@PostMapping("/loadMoreDO")
	public List<ReviewDTO> loadMoreDO(SearchVO search) {
		
		System.out.println(search);
		
		search.setting();
		
		List<ReviewDTO> review = reviewService.getReviewList(search);
		
		return review;
	}
	
	// 리뷰 글 작성 페이지 (내용 로그인 기능 생기면 확인 해야함)
	@RequestMapping("/reviewWriteView")
	public String reviewWriteView(HttpSession session) {
		
		System.out.println(session.getAttribute("login"));
		
//		if(session.getAttribute("login") == null) {
//			return "redirect:/loginView";
//		}
		
		return "review/reviewWriteView";
	}
	
	// 리뷰 글 상세 페이지
	@RequestMapping("/reviewDetailView")
	public String reviewDetailView(int no, Model model) {
		System.out.println("클릭한 게시글 번호" + no);
		
		ReviewDTO review = null;
		review = reviewService.getReview(no);
		
		System.out.println(review);
		
		return "review/reviewDetailView?no="  + no;
	}
	
	
	
	
	
	
}
