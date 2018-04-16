package com.oliulka.oop.arrays.bank;

import java.util.ArrayList;

public class Branch {

	private ArrayList<Customer> branchCustomers;
	private String branchName;

	
	public Branch(String branchName) {
		this.branchName = branchName;
		this.branchCustomers = new ArrayList<Customer>();
	}

	public String getBranchName() {
		return branchName;
	}
	
	public ArrayList<Customer> getBranchCustomers() {
		return branchCustomers;
	}
	
	
    public boolean newCustomer(String customerName, double initialAmount) {
        if(findCustomer(customerName) == null) {
            this.branchCustomers.add(new Customer(customerName, initialAmount));
            System.out.println("New customer " + customerName +" was added successfully");
            return true;
        }

        return false;
    }
    
    private Customer findCustomer(String customerName) 
    {
    	if(this.branchCustomers.size()>0)
    	{
		   for(int i=0; i<this.branchCustomers.size(); i++) 
		   {
			   Customer checkedCustomer = this.branchCustomers.get(i);
			   if(checkedCustomer.getName().equals(customerName)) {
			   return checkedCustomer; }
		   }
    	}
       return null;
    }
	

	
	public boolean addTransaction (String Name, double transactionAmount)
	{
		for (int i=0; i<getBranchCustomers().size(); i++)
		{
			if (getBranchCustomers().get(i).getName().equals(Name))
			{
				this.getBranchCustomers().get(i).addTransaction(transactionAmount);
				System.out.println("New transaction was added to customer "+Name);
				return true;
			}
			if (i == getBranchCustomers().size())
			{
				System.out.println("Customer was not found in this branch!");
			}
		}
		return false; 
	}




}
