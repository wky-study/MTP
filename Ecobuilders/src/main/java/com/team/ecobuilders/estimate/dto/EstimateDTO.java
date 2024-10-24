package com.team.ecobuilders.estimate.dto;

import java.util.Date;

public class EstimateDTO {
	
	private String estId;			/* 견적서 분류번호 */
	private String memName;			/* 작성자 이름 */
	private Date estDate;			/* 견적서 작성일자 */
	private String estItems;		/* 시공 자재 */
	private String estPrice;		/* 자재 가격 */
	private String estAddress;		/* 시공 주소 */
	private String estOpen;			/* 삭제 여부 */
	public EstimateDTO() {
		super();
	}
	public EstimateDTO(String estId, String memName, Date estDate, String estItems, String estPrice, String estAddress,
			String estOpen) {
		super();
		this.estId = estId;
		this.memName = memName;
		this.estDate = estDate;
		this.estItems = estItems;
		this.estPrice = estPrice;
		this.estAddress = estAddress;
		this.estOpen = estOpen;
	}
	public String getEstId() {
		return estId;
	}
	public void setEstId(String estId) {
		this.estId = estId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public Date getEstDate() {
		return estDate;
	}
	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}
	public String getEstItems() {
		return estItems;
	}
	public void setEstItems(String estItems) {
		this.estItems = estItems;
	}
	public String getEstPrice() {
		return estPrice;
	}
	public void setEstPrice(String estPrice) {
		this.estPrice = estPrice;
	}
	public String getEstAddress() {
		return estAddress;
	}
	public void setEstAddress(String estAddress) {
		this.estAddress = estAddress;
	}
	public String getEstOpen() {
		return estOpen;
	}
	public void setEstOpen(String estOpen) {
		this.estOpen = estOpen;
	}
	@Override
	public String toString() {
		return "EstimateDTO [estId=" + estId + ", memName=" + memName + ", estDate=" + estDate + ", estItems="
				+ estItems + ", estPrice=" + estPrice + ", estAddress=" + estAddress + ", estOpen=" + estOpen + "]";
	}

}
