package com.oliulka.oop.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.

public class MobilePhone {
	
	Scanner inputChoice = new Scanner(System.in);
	Scanner inputName = new Scanner(System.in);
	Scanner inputPhone = new Scanner(System.in);
	ArrayList<Contact> contactsArray = new ArrayList<Contact>();
	
	public void SelectYourOption(){
		boolean quit = false;
		
		System.out.println("Hello. Please select one of the options below:" +"\n"+
				 "1. Print All" +"\n"+
				 "2. Search for Contact" +"\n"+
				 "3. Add a Contact" +"\n"+
				 "4. Update contact" +"\n"+
				 "5. Remove contact" +"\n"+
				 "6. Quit...");
		while(!quit)
		{
			System.out.println("Please enter your selection:");
			String choice = inputChoice.nextLine();
			switch (choice)
			{
				case "1": 
					System.out.println("Printing all contacts");
					printAllContact();
					System.out.println("THIS ACTION IS OVER");
					break;
				case "2":
					System.out.println("Searching for a contact");
					System.out.println("Please enter your contact name:");
					String contactName = inputName.nextLine(); 
					searchForContact(contactName);
					System.out.println("THIS ACTION IS OVER");
					break;
				case "3":
					System.out.println("Adding Contact");
					System.out.println("Please enter your contact name:");
					String contactName3 = inputName.nextLine(); 
					System.out.println("Please enter your contact phone number:");
					String contactPhoneNumber = inputPhone.nextLine();
					addContact(contactName3, contactPhoneNumber);
					System.out.println("THIS ACTION IS OVER");
					break;
				case "4":
					System.out.println("Updating Contact");
					System.out.println("Please enter your contact name:");
					String contactName4 = inputName.nextLine(); 
					System.out.println("Please enter your contact phone number:");
					String mycontactPhoneNumber = inputPhone.nextLine();
					updateContact(contactName4, mycontactPhoneNumber);
					System.out.println("THIS ACTION IS OVER");
					break;
				case "5": 
					System.out.println("Removing Contact");
					System.out.println("Please enter your contact name:");
					String contactName5 = inputName.nextLine(); 
					removeContact(contactName5);
					System.out.println("THIS ACTION IS OVER");
					break;
				case "6": 
					System.out.println("Quiting...");
					quit= true;
					System.out.println("THIS ACTION IS OVER");
				default: 
					break;
			}	
		}
	}
	
	
	public void addContact(String name, String phoneNumber)
	{
		boolean isContactNew = true;
		for(int i=0; i < contactsArray.size(); i++)
		{
			if(contactsArray.get(i).name == name){
				isContactNew = false;
			}
		}	
		if (isContactNew)
		{
			Contact newContact = new Contact (name, phoneNumber); 
			contactsArray.add(newContact);
		}
		else
		{
			System.out.println("We already have a contact with that name in a list");;
		}
	}
	
	public void updateContact(String name, String phoneNumber)
	{
		for(int i=0; i < contactsArray.size(); i++)
		{
			if(contactsArray.get(i).name.contains(name)){
				contactsArray.get(i).phoneNumber = phoneNumber;
				System.out.println("Contact was updated successfully");
			}
		}	
	}
	
	public void printAllContact()
	{
		for(int i=0; i < contactsArray.size(); i++)
		{
			System.out.println((i+1)+ ". " +contactsArray.get(i).name +", "+contactsArray.get(i).phoneNumber);
		}
	}
	
	public void removeContact(String name)
	{
		for(int i=0; i < contactsArray.size(); i++)
		{
			if (contactsArray.get(i).name.contains(name)){
				contactsArray.remove(i);
				System.out.println("Contact was removed");
			}
		}
	}
	
	public void searchForContact(String name)
	{
		for(int i=0; i < contactsArray.size(); i++)
		{
			if (contactsArray.get(i).name.contains(name)){
				System.out.println("Contact was found - "+ contactsArray.get(i).name+", "+ contactsArray.get(i).phoneNumber );
			}
		}
	}
	
}
