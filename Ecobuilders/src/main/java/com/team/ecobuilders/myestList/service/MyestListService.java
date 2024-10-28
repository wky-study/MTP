package com.team.ecobuilders.myestList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.ecobuilders.myestList.dao.IMyestListDAO;
import com.team.ecobuilders.myestList.dto.MyestListDTO;

@Service
public class MyestListService {

    @Autowired
    private MyestListService myestListRepository;

    // 특정 사용자(estId)의 견적서 조회
    public List<MyestListDTO> getEstListById(String estId) {
        return myestListRepository.getEstListById(estId);
    }
}
