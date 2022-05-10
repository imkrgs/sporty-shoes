package com.learn.mycart.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class purchaseReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchaseId;
	public purchaseReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public purchaseReport(int productId, String productName, int productPrice, int quantity, int totalAmount,
			Date date) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.date = date;
	}
	@Override
	public String toString() {
		return "purchaseReport [purchaseId=" + purchaseId + ", productId=" + productId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", quantity=" + quantity + ", totalAmount=" + totalAmount
				+ ", date=" + date + "]";
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	private int productId;
	private String productName;
	private int productPrice;
	private int quantity;
	private int totalAmount;
	private Date date;
	
}
