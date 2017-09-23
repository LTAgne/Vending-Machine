package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class LogWriter {

	public void writeLog (String category, BigDecimal amount, BigDecimal balance) {
		
		LocalTime time = LocalTime.now();
		LocalDate date = LocalDate.now();
		
		try (PrintWriter log = new PrintWriter(new FileOutputStream(new File("./log.txt"),true))){
			
		String printDate = date.toString();
		String printTime = time.toString();
		String printCategory = category.toString();
		String printBalance = balance.toString();
		
		log.println(printDate + " " + printTime + " " + String.format("%-25s", printCategory) + String.format("%10-s", "$" + printBalance));
		} catch(FileNotFoundException e){
			e.getMessage();
		}
		
	}
	
}
