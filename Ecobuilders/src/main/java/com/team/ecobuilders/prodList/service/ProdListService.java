package com.team.ecobuilders.prodList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.ecobuilders.common.vo.SearchVO;
import com.team.ecobuilders.prodList.dao.IProdListDAO;
import com.team.ecobuilders.prodList.dto.ProdListDTO;
@Service
public class ProdListService {
	@Autowired
	IProdListDAO dao;
	
	public List<ProdListDTO> getProdList(SearchVO search){
		List<ProdListDTO> result = dao.getProdList(search);
		return result;
		
	}
	
	public int getProdCount(SearchVO search) {
		int result = dao.getProdCount(search);
		return result;
	}

}
