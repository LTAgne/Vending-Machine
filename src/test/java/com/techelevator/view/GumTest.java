package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.Gum;

public class GumTest {
	
	Gum sut;

	@Before
	public void setUp() throws Exception {
		sut = new Gum("Pre Chewed Gum", new BigDecimal ("6.00"));
	}

	@Test
	public void testPrice() {
		
		assertEquals("6.00", sut.getPrice().toString());
	}
	@Test
	public void testName() {
		
		assertEquals("Pre Chewed Gum", sut.getNameofProduct());
	}
	@Test
	public void testSound() {
		
		assertEquals("Chew Chew, Yum!", sut.getSound());
	}

}
