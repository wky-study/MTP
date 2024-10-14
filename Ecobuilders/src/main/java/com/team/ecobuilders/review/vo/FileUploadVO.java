package com.team.ecobuilders.review.vo;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.team.ecobuilders.attach.dto.AttachDTO;

@Component
public class FileUploadVO {

	@Value("#{util['file.attach.path']}")
	String attachPath;
	
	public AttachDTO saveImg(MultipartFile file) throws IOException {
		// uploadPath �� ����� ���ϸ� ���� (����ũ ���̵�)
		String fileName = UUID.randomUUID().toString();
		
		// ���� ��ο� ���ϸ� �̾���̱� (=������ Ǯ ���)
		// File.separatorChar �� ������� \\, �������� / ���
		String atchPath = attachPath + File.separatorChar + fileName;
		
		// �ش��ο� ������ ���� ���� (����PC ���õ�ũ)
		file.transferTo(new File(atchPath));
		
		// ���� DB�� ���� ÷������ ��ü(AttachDTO ��ü ���� �� ����)
		AttachDTO result = new AttachDTO();
		
		result.setAtchPath(fileName);  	
		
		return result;
		
	}
	
	
	
	
	
	
	
	
}
