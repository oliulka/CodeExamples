package com.oliulka.oop.arrays.bank;

import java.util.ArrayList;

public class Customer {
	
	private String Name;
	private ArrayList<Double> transactions;
	
	
	public Customer(String name, double initialAmount) {
		this.Name = name;
		this.transactions = new ArrayList<Double>();
		addTransaction(initialAmount);
	}
	
	public void addTransaction(double transactionAmount){
		transactions.add(transactionAmount);
	}

	public String getName() {
		return Name;
	}

	public ArrayList<Double> getTransactions() {
		return transactions;
	}


}
