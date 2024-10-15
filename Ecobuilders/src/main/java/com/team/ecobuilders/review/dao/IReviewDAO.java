package com.team.ecobuilders.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.review.dto.ReviewDTO;
import com.team.ecobuilders.review.vo.SearchVO;

@Mapper
public interface IReviewDAO {

	// 리뷰 게시판 글 목록 가져오기
	List<ReviewDTO> getReviewList(SearchVO search);
	
	// 리뷰 게시판 글 총 갯수 가져오기
	int getReviewCount();
	
	// 리뷰 게시글 한개 조회 하기
	ReviewDTO getReview(int no);
}
