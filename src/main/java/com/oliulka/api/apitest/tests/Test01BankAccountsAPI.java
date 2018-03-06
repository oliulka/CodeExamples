package com.oliulka.api.apitest.tests;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.oliulka.api.apitest.flows.*;

@Test(singleThreaded = true)
public class Test01BankAccountsAPI
{
	
	//Following Test implement simple example of API test set where we POST, GET, PUT and DELETE Bank account
	//Structure of the testing contains 3 different packages:
	//com.oliulka.api.apitest.skeletons - the contains skeletons of API for nested Accounts API as well as Fin Institution and UserIfo API's
	//com.oliulka.api.apitest.flows - that contains flow of the test and perform main actions and assertions
	//com.oliulka.api.apitest.tests - that contains actual tests performed on API
	//The goad of the test is to demonstrate basic actions/tests performed on API. API URL's are fictional.
	
	//-------------------------------------------Start: Preparation Tests-----------------------------------------------//
	@Test(enabled=true, priority=1)
	public void TestGETJWT(Method method) throws InterruptedException, FileNotFoundException, JSONException 
	{
		Flow01APIAccountsFlow flow52 = new Flow01APIAccountsFlow();
		flow52.TestGetAccountsJWT();
	}
	//---------------------------------------------End: Preparation Tests-----------------------------------------------//
	//-------------------------------------------Start: POST Account----------------------------------------------------//
	@Test(enabled=true, priority=2)
	public void TestPOSTAccount(Method method) throws InterruptedException, FileNotFoundException, JSONException, ClassNotFoundException, SQLException 
	{
		Flow01APIAccountsFlow flow52 = new Flow01APIAccountsFlow();
		flow52.TestPOSTAccount();
	}
	//---------------------------------------------End: POST Account----------------------------------------------------//
	//-------------------------------------------Start: GET Account-----------------------------------------------------//
	@Test(enabled=true, priority=3)
	public void TestGETAccount(Method method) throws InterruptedException, FileNotFoundException, JSONException, ClassNotFoundException, SQLException 
	{
		String resp2 = "";
		Flow01APIAccountsFlow flow52 = new Flow01APIAccountsFlow();
		String resp = flow52.TestGETCreatedAccount(resp2);
		flow52.TestConvertCreatedAccount(resp);
		flow52.TestAssertCreatedAccount();
	}
	//---------------------------------------------End: GET Account-----------------------------------------------------//
	//----------------------------------------Start: Update Account-----------------------------------------------------//
	@Test(enabled=true, priority=4)
	public void TestPUTAccount(Method method) throws InterruptedException, FileNotFoundException, JSONException, ClassNotFoundException, SQLException 
	{
		String resp2 = "";
		Flow01APIAccountsFlow flow52 = new Flow01APIAccountsFlow();
		String resp = flow52.TestUpdateCreatedAccount(resp2);
		flow52.TestConvertUpdatedAccount(resp);
		flow52.TestAssertUpdatedAccount();
	}
	//------------------------------------------End: Update Account-----------------------------------------------------//
	//----------------------------------------Start: DELETE Account-----------------------------------------------------//
	@Test(enabled=true, priority=5)
	public void TestDELETEAccount(Method method) throws InterruptedException, JSONException, ClientProtocolException, ClassNotFoundException, IOException, SQLException 
	{
		String accountIDResponse1 = "";
		Flow01APIAccountsFlow flow52 = new Flow01APIAccountsFlow();
		flow52.TestDELETESpecificAccount(accountIDResponse1);

	}
	//------------------------------------------End: DELETE Account-----------------------------------------------------//

}

