package com.team.ecobuilders.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.ecobuilders.common.exception.BizNotFoundException;
import com.team.ecobuilders.common.vo.SearchVO;
import com.team.ecobuilders.review.dao.IReviewDAO;
import com.team.ecobuilders.review.dto.ReviewDTO;


@Service
public class ReviewService {
	
	@Autowired
	IReviewDAO dao;

	// �� ��� ��������
	public List<ReviewDTO> getReviewList(SearchVO search){
		List<ReviewDTO> result = dao.getReviewList(search);
		return result;
	}
	
	// �� �� ���� ��������
	public int getReviewCount(SearchVO search) {
		int result = dao.getReviewCount(search);
		return result;
	};
	
	// �� �Ѱ� ��ȸ �ϱ�
	public ReviewDTO getReview(int no) throws BizNotFoundException {
		ReviewDTO result = dao.getReview(no);
		
		if(result == null) {
			throw new BizNotFoundException("�ش� �Խñ��� ��ȣ�� �������� �ʽ��ϴ�.", "API_001");
		}
		
		return result;
	};
	
	// �� �ۼ��ϱ�
	public int writeReview(ReviewDTO review) {
		int result = dao.writeReview(review);
		return result;
	};
	
	// ����Խñ� ��ȸ�� ������Ʈ
	public int reviewCountUp(int no) {
		int result = dao.reviewCountUp(no);
		return result;
	};
	
	// ����Խñ� ����
	public int updateReview(ReviewDTO review) {
		int result = dao.updateReview(review);
		return result;
		
	}
	
	// ���� �Խñ� ����
	public int deleteReview(int reviewNo) {
		int result = dao.deleteReview(reviewNo);
		return result;
	};
	
	// Ż�� ȸ�� ���̵� null �� ����
	public int noMemIdReview(String memId) {
		int result = dao.noMemIdReview(memId);
		return result;
	};
	
	
}
