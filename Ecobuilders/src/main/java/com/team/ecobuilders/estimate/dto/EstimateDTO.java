package com.team.ecobuilders.estimate.dto;

public class EstimateDTO {
	private int post_no;
	private String post_title;
	private String post_author;
	
	@Override
	public String toString() {
		return "EstimateDTO [post_no=" + post_no + ", post_title=" + post_title + ", post_author=" + post_author + "]";
	}

	public int getPost_no() {
		return post_no;
	}
	
	public EstimateDTO(int post_no, String post_title, String post_author) {
		super();
		this.post_no = post_no;
		this.post_title = post_title;
		this.post_author = post_author;
	}
	

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}



	public String getPost_title() {
		return post_title;
	}



	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}



	public String getPost_author() {
		return post_author;
	}



	public void setPost_author(String post_author) {
		this.post_author = post_author;
	}



	
	

}
