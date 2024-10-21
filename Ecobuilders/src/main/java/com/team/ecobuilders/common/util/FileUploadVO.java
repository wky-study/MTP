package com.team.ecobuilders.common.util;

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
	
	public AttachDTO saveFile(MultipartFile file) throws IOException {
		// uploadPath �� ����� ���ϸ� ���� (����ũ ���̵�)
		String fileName = UUID.randomUUID().toString();
		
		// ���� ��ο� ���ϸ� �̾���̱� (=������ Ǯ ���)
		// File.separatorChar �� ������� \\, �������� / ���
		String atchPath = attachPath + File.separatorChar + fileName;
		
		// �ش��ο� ������ ���� ���� (����PC ���õ�ũ)
		file.transferTo(new File(atchPath));
		
		// ���� DB�� ���� ÷������ ��ü(AttachDTO ��ü ���� �� ����)
		AttachDTO result = new AttachDTO();
		
		result.setAtchFileName(fileName);	// UUID
		result.setAtchOriginalName(file.getOriginalFilename());	// ÷�εɴ�� �̸�
		result.setAtchFileSize(file.getSize());  // byte
		result.setAtchFancySize(transferToFancy(file.getSize())); //  MB, KB, GB ...
		result.setAtchContentType(file.getContentType()); // .png ,...
		result.setAtchPath(atchPath);  	// Ǯ ���
		
		System.out.println("uploadVo���� �������� : " + result);
		
		return result;
		
	}
	
	
	public String transferToFancy(long size) {
			
			if(size < 1024) {
				return size + "Byte";
			}else if(size < 1024 * 1024) {
				return size / 1024 + "KB";
			}else if(size < 1024 * 1024 * 1024) {
				return size / 1024 / 1024 + "MB";
			}else {
				return size / 1024 / 1024 / 1024 + "GB";
			}
			 
		}
	
	public AttachDTO saveImg(MultipartFile file) throws IOException {
		// uploadPath �� ����� ���ϸ� ���� (����ũ ���̵�)
		String fileName = UUID.randomUUID().toString();
		
		// ���� ��ο� ���ϸ� �̾���̱� (=������ Ǯ ���)
		// File.separatorChar �� ������� \\, �������� / ���
		String atchPath = attachPath + File.separatorChar + fileName;
		
		System.out.println(atchPath);
		// �ش��ο� ������ ���� ���� (����PC ���õ�ũ)
		file.transferTo(new File(atchPath));
		
		// ���� DB�� ���� ÷������ ��ü(AttachDTO ��ü ���� �� ����)
		AttachDTO result = new AttachDTO();
		
		result.setAtchPath(fileName);  	
		
		return result;
		
	}
	
	
	
}
