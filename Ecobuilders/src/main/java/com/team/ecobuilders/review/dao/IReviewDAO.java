package com.team.ecobuilders.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.review.dto.ReviewDTO;

@Mapper
public interface IReviewDAO {

	// ���� �Խ��� �� ��� ��������
	List<ReviewDTO> getReviewList();
	
	
}
