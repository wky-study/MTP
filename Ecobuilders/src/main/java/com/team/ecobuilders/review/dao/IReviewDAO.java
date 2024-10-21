package com.team.ecobuilders.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.common.vo.SearchVO;
import com.team.ecobuilders.review.dto.ReviewDTO;

@Mapper
public interface IReviewDAO {

	// ���� �Խ��� �� ��� ��������
	List<ReviewDTO> getReviewList(SearchVO search);
	
	// ���� �Խ��� �� �� ���� ��������
	int getReviewCount(SearchVO search);
	
	// ���� �Խñ� �Ѱ� ��ȸ �ϱ�
	ReviewDTO getReview(int no);
	
	// ���� �Խñ� �ۼ��ϱ�
	int writeReview(ReviewDTO review);
	
	// ���� �Խñ� ��ȸ�� ������Ʈ
	int reviewCountUp(int no);
	
	
}
