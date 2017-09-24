package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.Drinks;

public class DrinksTest {
	
	Drinks sut;

	@Before
	public void setUp() throws Exception {
		sut = new Drinks("Premium Chocolate Milk", new BigDecimal ("6.00"));
	}

	@Test
	public void testPrice() {
		
		assertEquals("6.00", sut.getPrice().toString());
	}
	@Test
	public void testName() {
		
		assertEquals("Premium Chocolate Milk", sut.getNameofProduct());
	}
	@Test
	public void testSound() {
		
		assertEquals("Glug Glug, Yum!", sut.getSound());
	}

}
