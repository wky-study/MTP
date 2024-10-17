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

	// 글 목록 가져오기
	public List<ReviewDTO> getReviewList(SearchVO search){
		List<ReviewDTO> result = dao.getReviewList(search);
		return result;
	}
	
	// 글 총 갯수 가져오기
	public int getReviewCount() {
		int result = dao.getReviewCount();
		return result;
	};
	
	// 글 한개 조회 하기
	public ReviewDTO getReview(int no) throws BizNotFoundException {
		ReviewDTO result = dao.getReview(no);
		
		if(result == null) {
			throw new BizNotFoundException("해당 게시글의 번호가 존재하지 않습니다.", "API_001");
		}
		
		return result;
	};
	
	// 글 작성하기
	public int writeReview(ReviewDTO review) {
		int result = dao.writeReview(review);
		return result;
	};
	
	
}
