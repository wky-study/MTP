package com.team.ecobuilders.reply.dto;

public class ReplyDTO {

	private String replyNo;			/* 댓글 번호 */
	private int reviewNo;			/* 자유게시판 글 번호 */
	private String memId;			/* 작성자 아이디 */
	private String memName; 		/* 작성자 닉네임 */
	private String replyContent;	/* 댓글 내용 */
	private String replyDate;		/* 댓글 작성일 */
	
	
	public ReplyDTO() {
	}


	public ReplyDTO(String replyNo, int reviewNo, String memId, String memName, String replyContent, String replyDate) {
		this.replyNo = replyNo;
		this.reviewNo = reviewNo;
		this.memId = memId;
		this.memName = memName;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
	}


	@Override
	public String toString() {
		return "ReplyDTO [replyNo=" + replyNo + ", reviewNo=" + reviewNo + ", memId=" + memId + ", memName=" + memName
				+ ", replyContent=" + replyContent + ", replyDate=" + replyDate + "]";
	}


	public String getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
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


	public String getMemName() {
		return memName;
	}


	public void setMemName(String memName) {
		this.memName = memName;
	}


	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}


	public String getReplyDate() {
		return replyDate;
	}


	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	
	
	
}
