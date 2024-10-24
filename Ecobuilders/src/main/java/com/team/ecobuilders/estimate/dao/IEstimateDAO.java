package com.team.ecobuilders.estimate.dao;

import java.util.List;
import com.team.ecobuilders.estimate.dto.EstimateDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IEstimateDAO {
    List<EstimateDTO> getEstimateList(); // ������ ��� ��ȸ
    void insertEstimate(EstimateDTO estimate); // ������ ����
    EstimateDTO getEstimateById(String estId); // ������ ID�� ��ȸ
}
