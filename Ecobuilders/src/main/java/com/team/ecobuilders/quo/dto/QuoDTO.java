package com.team.ecobuilders.quo.dto;

import java.util.Arrays;
import java.util.Date;

public class QuoDTO {
	
	private String quoId;        // ������ �з���ȣ
    private Date quoDate;        // �ۼ��� ��¥
    private Date quoStart;       // �ð� ���� ��¥
    private Date quoEnd;         // �ð� ������ ��¥
    private String quoItems;     // JSON ���Ϸ� ������ �׸�
    private String quoPrice;     // �� ����
    private String quoOpen;      // �ӽ����� ���� ('Y' �Ǵ� 'N')
    private byte[] quoBlueprint;  // ���� (BLOB���� ����)
    private String est_id;           // ������ �з���ȣ (�ٸ� ���̺� ���� �Ǵ� quo_id�� ������ �� ����)
    private String ent_br;        // ����� ��Ϲ�ȣ
    private String remarks;		 // ���(��Ÿ)
    
    public QuoDTO() {
    }
    
	@Override
	public String toString() {
		return "QuoDTO [quoId=" + quoId + ", quoDate=" + quoDate + ", quoStart=" + quoStart + ", quoEnd=" + quoEnd
				+ ", quoItems=" + quoItems + ", quoPrice=" + quoPrice + ", quoOpen=" + quoOpen + ", quoBlueprint="
				+ Arrays.toString(quoBlueprint) + ", est_id=" + est_id + ", ent_br=" + ent_br + ", remarks=" + remarks
				+ "]";
	}
	public QuoDTO(String quoId, Date quoDate, Date quoStart, Date quoEnd, String quoItems, String quoPrice,
			String quoOpen, byte[] quoBlueprint, String est_id, String ent_br, String remarks) {
		super();
		this.quoId = quoId;
		this.quoDate = quoDate;
		this.quoStart = quoStart;
		this.quoEnd = quoEnd;
		this.quoItems = quoItems;
		this.quoPrice = quoPrice;
		this.quoOpen = quoOpen;
		this.quoBlueprint = quoBlueprint;
		this.est_id = est_id;
		this.ent_br = ent_br;
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
	public Date getQuoStart() {
		return quoStart;
	}
	public void setQuoStart(Date quoStart) {
		this.quoStart = quoStart;
	}
	public Date getQuoEnd() {
		return quoEnd;
	}
	public void setQuoEnd(Date quoEnd) {
		this.quoEnd = quoEnd;
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
	public String getEst_id() {
		return est_id;
	}
	public void setEst_id(String est_id) {
		this.est_id = est_id;
	}
	public String getEnt_br() {
		return ent_br;
	}
	public void setEnt_br(String ent_br) {
		this.ent_br = ent_br;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

    
    
    
}
