package com.techproed2.javaapi03;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest02 {

	/*
	Negative Scenario
	When 
	I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/1001   
	Then 
	HTTP Status code should be 404
	And
	Status Line should be HTTP/1.1 404 Not Found
	And 
	Response body contains "Not Found"
	And 
	Response body does not contain "TechProEd" 
	*/
	
	@Test
	public void get01() {
		
		//1.step set url
		String url="https://restful-booker.herokuapp.com/booking/1001";
		
		//2.step accepted date
		
		//3.step send url
		Response response=given().accept(ContentType.JSON).when().get(url);
		
		response.prettyPrint();
		
		//4.step make assertion hard assertion if it is fail it can not pass next step
	response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
	System.out.println("=============");
		
//		assertTrue(response.asString().contains("Not Found"));
//		System.out.println("=============");
//		
//		assertFalse(response.asString().contains("TechProEd"));
		
		
		
		
		
		SoftAssert softAssert=new SoftAssert();
		
		softAssert.assertTrue(response.asString().contains("assert"));
		System.out.println("=============");
		softAssert.assertFalse(response.asString().contains("Not Found"));
		
		softAssert.assertAll();
	}
	
	
}

