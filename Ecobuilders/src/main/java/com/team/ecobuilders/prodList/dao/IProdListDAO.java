package com.team.ecobuilders.prodList.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.prodList.dto.ProdListDTO;

@Mapper
public interface IProdListDAO {
	List<ProdListDTO> getProdList(); 

}
