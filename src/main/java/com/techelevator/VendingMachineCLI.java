package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISHED = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISHED, };
	
	
	private Menu menu;
	private VendingMachine vm;
	
	public BigDecimal balance = new BigDecimal ("0.00");
	private BigDecimal startingBalance = new BigDecimal ("0.00"); 
	
	public VendingMachineCLI(Menu menu, VendingMachine vm) {
		this.menu = menu;
		this.vm = vm;
	}
	
	public void run() {
		while(true) {
		boolean mainMenu = true;
		boolean subMenu = true;
		while(mainMenu) {
			subMenu = true;
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				vm.displayInventory();
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
	
				while(subMenu) {
					System.out.println("");
					System.out.println("*****************************");
					System.out.println("Current Money Provided: $" + balance);
					System.out.println("*****************************");
					
					String choice2 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				
				if(choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					 
					  balance = balance.add(menu.getDecimalFromUser("How much money would you like to insert? (e.g. $1, $5, $10) >>>"));	
					  vm.writeLog("FEED MONEY:", null, startingBalance, balance);
					} else if (choice2.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						Scanner input = new Scanner(System.in);
						System.out.print("Enter Product Key to purchase >>>");
						String userSelection = input.nextLine(); 
						balance = vm.makePurchase(userSelection, balance);
					} else if (choice2.equals(PURCHASE_MENU_FINISHED)) {
						//vm.getChange(balance);
						System.out.println(vm.getChange(balance));
						balance = new BigDecimal("0.00");
						vm.getPurchases();
						subMenu = false;
					} else {
					}
				}
			}
			}
		}
	}
			
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachine vm = new VendingMachine();
		VendingMachineCLI cli = new VendingMachineCLI(menu, vm);
		cli.run();
	}
	
	public BigDecimal feedMoney() {
		BigDecimal balance = new BigDecimal("0.00");
		Scanner userInput = new Scanner(System.in);
		System.out.println("How much money would you like to insert? >>>");
		BigDecimal inputMoney = userInput.nextBigDecimal();
		balance = balance.add(inputMoney);
		System.out.println(balance);
		return balance;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	
}

	