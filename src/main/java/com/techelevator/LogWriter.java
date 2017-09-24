package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {

	public static void writeLog (String category, BigDecimal amount, BigDecimal startingBalance, BigDecimal endingBalance) {
		
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