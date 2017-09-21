package com.techelevator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
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
			PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISHED };
	
	private Menu menu;
	private VendingMachine vm;
	
	public VendingMachineCLI(Menu menu, VendingMachine vm) {
		this.menu = menu;
		this.vm = vm;
	}
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				vm.displayInventory();
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true) {
				
				String choice2 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				System.out.println("Current Money Provided: " + vm.getBalance());
					
					if(choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						BigDecimal totalMoney = new BigDecimal(takeMoney().intValue());
						System.out.println(totalMoney);
						
						
						
					} else if (choice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						///do something
					} else if (choice.equals(PURCHASE_MENU_FINISHED)) {
						///do something
					} else {
						////yell at user got back to purchase menu option menu
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
	
	public BigDecimal takeMoney() {
		BigDecimal balance = new BigDecimal("0.00");
		Scanner userInput = new Scanner(System.in);
		System.out.println("Yo, how much money can I has?");
		BigDecimal inputMoney = userInput.nextBigDecimal();
		balance = balance.add(inputMoney);
		System.out.println(balance);
		return balance;
	}
	
	
	
	
	
}

	