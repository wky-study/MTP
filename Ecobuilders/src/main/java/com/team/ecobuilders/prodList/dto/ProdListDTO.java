package com.team.ecobuilders.prodList.dto;

public class ProdListDTO {
	
	
	private String itemId;
	private String itemType;
	private String itemName;
	private String itemLv;
	private String itemEfi;
	private int itemPrice;
	
	public ProdListDTO() {
	}

	public ProdListDTO(String itemId, String itemType, String itemName, String itemLv, String itemEfi, int itemPrice) {
		super();
		this.itemId = itemId;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemLv = itemLv;
		this.itemEfi = itemEfi;
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "prod_ListDTO [itemId=" + itemId + ", itemType=" + itemType + ", itemName=" + itemName + ", itemLv="
				+ itemLv + ", itemEfi=" + itemEfi + ", itemPrice=" + itemPrice + "]";
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
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
	
	
	

}

