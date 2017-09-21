package com.techelevator;

import java.math.BigDecimal;

public class Drinks extends Product {
	
	public Drinks(String nameOfProduct, BigDecimal price) {
		super(nameOfProduct, price);
	}
	
	protected String getSound() {	
		return "Glug, glug! Yum!";
	}

}
