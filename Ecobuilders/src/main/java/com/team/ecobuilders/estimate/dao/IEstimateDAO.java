package com.team.ecobuilders.estimate.dao;

import java.util.List;
import com.team.ecobuilders.estimate.dto.EstimateDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IEstimateDAO {
    List<EstimateDTO> getEstimateList(); // 견적서 목록 조회
    void insertEstimate(EstimateDTO estimate); // 견적서 저장
    EstimateDTO getEstimateById(String estId); // 견적서 ID로 조회
}
