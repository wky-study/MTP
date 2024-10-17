package com.team.ecobuilders.attach.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team.ecobuilders.attach.dto.AttachDTO;
import com.team.ecobuilders.common.util.FileUploadVO;



@Controller
public class AttachController {

	@Value("#{util['file.attach.path']}")
	String attachPath;
	
	@Autowired
	FileUploadVO fileUpload;
	
	
	// fileDownload?fileName=qeqwe26-11weqe1-123qewqe-eqwe124
	// ���� �ٿ�ε�
	@RequestMapping("/fileDownload")
	public void fileDownload(String fileName, String originName,HttpServletResponse response) {
		
		System.out.println(fileName);
		System.out.println(originName);
		
		// �ش� ������ Ǯ��� ����
		// C:\\upload\\qeqwe26-11weqe1-123qewqe-eqwe124
		String atchFilePath = attachPath + File.separatorChar + fileName;
		
		// �ش� ���Ͽ� ���� File ��ü ����
		File downloadFile = new File(atchFilePath);
		
		// File ��ü�κ��� �ش� ������ ������ �о byte �迭�� ����
		// (FileUtils�� ���� ����. pom.xml�� common-io�� ���� dependency �߰�)
		try {
			byte[] byteData = FileUtils.readFileToByteArray(downloadFile);
			
			// ���� ������(response)�� byteData�� �Ѱ��� �غ�
			response.setContentType("application/octet-stream");
			response.setContentLength(byteData.length);
			
			// ����ڰ� ������ �ٿ���� ���� ���ϸ� ����
			response.setHeader("Content-Disposition"
								, "attachment; fileName=\"" + URLEncoder.encode(originName, "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			// ���� �����ͷ� ���� ����
			response.getOutputStream().write(byteData);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// ���� ���ε�
	@ResponseBody
	@PostMapping("/uploadImg")
	public String uploadImg(MultipartFile file, HttpSession session) {
		
		String uuid = "";
		
		try {
			AttachDTO uploadImg = fileUpload.saveImg(file);
			System.out.println(uploadImg);
			
			uuid = uploadImg.getAtchFileName();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return uuid;
		
	}	
	
	// ����� �̹��� ������ �о ���� �����ͷ� �Ѱ��ֱ�
	@RequestMapping("/displayImage")
	public ResponseEntity<byte[]> displayImage(String fileName) {
		
		// ��û�� �Ѿ�� fileName�� �̿��Ͽ� ���� ����� �̹��� ������ �о����
		
		// �̹��� ������ Ǯ��� ���� (C:\\upload\\7fe29986-7fa8-4ff8-80dc-6eda1cd44150)
		String imgPath = attachPath + File.separatorChar + fileName;
		
		// ResponseEntity �� ��� (header) ������ ���� HttpHeaders ��ü ����
		HttpHeaders headers = new HttpHeaders();
		
		// headers�� ������ Ÿ�� ���� (�̹���)
		headers.setContentType(MediaType.IMAGE_PNG);
		
		ResponseEntity<byte[]> result = null;
		
		try(FileInputStream fis = new FileInputStream(imgPath);) {
			
			// fis �κ��� �̹��� ���� �о byte �迭�� ����
			byte[] data = IOUtils.toByteArray(fis);
			
			// ���信 ���� ResponseEntity ��ü ���� (HttpStatus�� �����ڵ�)
			result = new ResponseEntity<byte[]>(data, headers, HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
			// ���� �߻��� ������ ���õ� �����ڵ带 ���� ResponseEntity ��ü ����
			result = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		
		return result;
		
	}
	
	
	
}
