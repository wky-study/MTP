package com.team.ecobuilders.estimate.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.team.ecobuilders.estimate.dto.EstimateDTO;

@Mapper
public interface IEstimateDAO {
	List<EstimateDTO> getEstimateList();

}
