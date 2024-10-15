package com.team.ecobuilders.estimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.ecobuilders.estimate.dao.IEstimateDAO;
import com.team.ecobuilders.estimate.dto.EstimateDTO;

@Service
public class EstimateService {
	
	@Autowired
	IEstimateDAO dao;
	
	public List<EstimateDTO> getEstimateList(){
		List<EstimateDTO> result = dao.getEstimateList();
		return result;
	}

}
