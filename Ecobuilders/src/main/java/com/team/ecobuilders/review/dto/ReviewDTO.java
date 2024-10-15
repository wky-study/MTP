package com.team.ecobuilders.review.dto;

public class ReviewDTO {

	private int reviewNo;				/* 리뷰 게시글 번호 */
	private String memId;				/* 작성자 아이디 */
	private String reviewTitle;			/* 리뷰 게시글 제목 */
	private String reviewContent;		/* 리뷰 게시글 내용 */
	private String reviewDate;			/* 작성일 */
	private String atchPath;			/* 파일경로 */
	private String delYn;				/* 삭제 여부 */
	
	public ReviewDTO() {
	}

	public ReviewDTO(int reviewNo, String memId, String reviewTitle, String reviewContent, String reviewDate,
			String atchPath, String delYn, int reviewCount) {
		this.reviewNo = reviewNo;
		this.memId = memId;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.atchPath = atchPath;
		this.delYn = delYn;
	}


	@Override
	public String toString() {
		return "ReviewDTO [reviewNo=" + reviewNo + ", memId=" + memId + ", reviewTitle=" + reviewTitle
				+ ", reviewContent=" + reviewContent + ", reviewDate=" + reviewDate + ", atchPath=" + atchPath
				+ ", delYn=" + delYn + "]";
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getAtchPath() {
		return atchPath;
	}

	public void setAtchPath(String atchPath) {
		this.atchPath = atchPath;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}


	
	

	
	
	
	
}
