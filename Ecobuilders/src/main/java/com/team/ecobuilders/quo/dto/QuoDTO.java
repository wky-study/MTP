package com.team.ecobuilders.quo.dto;

import java.util.Arrays;
import java.util.Date;

public class QuoDTO {
	
	private String quoId;        // ������ �з���ȣ
    private Date quoDate;        // �ۼ��� ��¥
    private Date quoStartdate;       // �ð� ���� ��¥
    private Date quoEnddate;         // �ð� ������ ��¥
    private String quoItems;     // JSON ���Ϸ� ������ �׸�
    private String quoPrice;     // �� ����
    private String quoOpen;      // �ӽ����� ���� ('Y' �Ǵ� 'N')
    private byte[] quoBlueprint;  // ���� (BLOB���� ����)
    private String estId;           // ������ �з���ȣ (�ٸ� ���̺� ���� �Ǵ� quo_id�� ������ �� ����)
    private String entBr;        // ����� ��Ϲ�ȣ
    private String remarks;		 // ���(��Ÿ)
    
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
