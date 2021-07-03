package com.techelevator.tenmo.services;


import com.techelevator.tenmo.auth.models.AuthenticatedUser;
import com.techelevator.tenmo.auth.models.User;
import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.Transfer;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class ConsoleService {

	private UserService userService;
	private PrintWriter out;
	private Scanner in;

	public ConsoleService(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output, true);
		this.in = new Scanner(input);


	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		out.println();
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	public String getUserInput(String prompt) {
		out.print(prompt+": ");
		out.flush();
		return in.nextLine();
	}

	public Integer getUserInputInteger(String prompt) {
		Integer result = null;
		do {
			out.print(prompt+": ");
			out.flush();
			String userInput = in.nextLine();
			try {
				result = Integer.parseInt(userInput);
			} catch(NumberFormatException e) {
				out.println(System.lineSeparator() + "*** " + userInput + " is not valid ***" + System.lineSeparator());
			}
		} while(result == null);
		return result;
	}

	public void showBalance(List<Account> account ){
		for(int i = 0; i < account.size(); i++) {
			System.out.println("Your current account balance is: $" + account.get(i).getBalance());
		}

	}
	public Transfer showTransfer(List<User> users , User currentUser){
		System.out.println("-------------------------------------------");
		System.out.printf("%-5s  %-15s %n",  "Users", "Name");
		System.out.println("ID");
		System.out.println("-------------------------------------------");
		for(User user: users) {
			if(user.getId() != 0) {
				System.out.printf("%-5s  %-15s %n", user.getId(), user.getUsername());
			}

		}

		System.out.println("Enter ID of user you are sending to (0 to cancel):");
		Long userId = in.nextLong();
		System.out.println("Enter amount:");
		Double transferAmount = in.nextDouble();
		Transfer transfer = new Transfer();
		transfer.setToUser(userId);
		transfer.setFromUser(currentUser.getId());
		transfer.setAmount(transferAmount);
	return transfer;
	}
}
