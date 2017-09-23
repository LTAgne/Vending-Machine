package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
	
	Map<String, List<Product>> inventory = new TreeMap<>();	 // list of Keys(A1, A2) with Product Name and prices 5times
	Map<String, BigDecimal> priceList = new TreeMap<>(); // list of Keys(A1, A2) with bigDecimal Prices 
	Map<String, String> productList = new TreeMap<>(); // list of Keys(A1,A2) with product names 
	List <Product> productPurchased = new ArrayList<>();
	

	public VendingMachine () {   //constructor
		buildInventory();	
	}

	private Map<String, List<Product>> buildInventory() {
		File stockFile = new File("/Users/laurenagne/workspace/team0-java-module1-capstone/vendingmachine.csv");
		
		try (Scanner input = new Scanner(stockFile)) {
			while(input.hasNextLine()) {
				List<Product> products = new ArrayList<>();
				String line = input.nextLine();             //Reads in line and stores it in String variable line	
				String[] lineSplitted = line.split("\\|"); //Splits line into words and sentences, respectively
				
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
					priceList.put(key,tempPrice);
					productList.put(key,tempName);
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

	
	public void getPurchases(){
		if (productPurchased.size() == 1){
			System.out.println(productPurchased.get(0).getSound()); 
		} else {
			for (Product element: productPurchased){
				System.out.println(element.getSound()); 
		}
				
		} productPurchased.removeAll(productPurchased);
	}
	
	
	
	public BigDecimal makePurchase(String userSelection, BigDecimal balance) {
		
		BigDecimal startingBalance = balance;
		
		BigDecimal costOfItem = priceList.get(userSelection.toUpperCase());
		try { 
		if (balance.compareTo(costOfItem) == -1 ){
			 System.out.println("");
			 System.out.println("**Insufficient Funds**");
			 return balance;
		
		}else if (inventory.size() == 0 ){        
			 System.out.println("Item is Sold Out");
			 return balance;
		
		}else if (inventory.size() >1){ 
			balance = balance.subtract(costOfItem);
			productPurchased.add(inventory.get(userSelection.toUpperCase()).remove(0));
			writeLog((productList.get(userSelection.toUpperCase()) + " " + userSelection.toUpperCase()), costOfItem, startingBalance, balance);	
			return balance;
		
		} else {
			return balance;
		}
		} catch (IndexOutOfBoundsException ex) {
			
			System.out.print("Sorry that Item is Sold Out");
			return balance;
			
		}
	}

	
	
	public String getChange(BigDecimal balance) {
		BigDecimal endingBalance = new BigDecimal ("0.00");
		
		List<BigDecimal> change = new ArrayList<>();
		change.addAll(Arrays.asList(balance.divideAndRemainder(new BigDecimal("0.25"))));
		change.addAll(Arrays.asList(change.get(1).divideAndRemainder(new BigDecimal("0.10"))));
		change.remove(1);
		change.addAll(Arrays.asList(change.get(2).divideAndRemainder(new BigDecimal("0.05"))));
		change.remove(2);
		writeLog("GIVE CHANGE", null,balance, endingBalance);
		System.out.println("");
		System.out.println("*****************************");
		return "Here's your change! (You received " + change.get(0)+ " Quarter(s), " + change.get(1) + " Dime(s), and "+ change.get(2) + " Nickel(s)"; 
		 
	}			

	
	
	public void writeLog (String category, BigDecimal amount, BigDecimal startingBalance, BigDecimal endingBalance) {
			
		String time = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));
		String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/d/uuuu"));
			
		try (PrintWriter log = new PrintWriter(new FileOutputStream(new File("./log.txt"),true))){
				
		String printSBalance = startingBalance.toString();
		String printEBalance = endingBalance.toString();
			
		log.println(date + " " + time + " " + category + " $" + printSBalance + " $" + printEBalance);
		
		} catch(FileNotFoundException e){
			e.getMessage();
		}
			
	}
		
	
}	


