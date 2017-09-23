package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Product {
	
	public Chips(String nameOfProduct, BigDecimal price) {
		super(nameOfProduct, price);
	}
	
	public String getSound() {	
		return "Crunch Crunch, Yum!";
	}

}
