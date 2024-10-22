package com.team.ecobuilders.review.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team.ecobuilders.KDH_member.dto.KDH_MemberDTO;
import com.team.ecobuilders.attach.dto.AttachDTO;
import com.team.ecobuilders.attach.service.AttachService;
import com.team.ecobuilders.common.exception.BizNotFoundException;
import com.team.ecobuilders.common.util.FileUploadVO;
import com.team.ecobuilders.common.vo.SearchVO;
import com.team.ecobuilders.reply.dto.ReplyDTO;
import com.team.ecobuilders.reply.service.ReplyService;
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
	
	@Autowired
	ReplyService replyService;

	// 리뷰목록 페이지
	@RequestMapping("/reviewView")
	public String reviewView(Model model, SearchVO search) {
		
		int reviewCount = reviewService.getReviewCount(search);
		
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
	
	@RequestMapping("/reviewWriteView")
	public String reviewWriteView(HttpSession session) {
		
		System.out.println(session.getAttribute("login"));
		
		if(session.getAttribute("login") == null) {
			return "redirect:/loginView";
		}
		
		return "review/reviewWriteView";
	}
	
	// 리뷰 글 작성 클릭
	@PostMapping("/reviewWriteDo")
	public String reviewWriteDo(ReviewDTO review, String imgFileName, HttpSession session) {
		
		KDH_MemberDTO login= (KDH_MemberDTO)session.getAttribute("login");
		
		review.setMemId(login.getMemId());
		review.setMemName(login.getMemName());
		review.setReviewPath(imgFileName);
		System.out.println(review);
		
		reviewService.writeReview(review);

		
		return "redirect:reviewView";
	}
	
	
	// 리뷰 글 상세 페이지
	@RequestMapping("/reviewDetailView")
	public String reviewDetailView(int no, Model model) {
		System.out.println("클릭한 게시글 번호" + no);
		
		// 조회수 기능 추가 할거
		reviewService.reviewCountUp(no);
		
		System.out.println("조회수 끝");
		
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
		
		System.out.println(review);
		
		model.addAttribute("keyReview", review);
		
		// 댓글 목록 가져오기
		List<ReplyDTO> replyList = replyService.getReplyList(no);
		model.addAttribute("keyReplyList",replyList);	
		
		
		// 게시글 댓글 수 가져오기
		int replyCount = replyService.replyCount(no);
		model.addAttribute("keyReplyCount", replyCount);
		
		
		return "review/reviewDetailView";
	}
	
	// 리뷰게시판 글 수정 화면
	@PostMapping("/reviewEditView")
	public String reviewEditView(int no, Model model) {
		
		try {
			ReviewDTO review = reviewService.getReview(no);
			model.addAttribute("keyReview", review);
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			return "errPage";
		}
		
		return "review/reviewEditView";
	}
	
	// 자유게시판 글 수정 등록
	@PostMapping("/reviewEditDo")
	public String reviewEditDo(ReviewDTO review) {
		
		System.out.println(review);
		
		reviewService.updateReview(review);
		
		return "redirect:/reviewDetailView?no=" + review.getReviewNo();
		
	}
	
	// 자유게시판 글 삭제
	@PostMapping("/reviewDeleteDo")
	public String reviewDeleteDo(int no) {
		
		reviewService.deleteReview(no);
		
		return "redirect:/reviewView";
		
	}
	
	
	
}
