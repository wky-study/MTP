package com.team.ecobuilders.quo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.quo.dto.QuoDTO;

@Mapper
public interface IQuoDAO {
	int insertQuo(QuoDTO quo);

}
