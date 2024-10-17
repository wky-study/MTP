package com.team.ecobuilders.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.ecobuilders.review.dao.IReviewDAO;
import com.team.ecobuilders.review.dto.ReviewDTO;
import com.team.ecobuilders.review.vo.SearchVO;


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
	public int getReviewCount() {
		int result = dao.getReviewCount();
		return result;
	};
	
	// �� �Ѱ� ��ȸ �ϱ�
	public ReviewDTO getReview(int no) {
		ReviewDTO result = dao.getReview(no);
		return result;
	};
	
	
}
