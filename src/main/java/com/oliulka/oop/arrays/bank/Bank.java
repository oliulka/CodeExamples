package com.oliulka.oop.arrays.bank;

import java.util.ArrayList;

public class Bank {
	
	private String Name;
	private ArrayList<Branch> branchList;
	
	public Bank(String name) {
		this.Name = name;
		this.branchList = new ArrayList<Branch>();
	}

	public boolean addBranch(String branchName)
	{
		if (findBranch(branchName)==null){
			this.branchList.add(new Branch(branchName));
			System.out.println("New branch " +branchName+ " was added successfully" );
			return true;
		}
		return false;
	}
	
	public boolean addCustomer(String branchName, String customerName, double initialAmount)
	{
		Branch branch = findBranch(branchName);
		if (branch != null){
			return branch.newCustomer(customerName, initialAmount);
		}
		return false;
	}
	
	public boolean addCustomerTransaction (String branchName, String customerName, double initialAmount)
	{
		Branch branch = findBranch(branchName);
		if (branch != null){
			return branch.addTransaction(customerName, initialAmount);
		}
		return false;
	}
	
	private Branch findBranch(String branchName)
	{
		for (int i=0; i<this.branchList.size(); i++)
		{
			Branch branch = this.branchList.get(i);
			if(branch.getBranchName().equals(branchName))
			{
				return branch;
			}
		}
		return null;	
	}
	
	
	public boolean listCustomers(String branchName, boolean showTransactions)
	{
		Branch branch = findBranch(branchName);
		if(branch != null)
		{
			System.out.println("Customers for branch " + branch.getBranchName());
			ArrayList<Customer> branchCustomers = branch.getBranchCustomers();
			for (int i=0; i<branchCustomers.size(); i++)
			{
				Customer branchCustomer = branchCustomers.get(i);
				System.out.println("Customer - " + branchCustomer.getName());
				if(showTransactions){
					System.out.println("Transactions:");
					ArrayList<Double> trnsactions = branchCustomer.getTransactions();
					for(int j=0; j<trnsactions.size(); j++)
					{
						System.out.println("Transaction nunber: "+(j+1)+". Amount: "+ trnsactions.get(j));
					}
				}
			}
			return true;
		}
		else
		{	return false;	}
			
	}
	
	
	
	
/*

	public void addCustomertoParticularBranch(String branchName, String customerName, double initialTransAmount)
	{
		for (int i=0; i< branchList.size(); i++){
			if (branchList.get(i).getBranchName().equals(branchName)){
				this.addCustomertoParticularBranch(customerName, branchName, initialTransAmount);
				break;
			}
		}
	}
	
	public void addTransactionToParticularCustomer(String branchName, String customerName, double transactionAmount)
	{
		for (int i=0; i<= branchList.size(); i++)
		{
			if (branchList.get(i).branchName.equals(branchName))
			{
				for (int j=0; j<= branchList.get(i).getBranchCustomers().size(); j++)
				{
					if (branchList.get(i).getBranchCustomers().get(j).Name.equals(customerName))
					{
						branchList.get(i).getBranchCustomers().get(j).transactions.add(transactionAmount);
						System.out.println("New transaction of "+transactionAmount+" was added to "+customerName+ ", customer of "+branchName);
						break;
					}
				}
			}
			break;
		}
	}
	
	public void showAllBranchCustomers (String branchName)
	{
		for (int i=0; i< branchList.size(); i++)
		{
			if (branchList.get(i).branchName.equals(branchName))
			{
				System.out.println("Please see list of branch customers below:");
				for (int j=0; j< branchList.get(i).getBranchCustomers().size(); j++)	
				{
					System.out.println(branchList.get(i).getBranchCustomers().get(j).Name);
				}
			}
		}
	}
	*/
}
