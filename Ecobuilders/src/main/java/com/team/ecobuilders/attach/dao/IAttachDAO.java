package com.team.ecobuilders.attach.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.attach.dto.AttachDTO;

@Mapper
public interface IAttachDAO {

	int insertAttach(AttachDTO attach);
	
	List<AttachDTO> getAttachList(int reviewNo);
	
}
