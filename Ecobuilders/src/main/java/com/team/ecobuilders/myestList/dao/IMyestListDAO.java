package com.team.ecobuilders.myestList.dao;

import java.util.List;
import com.team.ecobuilders.myestList.dto.MyestListDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMyestListDAO {
    List<MyestListDTO> getEstList(); // 견적서 목록 조회
}






