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
    
    // 견적서 목록 조회
    public List<EstimateDTO> fetchEstimateList() {
        List<EstimateDTO> estimateList = dao.getEstimateList();
        if (estimateList == null) {
            throw new RuntimeException("견적서 목록을 불러오는 데 실패했습니다.");
        }
        return estimateList;
    }

    // 견적서 저장
    public void saveEstimate(EstimateDTO estimate) {
        dao.insertEstimate(estimate); 
    }

    // 견적서 ID로 조회
    public EstimateDTO getEstimateById(String estId) {
        return dao.getEstimateById(estId); 
    }
}
