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
	
	// ���� ���� ��ü ����
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	FileUploadVO fileUpload;
	
	@Autowired
	AttachService attachService;
	
	@Autowired
	ReplyService replyService;

	// ������ ������
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
	
	// ���� �Խñ� �߰��� ��������
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
	
	// ���� �� �ۼ� Ŭ��
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
	
	
	// ���� �� �� ������
	@RequestMapping("/reviewDetailView")
	public String reviewDetailView(int no, Model model) {
		System.out.println("Ŭ���� �Խñ� ��ȣ" + no);
		
		// ��ȸ�� ��� �߰� �Ұ�
		reviewService.reviewCountUp(no);
		
		System.out.println("��ȸ�� ��");
		
		ReviewDTO review = null;
		try {
			review = reviewService.getReview(no);
			
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			// ���� �߻� �� ���� �����ڵ�� �����޽��� Ȯ��
			String errCode = e.getErrCode();
			String errMsg = e.getMessage();
			
			// ������������ �����޽����� �����ְ��� �Ѵٸ� �𵨿� �߰�
			model.addAttribute("errMsg", errMsg);
			
			// ������������ ������(�ȸ���)
			return "error/errPage";
			
		}
		
		System.out.println(review);
		
		model.addAttribute("keyReview", review);
		
		// ��� ��� ��������
		List<ReplyDTO> replyList = replyService.getReplyList(no);
		model.addAttribute("keyReplyList",replyList);	
		
		
		// �Խñ� ��� �� ��������
		int replyCount = replyService.replyCount(no);
		model.addAttribute("keyReplyCount", replyCount);
		
		
		return "review/reviewDetailView";
	}
	
	// ����Խ��� �� ���� ȭ��
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
	
	// �����Խ��� �� ���� ���
	@PostMapping("/reviewEditDo")
	public String reviewEditDo(ReviewDTO review) {
		
		System.out.println(review);
		
		reviewService.updateReview(review);
		
		return "redirect:/reviewDetailView?no=" + review.getReviewNo();
		
	}
	
	// �����Խ��� �� ����
	@PostMapping("/reviewDeleteDo")
	public String reviewDeleteDo(int no) {
		
		reviewService.deleteReview(no);
		
		return "redirect:/reviewView";
		
	}
	
	
	
}
