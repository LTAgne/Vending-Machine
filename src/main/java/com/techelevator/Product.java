package com.techelevator;

import java.math.BigDecimal;

public abstract class Product {
	
	private String nameofProduct;
	private BigDecimal price;
	
	public Product (String nameOfProduct, BigDecimal price) {
		this.nameofProduct = nameOfProduct;
		this.price = price;
	}
	
	protected abstract String getSound();

	public String getNameofProduct() {
		return nameofProduct;
	}

	public void setNameofProduct(String nameofProduct) {
		this.nameofProduct = nameofProduct;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		String result = nameofProduct + " " + price; 
		return result;
	}

}
