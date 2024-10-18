package com.team.ecobuilders.quo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team.ecobuilders.quo.dao.IQuoDAO;
import com.team.ecobuilders.quo.dto.QuoDTO;
import com.team.ecobuilders.reply.dto.ReplyDTO;

@Service
public class QuoService {
	
	@Autowired
	IQuoDAO dao;
	
	public int insertQuo(QuoDTO quo) {
		int result = dao.insertQuo(quo);
		return result;
	}

}
