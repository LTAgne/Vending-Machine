package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product {
	
	public Candy(String nameOfProduct, BigDecimal price) {
		super(nameOfProduct, price);
	}
	
	public String getSound() {	
		return "Munch Munch, Yum!";
	}

}
