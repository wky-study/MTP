package com.team.ecobuilders.review.web;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team.ecobuilders.attach.dto.AttachDTO;
import com.team.ecobuilders.attach.service.AttachService;
import com.team.ecobuilders.common.exception.BizNotFoundException;
import com.team.ecobuilders.common.util.FileUploadVO;
import com.team.ecobuilders.common.vo.SearchVO;
import com.team.ecobuilders.review.dto.ReviewDTO;
import com.team.ecobuilders.review.service.ReviewService;


@Controller
public class ReviewController {
	
	// 리뷰 서비스 객체 생성
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	FileUploadVO fileUpload;
	
	@Autowired
	AttachService attachService;

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
		
//		System.out.println(session.getAttribute("login"));
		
//		if(session.getAttribute("login") == null) {
//			return "redirect:/loginView";
//		}
		
		return "review/reviewWriteView";
	}
	
	// 리뷰 글 작성 클릭
	@PostMapping("/reviewWriteDo")
	public String reviewWriteDo(ReviewDTO review, MultipartFile[] reviewFile) {
		
		System.out.println(review);
		
		// FileUploadVO 의 saveFile() 을 실행
		// 1. 사용자가 파일을 첨부하지 않음 -> reviewFile == null
		if(reviewFile != null) {
			// 2. 사용자가 파일을 1개 첨부함 -> reviewFile.length == 1 -> saveFile() 한번 실행
			// 3. 사용자가 파일을 3개 첨부함 -> reviewFile.length == 3 -> saveFile() 세번 실행
			for(int i = 0; i < reviewFile.length; i++) {
				// 각각의 첨부파일 객체 MultipartFile에 대해 saveFile() 실행
				try {
					// boardNo 가 비어있음
					AttachDTO fileHistory = fileUpload.saveImg(reviewFile[i]);
					System.out.println(fileHistory);
					// fileHistory 를 DB에 저장
					attachService.insertAttach(fileHistory);
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
			}
				
		}
		
		reviewService.writeReview(review);
		
		return "redirect:reviewView";
	}
	
	
	// 리뷰 글 상세 페이지
	@RequestMapping("/reviewDetailView")
	public String reviewDetailView(int no, Model model) {
		System.out.println("클릭한 게시글 번호" + no);
		
		// 조회수 기능 추가 할거
//		reviewService.reviewCountUp(no);
		
		ReviewDTO review = null;
		try {
			review = reviewService.getReview(no);
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			// 에러 발생 시 넣은 에러코드와 에러메시지 확인
			String errCode = e.getErrCode();
			String errMsg = e.getMessage();
			
			// 에러페이지에 에러메시지를 보여주고자 한다면 모델에 추가
			model.addAttribute("errMsg", errMsg);
			
			// 에러페이지로 보내기(안만듬)
			return "error/errPage";
			
		}
		
		model.addAttribute("keyReview", review);
		
		return "review/reviewDetailView";
	}
	
	
	
	
	
	
	
}
