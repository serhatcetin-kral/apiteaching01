package com.techproed2.javaapi03;

import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest04 {

	
	
	
	/*
	 When 
	 	I send a GET request to REST API URL http://dummy.restapiexample.com/api/v1/employees   
	    And Accept type is “application/JSON”
	 Then 
	    HTTP Status Code should be 200
	    And Response format should be "application/JSON"
	    And there should be 24 employees
	    And "Ashton Cox" should be one of the employees
	    And 21, 61, and 23 should be among the employee ages
*/

	@Test
	public void get04() {
		
		//1.step set url
		String url="http://dummy.restapiexample.com/api/v1/employees";
		//2.step accepted data
		
		//3.step send url
		
		Response response=given().accept(ContentType.JSON).when().get(url);
		response.prettyPrint();
		
		//4.step make assertion
		
		response.then().assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.body("data.id", Matchers.hasSize(24),
			"data.employee_name",Matchers.hasItem("Ashton Cox"),
			"data.employee_age",Matchers.hasItems("21","61","23"));
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
