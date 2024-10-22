package com.team.ecobuilders.quo.dto;

import java.util.Arrays;
import java.util.Date;

public class QuoDTO {
	
	private String quoId;        // 견적서 분류번호
    private Date quoDate;        // 작성된 날짜
    private Date quoStartdate;       // 시공 시작 날짜
    private Date quoEnddate;         // 시공 끝나는 날짜
    private String quoItems;     // JSON 파일로 저장할 항목
    private String quoPrice;     // 총 가격
    private String quoOpen;      // 임시저장 여부 ('Y' 또는 'N')
    private byte[] quoBlueprint;  // 도면 (BLOB으로 저장)
    private String estId;           // 견적서 분류번호 (다른 테이블 참조 또는 quo_id와 동일할 수 있음)
    private String entBr;        // 사업자 등록번호
    private String remarks;		 // 비고(기타)
    
    public QuoDTO() {
    }
    
	@Override
	public String toString() {
		return "QuoDTO [quoId=" + quoId + ", quoDate=" + quoDate + ", quoStartdate=" + quoStartdate + ", quoEnddate=" + quoEnddate
				+ ", quoItems=" + quoItems + ", quoPrice=" + quoPrice + ", quoOpen=" + quoOpen + ", quoBlueprint="
				+ Arrays.toString(quoBlueprint) + ", estId=" + estId + ", entBr=" + entBr + ", remarks=" + remarks
				+ "]";
	}
	public QuoDTO(String quoId, Date quoDate, Date quoStartdate, Date quoEnddate, String quoItems, String quoPrice,
			String quoOpen, byte[] quoBlueprint, String estId, String entBr, String remarks) {
		super();
		this.quoId = quoId;
		this.quoDate = quoDate;
		this.quoStartdate = quoStartdate;
		this.quoEnddate = quoEnddate;
		this.quoItems = quoItems;
		this.quoPrice = quoPrice;
		this.quoOpen = quoOpen;
		this.quoBlueprint = quoBlueprint;
		this.estId = estId;
		this.entBr = entBr;
		this.remarks = remarks;
	}
	public String getQuoId() {
		return quoId;
	}
	public void setQuoId(String quoId) {
		this.quoId = quoId;
	}
	public Date getQuoDate() {
		return quoDate;
	}
	public void setQuoDate(Date quoDate) {
		this.quoDate = quoDate;
	}
	public Date getquoStartdate() {
		return quoStartdate;
	}
	public void setquoStartdate(Date quoStartdate) {
		this.quoStartdate = quoStartdate;
	}
	public Date getquoEnddate() {
		return quoEnddate;
	}
	public void setquoEnddate(Date date) {
		this.quoEnddate = date;
	}
	public String getQuoItems() {
		return quoItems;
	}
	public void setQuoItems(String quoItems) {
		this.quoItems = quoItems;
	}
	public String getQuoPrice() {
		return quoPrice;
	}
	public void setQuoPrice(String quoPrice) {
		this.quoPrice = quoPrice;
	}
	public String getQuoOpen() {
		return quoOpen;
	}
	public void setQuoOpen(String quoOpen) {
		this.quoOpen = quoOpen;
	}
	public byte[] getQuoBlueprint() {
		return quoBlueprint;
	}
	public void setQuoBlueprint(byte[] quoBlueprint) {
		this.quoBlueprint = quoBlueprint;
	}
	public String getEstId() {
		return estId;
	}
	public void setEstId(String estId) {
		this.estId = estId;
	}
	public String getEntBr() {
		return entBr;
	}
	public void setEntBr(String entBr) {
		this.entBr = entBr;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

    
    
    
}
