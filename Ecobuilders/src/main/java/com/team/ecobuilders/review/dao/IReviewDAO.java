package com.team.ecobuilders.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.review.dto.ReviewDTO;

@Mapper
public interface IReviewDAO {

	// 리뷰 게시판 글 목록 가져오기
	List<ReviewDTO> getReviewList();
	
	
}
