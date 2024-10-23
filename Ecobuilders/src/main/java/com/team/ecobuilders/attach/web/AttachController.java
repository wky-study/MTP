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
	// 파일 다운로드
	@RequestMapping("/fileDownload")
	public void fileDownload(String fileName, String originName,HttpServletResponse response) {
		
		System.out.println(fileName);
		System.out.println(originName);
		
		// 해당 파일의 풀경로 생성
		// C:\\upload\\qeqwe26-11weqe1-123qewqe-eqwe124
		String atchFilePath = attachPath + File.separatorChar + fileName;
		
		// 해당 파일에 대한 File 객체 생성
		File downloadFile = new File(atchFilePath);
		
		// File 객체로부터 해당 파일의 내용을 읽어서 byte 배열로 리턴
		// (FileUtils를 쓰면 편함. pom.xml에 common-io에 대한 dependency 추가)
		try {
			byte[] byteData = FileUtils.readFileToByteArray(downloadFile);
			
			// 응답 데이터(response)로 byteData를 넘겨줄 준비
			response.setContentType("application/octet-stream");
			response.setContentLength(byteData.length);
			
			// 사용자가 파일을 다운받을 때의 파일명 설정
			response.setHeader("Content-Disposition"
								, "attachment; fileName=\"" + URLEncoder.encode(originName, "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			// 응답 데이터로 파일 전송
			response.getOutputStream().write(byteData);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 파일 업로드
	@ResponseBody
	@PostMapping("/uploadImg")
	public String uploadImg(MultipartFile file, HttpSession session) {
		
		String uuid = "";
		
		try {
			AttachDTO uploadImg = fileUpload.saveFile(file);
			System.out.println(uploadImg);
			
			uuid = uploadImg.getAtchFileName();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Attach컨트롤러에서 uuid reviewWriteView로 보냄 : " + uuid);
		
		return uuid;
		
	}	
	
	// 저장된 이미지 파일을 읽어서 응답 데이터로 넘겨주기
	@RequestMapping("/displayImage")
	public ResponseEntity<byte[]> displayImage(String fileName) {
		
		// 요청시 넘어온 fileName을 이용하여 실제 저장된 이미지 파일을 읽어오기
		
		// 이미지 파일의 풀경로 세팅 (C:\\upload\\7fe29986-7fa8-4ff8-80dc-6eda1cd44150)
		String imgPath = attachPath + File.separatorChar + fileName;
		
		// ResponseEntity 의 헤더 (header) 설정을 위해 HttpHeaders 객체 생성
		HttpHeaders headers = new HttpHeaders();
		
		// headers에 데이터 타입 적용 (이미지)
		headers.setContentType(MediaType.IMAGE_PNG);
		
		ResponseEntity<byte[]> result = null;
		
		try(FileInputStream fis = new FileInputStream(imgPath);) {
			
			// fis 로부터 이미지 파일 읽어서 byte 배열로 리턴
			byte[] data = IOUtils.toByteArray(fis);
			
			// 응답에 사용될 ResponseEntity 객체 생성 (HttpStatus는 응답코드)
			result = new ResponseEntity<byte[]>(data, headers, HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
			// 문제 발생시 에러와 관련된 응답코드를 가진 ResponseEntity 객체 생성
			result = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		
		return result;
		
	}
	
	
	
}
