package com.team.ecobuilders.prodList.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.common.vo.SearchVO;
import com.team.ecobuilders.prodList.dto.ProdListDTO;

@Mapper
public interface IProdListDAO {
	//��ǰ ��� �ҷ�����
	List<ProdListDTO> getProdList(SearchVO search); 
	
	//��ǰ ��� �� ���� ��������
	int getProdCount(SearchVO search);

}
