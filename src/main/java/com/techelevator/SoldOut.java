package com.techelevator;

import java.math.BigDecimal;

public class SoldOut extends Product  {
	
	public SoldOut(String nameOfProduct, BigDecimal price) {
		super(nameOfProduct, price);
	}
	@Override
	protected String getSound() {
		// TODO Auto-generated method stub
		return null;
	}

}
