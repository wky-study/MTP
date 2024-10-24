package com.team.ecobuilders.prodList.dto;

public class ProdListDTO {
	
	
	private int itemId;
	private String itemType;
	private String itemName;
	private String itemLv;
	private String itemEfi;
	private int itemPrice;
	private String entName;
	private int prodNo;
	private String prodDate;
	private String prodDelyn;
	private String itemStd;
	

	public ProdListDTO() {
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getItemType() {
		return itemType;
	}


	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemLv() {
		return itemLv;
	}


	public void setItemLv(String itemLv) {
		this.itemLv = itemLv;
	}


	public String getItemEfi() {
		return itemEfi;
	}


	public void setItemEfi(String itemEfi) {
		this.itemEfi = itemEfi;
	}


	public int getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}


	public String getEntName() {
		return entName;
	}


	public void setEntName(String entName) {
		this.entName = entName;
	}


	public int getProdNo() {
		return prodNo;
	}


	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}


	public String getProdDate() {
		return prodDate;
	}


	public void setProdDate(String prodDate) {
		this.prodDate = prodDate;
	}


	public String getProdDelyn() {
		return prodDelyn;
	}


	public void setProdDelyn(String prodDelyn) {
		this.prodDelyn = prodDelyn;
	}


	public String getItemStd() {
		return itemStd;
	}


	public void setItemStd(String itemStd) {
		this.itemStd = itemStd;
	}


	public ProdListDTO(int itemId, String itemType, String itemName, String itemLv, String itemEfi, int itemPrice,
			String entName, int prodNo, String prodDate, String prodDelyn, String itemStd) {
		super();
		this.itemId = itemId;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemLv = itemLv;
		this.itemEfi = itemEfi;
		this.itemPrice = itemPrice;
		this.entName = entName;
		this.prodNo = prodNo;
		this.prodDate = prodDate;
		this.prodDelyn = prodDelyn;
		this.itemStd = itemStd;
	}


	@Override
	public String toString() {
		return "ProdListDTO [itemId=" + itemId + ", itemType=" + itemType + ", itemName=" + itemName + ", itemLv="
				+ itemLv + ", itemEfi=" + itemEfi + ", itemPrice=" + itemPrice + ", entName=" + entName + ", prodNo="
				+ prodNo + ", prodDate=" + prodDate + ", prodDelyn=" + prodDelyn + ", itemStd=" + itemStd + "]";
	}

}