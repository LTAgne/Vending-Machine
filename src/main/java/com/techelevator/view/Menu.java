package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	public BigDecimal getDecimalFromUser(String message) {
		BigDecimal inputtedDecimal = null;
		out.println(message);
		out.flush();
		do {
			try {
				String userInput = in.nextLine();
				inputtedDecimal = new BigDecimal(userInput);
				if ( 
					( inputtedDecimal.compareTo( new BigDecimal ("1") ) == 0 ) || 
					( inputtedDecimal.compareTo( new BigDecimal ("5") ) == 0 ) || 
					( inputtedDecimal.compareTo( new BigDecimal ("10") ) == 0 ) || 
					( inputtedDecimal.compareTo( new BigDecimal ("20") ) == 0 )
					) {
					return inputtedDecimal;
				}  
				
			} catch(NumberFormatException ex) {
				out.print("Please input a valid number >>> ");
				out.flush();
			}
		} while (inputtedDecimal == null);
		System.out.print("Sorry that bill is not accepted");
		return new BigDecimal("0.00");
	}

	public Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
//		Object [] options = new Object[19];
//		for (int i=0; i<19; i++){
//			if (i<=3) {
//				options[i] = "A"+i;
//			} if (i<=7){
//				options[i] = "B"+i;
//			}if (i<=11){
//				options[i] = "C"+i;
//			}if (i<=19){
//				options[i] = "D"+i;
//			}
		
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = (String) options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}

//	public String getChoiceFromUserInput() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
