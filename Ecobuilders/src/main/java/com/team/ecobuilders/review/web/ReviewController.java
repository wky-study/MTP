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
	
	// ���� ���� ��ü ����
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	FileUploadVO fileUpload;
	
	@Autowired
	AttachService attachService;

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
		
//		System.out.println(session.getAttribute("login"));
		
//		if(session.getAttribute("login") == null) {
//			return "redirect:/loginView";
//		}
		
		return "review/reviewWriteView";
	}
	
	// ���� �� �ۼ� Ŭ��
	@PostMapping("/reviewWriteDo")
	public String reviewWriteDo(ReviewDTO review, MultipartFile[] reviewFile) {
		
		System.out.println(review);
		
		// FileUploadVO �� saveFile() �� ����
		// 1. ����ڰ� ������ ÷������ ���� -> reviewFile == null
		if(reviewFile != null) {
			// 2. ����ڰ� ������ 1�� ÷���� -> reviewFile.length == 1 -> saveFile() �ѹ� ����
			// 3. ����ڰ� ������ 3�� ÷���� -> reviewFile.length == 3 -> saveFile() ���� ����
			for(int i = 0; i < reviewFile.length; i++) {
				// ������ ÷������ ��ü MultipartFile�� ���� saveFile() ����
				try {
					// boardNo �� �������
					AttachDTO fileHistory = fileUpload.saveImg(reviewFile[i]);
					System.out.println(fileHistory);
					// fileHistory �� DB�� ����
					attachService.insertAttach(fileHistory);
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
			}
				
		}
		
		reviewService.writeReview(review);
		
		return "redirect:reviewView";
	}
	
	
	// ���� �� �� ������
	@RequestMapping("/reviewDetailView")
	public String reviewDetailView(int no, Model model) {
		System.out.println("Ŭ���� �Խñ� ��ȣ" + no);
		
		// ��ȸ�� ��� �߰� �Ұ�
//		reviewService.reviewCountUp(no);
		
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
		
		model.addAttribute("keyReview", review);
		
		return "review/reviewDetailView";
	}
	
	
	
	
	
	
	
}
