package com.team.ecobuilders.prodList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.ecobuilders.prodList.dao.IProdListDAO;
import com.team.ecobuilders.prodList.dto.ProdListDTO;
@Service
public class ProdListService {
	@Autowired
	IProdListDAO dao;
	
	public List<ProdListDTO> getProdList(){
		List<ProdListDTO> result = dao.getProdList();
		return result;
		
	}

}
