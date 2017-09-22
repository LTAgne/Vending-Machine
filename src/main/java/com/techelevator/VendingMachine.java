package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
	List <Product> productPurchased = new ArrayList<>();
	
//	try (PrintWriter writeLog = new PrintWriter("log.txt")) {
//		} catch (FileNotFoundException e) {
//		e.printStackTrace();
//		}
//	
//	
//	
//	private writeLog(){
//		writeLog.println(line);
//		try (
					// within try block we are creating a new writer	
//				) { 
//			while (readPom.hasNextLine()) {               // read a line from readPom
//				String line = readPom.nextLine();;
//				
//				writePom.println(line);                  // writes the line read from readPom and writes it to writePom - technically writing to a buffer because there is a buffer inside of the PrintWriter 
//			}
//			}catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//	}

	
	public VendingMachine () {   //constructor
		buildInventory();	
	}

	private Map<String, List<Product>> buildInventory() {
		File stockFile = new File("/Users/laurenagne/workspace/team0-java-module1-capstone/vendingmachine.csv");
		
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
					priceList.put(key,tempPrice);
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
		
		BigDecimal costOfItem = priceList.get(userSelection.toUpperCase());
		 if (balance.compareTo(costOfItem) == -1 ){
			 System.out.println("");
			 System.out.println("**Insufficient Funds**");
			 return balance;
		 }else if (inventory.isEmpty()){
			 System.out.println("Item is Sold Out");
			 return balance;
		}else if (inventory.size() >1){ 
			balance = balance.subtract(costOfItem);
			productPurchased.add(inventory.get(userSelection.toUpperCase()).remove(0));
			//inventory.	
			return balance;
		} else {
			return balance;
		}
	}

	public String getChange(BigDecimal balance) {
		
		List<BigDecimal> change = new ArrayList<>();
		change.addAll(Arrays.asList(balance.divideAndRemainder(new BigDecimal("0.25"))));
		change.addAll(Arrays.asList(change.get(1).divideAndRemainder(new BigDecimal("0.10"))));
		change.remove(1);
		change.addAll(Arrays.asList(change.get(2).divideAndRemainder(new BigDecimal("0.05"))));
		change.remove(2);
		return "Here's your change! (You received " + change.get(0)+ " Quarter(s), " + change.get(1) + " Dime(s), and "+ change.get(2) + " Nickel(s)"; 
		 
	}			

}	


