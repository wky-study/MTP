package com.team.ecobuilders.prodList.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.common.vo.SearchVO;
import com.team.ecobuilders.prodList.dto.ProdListDTO;

@Mapper
public interface IProdListDAO {
	//제품 목록 불러오기
	List<ProdListDTO> getProdList(SearchVO search); 
	
	//제품 목록 총 개수 가져오기
	int getProdCount(SearchVO search);

}
