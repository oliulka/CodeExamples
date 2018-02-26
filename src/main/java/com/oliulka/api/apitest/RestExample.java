package com.oliulka.api.apitest;

import org.testng.annotations.Test;
import com.jayway.restassured.*;
import static com.jayway.restassured.RestAssured.given;

public class RestExample extends RESTBase {
	
	@Test
	public void FirstTest()
	{
		given().when().get("https://www.google.com/").then().statusCode(200);
		System.out.println("Success!!!");
	}

}
