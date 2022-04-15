package com.productmanagement.model;

public class Product {
	
	private int p_id;
	private String p_name;
	private double p_price;
	private String p_brand;
	
	
	public Product(String p_name, double p_price, String p_brand) {
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_brand = p_brand;
	}
	
	public Product(int p_id, String p_name, double p_price, String p_brand) {
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_brand = p_brand;
	}
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public double getP_price() {
		return p_price;
	}
	public void setP_price(double p_price) {
		this.p_price = p_price;
	}
	public String getP_brand() {
		return p_brand;
	}
	public void setP_brand(String p_brand) {
		this.p_brand = p_brand;
	}
	
	
}
