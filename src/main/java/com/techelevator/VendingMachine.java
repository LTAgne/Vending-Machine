package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
	
	private BigDecimal balance = new BigDecimal("0.00");
	
	//constructor
	public VendingMachine () {
		buildInventory();
		
	}
	
	private String nameOfMachine;
	Map<String, List<Product>> inventory = new HashMap<>();	
	//List<Product> Products = new ArrayList<>();
	
	private Map<String, List<Product>> buildInventory() {
		File stockFile = new File("/Users/jaredmalvic/workspace/team0-java-module1-capstone/vendingmachine.csv");
		
		try (Scanner input = new Scanner(stockFile)) {
			while(input.hasNextLine()) {
				List<Product> products = new ArrayList<>();
				String line = input.nextLine();                         //Reads in line and stores it in String variable line
					
				String[] lineSplitted = line.split("\\|");              //Splits line into words and sentences, respectively
				
				String tempName = lineSplitted[1];
				BigDecimal tempPrice = new BigDecimal(lineSplitted[2]);
				String key = lineSplitted[0];
				
				if (lineSplitted[0].substring(0, 1).equals("A")) {
					for(int i = 0; i < 5; i++){
						products.add(new Chips(tempName, tempPrice));
					}
				}
				
				if (lineSplitted[0].substring(0, 1).equals("B")) {
					for(int i = 0; i < 5; i++){
						products.add(new Candy(tempName, tempPrice));
					}
				}
				
				if (lineSplitted[0].substring(0, 1).equals("C")) {
					for(int i = 0; i < 5; i++){
						products.add(new Drinks(tempName, tempPrice));
					}
				}
				
				if (lineSplitted[0].substring(0, 1).equals("D")) {
					for(int i = 0; i < 5; i++){
						products.add(new Gum(tempName, tempPrice));
					}
				}
					inventory.put(key, products);
			}
				
		} catch (FileNotFoundException e) {
				System.out.println("Your file doesn't exist.");
			}
		return inventory;
	}

	public Map<String, List<Product>> getInventory() {
		return inventory;
	}
	
	public void displayInventory() {
		for(Map.Entry<String, List<Product>> entry : inventory.entrySet()) {
			String key = entry.getKey();
			List value = entry.getValue();
			System.out.println(key + " " + value.toString());
		}
	}

	public BigDecimal getBalance() {
		return balance;
	}
	
	
	
	
}