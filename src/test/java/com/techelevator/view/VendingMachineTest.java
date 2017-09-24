package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.Product;
import com.techelevator.VendingMachine;

public class VendingMachineTest {


	VendingMachine sut; 
	
	@Before
	public void setUp() throws Exception {
		sut = new VendingMachine ();
	
	}

	@Test
	public void testGetChange() {
		
	assertEquals("Here's your change! (You received 4 Quarter(s), 1 Dime(s), and 1 Nickel(s)",sut.getChange (new BigDecimal ("1.15")));
	}
	
//	Cannot test console print outs. Instead, we tested this within the program itself.
//	@Test
//	public void testBuildInventory() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testAllKeysAvailableInInventory() {	
		assertEquals(16, sut.getInventory().size());
		//Since all keys are available, we know that our stock reader works
		//and that are inventory is built when the vending machine is made
		
	}
	
	@Test
	public void testMakePurchase() {
		sut.makePurchase("A1", (new BigDecimal ("5.00")));
		Map<String, List<Product>> newThing = new TreeMap<>();
		newThing.putAll(sut.getInventory());
		
		assertEquals(4, newThing.get("A1").size());
		//this means the item was removed from inventory after it was purchased
		
	}


//	Cannot test console print outs. Instead, we tested this within the program itself.
//	@Test
//	public void testDisplayInventory() {
//		fail("Not yet implemented");
//	}

}
