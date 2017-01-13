package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import cli.CLI;

/*
 * Maya Mill 204263891
 * May Huberman 205481617
 */

public class Main {
	public static void main (String[] args) throws Exception{
		
		CLI myCLI = new CLI();//We want to load level from a file
		String verify = "Exit";//We will use this to compare with the other commands to know when to stop the loop
		List<String> commandSeparatedWords = new ArrayList<String>();//This will save the separated words of the user input
		Scanner scanner = new Scanner(System.in);//create a scanner so we can read the command-line input
		
		do{
			System.out.println("Please enter a command: (Press 'Exit' to stop game)"); //prompt for the command
			String commandInput = scanner.nextLine();//get their input as a String
			commandSeparatedWords = Arrays.asList(commandInput.split(" "));//separate words in the line
			myCLI.addCommandToCommandsQueue(commandSeparatedWords);//Add command to the commands queue
		} while(commandSeparatedWords.get(0).intern() != verify.intern());//while the user didn't input "Exit"
	
		scanner.close();
		myCLI.doCommands();//Do all commands in the commands queue
		
	}
}

