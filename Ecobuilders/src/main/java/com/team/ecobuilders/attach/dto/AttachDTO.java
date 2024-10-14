package com.team.ecobuilders.attach.dto;

public class AttachDTO {

	private int atchNo;						/* 첨부파일 번호 */
	private int reviewNo;					/* 첨부파일 게시글 번호 */
	private String atchFileName;			/* 실제 서버 로컬에 저장된 파일명 */
	private String atchOriginalName;		/* 사용자가 첨부했을때 파일명 */
	private String atchContentType;			/* 첨부파일 확장자 */
	private String atchPath;				/* 첨부파일 풀 경로 */
	
	
	public AttachDTO() {
	}


	public AttachDTO(int atchNo, int reviewNo, String atchFileName, String atchOriginalName, String atchContentType,
			String atchPath) {
		super();
		this.atchNo = atchNo;
		this.reviewNo = reviewNo;
		this.atchFileName = atchFileName;
		this.atchOriginalName = atchOriginalName;
		this.atchContentType = atchContentType;
		this.atchPath = atchPath;
	}


	@Override
	public String toString() {
		return "AttachDTO [atchNo=" + atchNo + ", reviewNo=" + reviewNo + ", atchFileName=" + atchFileName
				+ ", atchOriginalName=" + atchOriginalName + ", atchContentType=" + atchContentType + ", atchPath="
				+ atchPath + "]";
	}


	public int getAtchNo() {
		return atchNo;
	}


	public void setAtchNo(int atchNo) {
		this.atchNo = atchNo;
	}


	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public String getAtchFileName() {
		return atchFileName;
	}


	public void setAtchFileName(String atchFileName) {
		this.atchFileName = atchFileName;
	}


	public String getAtchOriginalName() {
		return atchOriginalName;
	}


	public void setAtchOriginalName(String atchOriginalName) {
		this.atchOriginalName = atchOriginalName;
	}


	public String getAtchContentType() {
		return atchContentType;
	}


	public void setAtchContentType(String atchContentType) {
		this.atchContentType = atchContentType;
	}


	public String getAtchPath() {
		return atchPath;
	}


	public void setAtchPath(String atchPath) {
		this.atchPath = atchPath;
	}
	
	
	
}
