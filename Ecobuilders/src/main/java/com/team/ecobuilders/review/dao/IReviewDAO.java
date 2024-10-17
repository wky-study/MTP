package com.team.ecobuilders.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.review.dto.ReviewDTO;
import com.team.ecobuilders.review.vo.SearchVO;

@Mapper
public interface IReviewDAO {

	// ���� �Խ��� �� ��� ��������
	List<ReviewDTO> getReviewList(SearchVO search);
	
	// ���� �Խ��� �� �� ���� ��������
	int getReviewCount();
	
	// ���� �Խñ� �Ѱ� ��ȸ �ϱ�
	ReviewDTO getReview(int no);
}
