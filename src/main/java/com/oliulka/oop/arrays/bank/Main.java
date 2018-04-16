package com.oliulka.oop.arrays.bank;
		// You job is to create a simple banking application.
		// There should be a Bank class
		// It should have an arraylist of Branches
		// Each Branch should have an arraylist of Customers
		// The Customer class should have an arraylist of Doubles (transactions)
		// Customer:
		// Name, and the ArrayList of doubles.
		// Branch:
		// Need to be able to add a new customer and initial transaction amount.
		// Also needs to add additional transactions for that customer/branch
		// Bank:
		// Add a new branch
		// Add a customer to that branch with initial transaction
		// Add a transaction for an existing customer for that branch
		// Show a list of customers for a particular branch and optionally a list
		// of their transactions
		// Demonstration autoboxing and unboxing in your code
		// Hint: Transactions
		// Add data validation.
		// e.g. check if exists, or does not exist, etc.
		// Think about where you are adding the code to perform certain actions

public class Main {

	public static void main(String[] args) 
	{
		Bank bank = new Bank("WF");
		bank.addBranch("Downtown");
		bank.addCustomer("Downtown", "Oleksii", 100.02);
		bank.addCustomer("Downtown", "John", 57.32);
		bank.addCustomer("Downtown", "Holly", 40.12);
		bank.addCustomerTransaction("Downtown", "Oleksii", 5000.00);
		bank.listCustomers("Downtown", true);
		
		bank.addBranch("Albany");
		bank.addCustomer("Albany", "Jim", 312.67);
		bank.listCustomers("Albany", true);
		
		if(!bank.addCustomer("Loop", "Frank", 312.67)){
			System.out.println("Error, baranch does not exist!");
		}
		
		if(!bank.addBranch("Downtown")){
			System.out.println("Error, baranch downtown already exist!");
		}
	}

}
