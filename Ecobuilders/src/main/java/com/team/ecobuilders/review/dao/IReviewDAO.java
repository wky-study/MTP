package com.team.ecobuilders.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.common.vo.SearchVO;
import com.team.ecobuilders.review.dto.ReviewDTO;

@Mapper
public interface IReviewDAO {

	// 리뷰 게시판 글 목록 가져오기
	List<ReviewDTO> getReviewList(SearchVO search);
	
	// 리뷰 게시판 글 총 갯수 가져오기
	int getReviewCount(SearchVO search);
	
	// 리뷰 게시글 한개 조회 하기
	ReviewDTO getReview(int no);
	
	// 리뷰 게시글 작성하기
	int writeReview(ReviewDTO review);
	
	// 리뷰 게시글 조회수 업데이트
	int reviewCountUp(int no);
	
	
}
