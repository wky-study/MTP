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
    
    // ������ ��� ��ȸ
    public List<EstimateDTO> fetchEstimateList() {
        List<EstimateDTO> estimateList = dao.getEstimateList();
        if (estimateList == null) {
            throw new RuntimeException("������ ����� �ҷ����� �� �����߽��ϴ�.");
        }
        return estimateList;
    }

    // ������ ����
    public void saveEstimate(EstimateDTO estimate) {
        dao.insertEstimate(estimate); 
    }

    // ������ ID�� ��ȸ
    public EstimateDTO getEstimateById(String estId) {
        return dao.getEstimateById(estId); 
    }
}
