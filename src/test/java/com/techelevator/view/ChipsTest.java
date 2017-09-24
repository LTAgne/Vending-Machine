package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.Chips;

public class ChipsTest {
	
	Chips sut;

	@Before
	public void setUp() throws Exception {
		sut = new Chips("Premium Chips", new BigDecimal ("6.00"));
	}

	@Test
	public void testPrice() {
		
		assertEquals("6.00", sut.getPrice().toString());
	}
	@Test
	public void testName() {
		
		assertEquals("Premium Chips", sut.getNameofProduct());
	}
	@Test
	public void testSound() {
		
		assertEquals("Crunch Crunch, Yum!", sut.getSound());
	}

}
