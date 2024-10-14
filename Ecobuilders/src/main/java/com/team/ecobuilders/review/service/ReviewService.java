package com.team.ecobuilders.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.ecobuilders.review.dao.IReviewDAO;
import com.team.ecobuilders.review.dto.ReviewDTO;


@Service
public class ReviewService {
	
	@Autowired
	IReviewDAO dao;

	// �� ��� ��������
	public List<ReviewDTO> getReviewList(){
		List<ReviewDTO> result = dao.getReviewList();
		return result;
	}
	
	
}
