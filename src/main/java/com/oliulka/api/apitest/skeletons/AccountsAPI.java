package com.oliulka.api.apitest.skeletons;

import java.util.ArrayList;

import com.oliulka.api.apitest.skeletons.AccountsAPIFinancialInstitutionInfo;
import com.oliulka.api.apitest.skeletons.AccountsAPIUserInfo;

public class AccountsAPI {
	private String accountType;
	private String id;
	private String updatedAt;
	private String createdAt;
	private String name;
	private String balance;
	private ArrayList<AccountsAPIFinancialInstitutionInfo> financialInstitution;
	private ArrayList<AccountsAPIUserInfo> user;
	
    public AccountsAPI(String accountType, String id, String updatedAt, String createdAt, String name, String balance, ArrayList<AccountsAPIFinancialInstitutionInfo> financialInstitution, ArrayList<AccountsAPIUserInfo> user)
	{
		this.accountType = accountType;
		this.id = id;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.name = name;
		this.balance = balance;
		this.financialInstitution = financialInstitution;
		this.user = user;

	}
	
    public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public ArrayList<AccountsAPIFinancialInstitutionInfo> getFinancialInstitution() {
		return financialInstitution;
	}

	public void setFinancialInstitution(ArrayList<AccountsAPIFinancialInstitutionInfo> financialInstitution) {
		this.financialInstitution = financialInstitution;
	}
	
	public AccountsAPIFinancialInstitutionInfo getFinancialInstitution(int index){
		return financialInstitution.get(index);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public ArrayList<AccountsAPIUserInfo> getUser() {
		return user;
	}
	
	public AccountsAPIUserInfo getUser(int index){
		return user.get(index);
	}

	public void setUser(ArrayList<AccountsAPIUserInfo> user) {
		this.user = user;
	}
	
	 public String toString(){
		 return accountType +"," + id + "," + updatedAt +"," + createdAt + "," + name +"," + balance + "," + financialInstitution + "," + user;
	 }

}