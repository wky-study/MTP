package com.team.ecobuilders.myestList.dto;

import java.util.Date;

public class MyestListDTO {
	
	private String estId;			/* 견적서 분류번호 */

	public MyestListDTO(String estId) {
		super();
		this.estId = estId;
	}
	
	@Override
	public String toString() {
		return "MyestListDTO [estId=" + estId + "]";
	}

	public String getEstId() {
		return estId;
	}

	public void setEstId(String estId) {
		this.estId = estId;
	}

}


