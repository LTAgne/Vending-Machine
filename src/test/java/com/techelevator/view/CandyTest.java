package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.Candy;

public class CandyTest {
	
	Candy sut;

	@Before
	public void setUp() throws Exception {
		sut = new Candy("Premium Chocolate", new BigDecimal ("6.00"));
	}

	@Test
	public void testPrice() {
		
		assertEquals("6.00", sut.getPrice().toString());
	}
	@Test
	public void testName() {
		
		assertEquals("Premium Chocolate", sut.getNameofProduct());
	}
	@Test
	public void testSound() {
		
		assertEquals("Munch Munch, Yum!", sut.getSound());
	}

}
