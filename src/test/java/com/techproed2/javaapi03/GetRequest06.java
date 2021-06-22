package com.techproed2.javaapi03;

import static org.junit.Assert.assertTrue;

import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import testBaseClassess.TestBaseHerOkuApp;

public class GetRequest06 extends TestBaseHerOkuApp{

	
	/*
 	When 
  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking
  	 Then
  		Among the data there should be someone whose first name is "Susan" and last name is "Smith"
*/

	@Test
	public void get06() {
		
		
		spec.pathParam("bookingName","booking" )
		.queryParams("firstname","Susan","lastname","Smith");
		
		Response response=given().spec(spec).when().get("/{bookingName}");
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200);//.body("bookingid",Matchers.equalTo(2));
		
		assertTrue(response.asString().contains("bookingid"));
		
		
		
	}
	
}
