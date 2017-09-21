package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product {
	
	public Candy(String nameOfProduct, BigDecimal price) {
		super(nameOfProduct, price);
	}
	
	protected String getSound() {	
		return "Munch, munch! Yum!";
	}

}
