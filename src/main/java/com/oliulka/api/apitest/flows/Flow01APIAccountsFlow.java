package com.oliulka.api.apitest.flows;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import com.jayway.restassured.response.Response;
import com.oliulka.api.apitest.skeletons.AccountsAPI;
import com.oliulka.api.apitest.skeletons.AccountsAPIFinancialInstitutionInfo;
import com.oliulka.api.apitest.skeletons.AccountsAPIUserInfo;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Flow01APIAccountsFlow  
{
	private final static Logger logger = Logger.getLogger(Flow01APIAccountsFlow.class.getName());

	public static String resp = null;
	public static String POSTAccountIDResponse = null;
	public static String DeleteAccountResponse = null;
	public static ArrayList<AccountsAPI> accountsAPI = new ArrayList<AccountsAPI>();
	
	String accountsUrl = "";

	
	/******************************Start: Preparation Test: GET JWT**************************************************/
	
    public void TestGetAccountsJWT()
    {
//		String JWT = "";
//       Response response = given().header("content-type", "application/json")
//        		.get(accountsUrl);
//        assertEquals(response.getStatusCode(),200);
//       resp =  response.asString();
//		logger.info("Was able to GET Accounta JWT");                          
    }
    
	/*****************************End: Preparation Test: GET JWT******************************************************/
	/********************************Start: Test 1: POST Account******************************************************/
	
	public String TestPOSTAccount()
	{
		String JWT = "extract";
		String accountBody =  "Excell referemce";
		Response response = given()
				.header("Content-Type", "application/json")
				.header("X-Consumer-Service-Token", JWT)
				.body(accountBody)
				.post("http://applicationURL/accounts/");
		
		assertEquals(response.getStatusCode(),200);
		POSTAccountIDResponse =  response.asString();	
		logger.info("Was able to POST New Account - "+POSTAccountIDResponse);
		return POSTAccountIDResponse;
	}
	
	/**************************End: Test 1: POST Account **************************************************************/
	/******************************Start: Test 2: GET and Assert Created Account***************************************/
	public String TestGETCreatedAccount(String accountIDResponse)
	{	
		String JWT = "extract";
		Response response = given()
				.header("Content-Type", "application/json")
				.header("X-Consumer-Service-Token", JWT)
				.get("http:/applicationURL/accounts/?id="+ accountIDResponse);
		
		assertEquals(response.getStatusCode(),200);
		resp =  response.asString();	
		logger.info("Was able to GET Created Account");
		return resp;
	}
	
	public ArrayList<AccountsAPI> TestConvertCreatedAccount(String account) throws InterruptedException, JSONException
	{
		if(!account.startsWith("["))
		{
			account = "[" + account + "]";
		}
		JSONArray accountarray = new JSONArray(account);
		for (int j = 0; j < accountarray.length(); j ++)
		{
			JSONObject budgetobject = accountarray.getJSONObject(j);
			String accountType = budgetobject.get("accountType").toString();
			String id = budgetobject.get("id").toString();
			String updatedAt = budgetobject.get("updatedAt").toString();
			String createdAt = budgetobject.get("createdAt").toString();
			String name = budgetobject.get("name").toString();
			String balance = budgetobject.get("balance").toString();
			String financialInstitution = budgetobject.get("financialInstitution").toString();
			String user = budgetobject.get("user").toString();
			
/******* financialInstitution ******/			
			if(!financialInstitution.startsWith("["))
			{
				financialInstitution = "[" + financialInstitution + "]";
			}
			JSONArray financialInstitutionarray = new JSONArray(financialInstitution);
			ArrayList<AccountsAPIFinancialInstitutionInfo> financialInstitutionSection = new ArrayList<AccountsAPIFinancialInstitutionInfo>();
			for (int n = 0; n < financialInstitutionarray.length(); n ++)
			{
				JSONObject financialInstitutionObject = financialInstitutionarray.getJSONObject(n);
				String financialInstitutionId = financialInstitutionObject.get("id").toString();
				String financialInstitutionUpdatedAt = financialInstitutionObject.get("updatedAt").toString();
				String financialInstitutionCreatedAt = financialInstitutionObject.get("createdAt").toString();
				String financialInstitutionName = financialInstitutionObject.get("name").toString();
				String financialInstitutionURL = financialInstitutionObject.get("url").toString();
				
				
				financialInstitutionSection.add(new AccountsAPIFinancialInstitutionInfo(financialInstitutionId, financialInstitutionUpdatedAt, financialInstitutionCreatedAt, financialInstitutionName, 
						financialInstitutionURL));
			}	
/******* user ******/
			if(!user.startsWith("["))
			{
				user = "[" + user + "]";
			}
			JSONArray userarray = new JSONArray(user);
			ArrayList<AccountsAPIUserInfo> userSection = new ArrayList<AccountsAPIUserInfo>();
			for (int n = 0; n < userarray.length(); n ++)
			{
				JSONObject userObject = userarray.getJSONObject(n);
				String userId = userObject.get("id").toString();
				String userUpdatedAt = userObject.get("updatedAt").toString();
				String userCreatedAt = userObject.get("createdAt").toString();

				userSection.add(new AccountsAPIUserInfo(userId, userUpdatedAt, userCreatedAt));
			}
			
			accountsAPI.add(new AccountsAPI(accountType, id, updatedAt, createdAt, name, balance,  financialInstitutionSection, userSection));
		}
		logger.info("Was able to convert created Account API Response to Java Object");		
		return accountsAPI;
	}
	
	public void TestAssertCreatedAccount() throws JSONException
	{
		if(!resp.startsWith("["))
		{
			resp = "[" + resp + "]";
		}
		JSONArray responsearray = new JSONArray(resp);
		for (int i = 0; i < responsearray.length(); i ++)
		{
			assertEquals(accountsAPI.get(i).getAccountType(), "");
			assertEquals(accountsAPI.get(i).getId(), "");
			assertEquals(accountsAPI.get(i).getUpdatedAt(), "");
			assertEquals(accountsAPI.get(i).getCreatedAt(), "");
			assertEquals(accountsAPI.get(i).getName(), "");
			assertEquals(accountsAPI.get(i).getBalance(), "");
							
			assertEquals(accountsAPI.get(i).getFinancialInstitution(0).getId(), "");
			assertEquals(accountsAPI.get(i).getFinancialInstitution(0).getUpdatedAt(), "");
			assertEquals(accountsAPI.get(i).getFinancialInstitution(0).getCreatedAt(), "");
			assertEquals(accountsAPI.get(i).getFinancialInstitution(0).getName(), "");
			assertEquals(accountsAPI.get(i).getFinancialInstitution(0).getUrl(), "");
			
			assertEquals(accountsAPI.get(i).getUser(0).getId(), "");
			assertEquals(accountsAPI.get(i).getUser(0).getUpdatedAt(), "");
			assertEquals(accountsAPI.get(i).getUser(0).getCreatedAt(), "");
	
		}
		logger.info("Was able to assert created Account API Successfully");	
	}
	
	/********************************End: Test 2: GET and Assert Created Account********************************************/
	/******************************Start: Test 3: PUT and Assert Updated Account********************************************/
	public String TestUpdateCreatedAccount(String accountResponse)
	{	
		
		/// do we need JWT to puT??
		String JWT = "extract";
		String updateBody = "Excell reference";
		Response response = given()
				.header("Content-Type", "application/json")
				.header("X-Consumer-Service-Token", JWT)
				.body(updateBody)
				.put("http://applicationURL/accounts/");
		
		assertEquals(response.getStatusCode(),200);
		resp =  response.asString();	
		logger.info("Was able to PUT into Created Account");
		return resp;
	}
	
	public ArrayList<AccountsAPI> TestConvertUpdatedAccount(String putAccountResponse) throws InterruptedException, JSONException
	{
		if(!putAccountResponse.startsWith("["))
		{
			putAccountResponse = "[" + putAccountResponse + "]";
		}
		JSONArray accountarray = new JSONArray(putAccountResponse);
		for (int j = 0; j < accountarray.length(); j ++)
		{
			JSONObject budgetobject = accountarray.getJSONObject(j);
			String accountType = budgetobject.get("accountType").toString();
			String id = budgetobject.get("id").toString();
			String updatedAt = budgetobject.get("updatedAt").toString();
			String createdAt = budgetobject.get("createdAt").toString();
			String name = budgetobject.get("name").toString();
			String balance = budgetobject.get("balance").toString();
			String financialInstitution = budgetobject.get("financialInstitution").toString();
			String user = budgetobject.get("user").toString();
			
			/******* financialInstitution ******/			
			if(!financialInstitution.startsWith("["))
			{
				financialInstitution = "[" + financialInstitution + "]";
			}
			JSONArray financialInstitutionarray = new JSONArray(financialInstitution);
			ArrayList<AccountsAPIFinancialInstitutionInfo> financialInstitutionSection = new ArrayList<AccountsAPIFinancialInstitutionInfo>();
			for (int n = 0; n < financialInstitutionarray.length(); n ++)
			{
				JSONObject financialInstitutionObject = financialInstitutionarray.getJSONObject(n);
				String financialInstitutionId = financialInstitutionObject.get("id").toString();
				String financialInstitutionUpdatedAt = financialInstitutionObject.get("updatedAt").toString();
				String financialInstitutionCreatedAt = financialInstitutionObject.get("createdAt").toString();
				String financialInstitutionName = financialInstitutionObject.get("name").toString();
				String financialInstitutionURL = financialInstitutionObject.get("url").toString();
				
				
				financialInstitutionSection.add(new AccountsAPIFinancialInstitutionInfo(financialInstitutionId, financialInstitutionUpdatedAt, financialInstitutionCreatedAt, financialInstitutionName, 
						financialInstitutionURL));
			}	
			/******* user ******/
			if(!user.startsWith("["))
			{
				user = "[" + user + "]";
			}
			JSONArray userarray = new JSONArray(user);
			ArrayList<AccountsAPIUserInfo> userSection = new ArrayList<AccountsAPIUserInfo>();
			for (int n = 0; n < userarray.length(); n ++)
			{
				JSONObject userObject = userarray.getJSONObject(n);
				String userId = userObject.get("id").toString();
				String userUpdatedAt = userObject.get("updatedAt").toString();
				String userCreatedAt = userObject.get("createdAt").toString();

				userSection.add(new AccountsAPIUserInfo(userId, userUpdatedAt, userCreatedAt));
			}
			
			accountsAPI.add(new AccountsAPI(accountType, id, updatedAt, createdAt, name, balance,  financialInstitutionSection, userSection));
		}
		logger.info("Was able to convert updated Account API Response to Java Object");		
		return accountsAPI;
	}
	
	public void TestAssertUpdatedAccount() throws JSONException
	{
		if(!resp.startsWith("["))
		{
			resp = "[" + resp + "]";
		}
		JSONArray responsearray = new JSONArray(resp);
		for (int i = 0; i < responsearray.length(); i ++)
		{
			assertEquals(accountsAPI.get(i).getAccountType(), "");
			assertEquals(accountsAPI.get(i).getId(), "");
			assertEquals(accountsAPI.get(i).getUpdatedAt(), "");
			assertEquals(accountsAPI.get(i).getCreatedAt(), "");
			assertEquals(accountsAPI.get(i).getName(), "");
			assertEquals(accountsAPI.get(i).getBalance(), "");
							
			assertEquals(accountsAPI.get(i).getFinancialInstitution(0).getId(), "");
			assertEquals(accountsAPI.get(i).getFinancialInstitution(0).getUpdatedAt(), "");
			assertEquals(accountsAPI.get(i).getFinancialInstitution(0).getCreatedAt(), "");
			assertEquals(accountsAPI.get(i).getFinancialInstitution(0).getName(), "");
			assertEquals(accountsAPI.get(i).getFinancialInstitution(0).getUrl(), "");
			
			assertEquals(accountsAPI.get(i).getUser(0).getId(), "");
			assertEquals(accountsAPI.get(i).getUser(0).getUpdatedAt(), "");
			assertEquals(accountsAPI.get(i).getUser(0).getCreatedAt(), "");
	
		}
		logger.info("Was able to assert updated Account API Successfully");	
	}
	
	/********************************End: Test 3: PUT and Assert Updated Account***********************************/
	/******************************Start: Test 4: DELETE specific Account******************************************/
	
	public void TestDELETESpecificAccount(String accountIDResponse)
	{
		String JWT = "extract";
		Response response = given()
				.header("Content-Type", "application/json")
				.header("X-Consumer-Service-Token", JWT)
				.delete("http://applicationURL/accounts/delete?id="+ accountIDResponse);
		
		assertEquals(response.getStatusCode(),200);
		logger.info("Was able to assert updated Account API Successfully");	

	}
    
	/**********************************End: Test 4: DELETE specific Account***************************************/

	
}

