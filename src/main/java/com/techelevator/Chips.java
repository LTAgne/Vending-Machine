package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Product {
	
	public Chips(String nameOfProduct, BigDecimal price) {
		super(nameOfProduct, price);
	}
	
	protected String getSound() {	
		return "Crunch, crunch! Yum!";
	}

}
