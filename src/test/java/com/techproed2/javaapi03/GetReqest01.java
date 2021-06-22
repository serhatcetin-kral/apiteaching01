package com.techproed2.javaapi03;

import org.junit.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetReqest01 {

	
	/*
 	Gherkin Language: 
 	Given: It declares prerequisetes 
 	When: It defines the action which user will perform
 	Then: Talk about outputs
 	And: It can be used in "Given", "When", "Then", if you have multiple options
 */

/*
 	 When 
	     I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/3    
	 Then 
	     HTTP Status Code should be 200
	 And  
	     Content Type should be in JSON Format
	 And  
	     Status Line should be HTTP/1.1 200 OK
*/

	@Test
	public void get01() {
		
		//1.step set url
		String url="https://restful-booker.herokuapp.com/booking/3";
		
		
		//2.step set accepted data
		
		//3.step send request api
		
		Response response=given().accept("application/json").when().get(url);
		
		response.prettyPrint();
		
		//4.step make assertion
		response.then().
		assertThat().
		statusCode(200).
		contentType(ContentType.JSON).and()
		.statusLine("HTTP/1.1 200 OK");
		
		
		//how print statuscode, statusline,,content type on console
		
		System.out.println("========================");
		System.out.println("========================");
		System.out.println("status code:"+response.getStatusCode());
		System.out.println("========================");
		System.out.println("content type:"+response.getContentType());
		System.out.println("========================");
		System.out.println("status line:"+response.getStatusLine());
		
		System.out.println("========================");
		System.out.println("headers:"+response.getHeaders());
		System.out.println("========================");
		System.out.println("========================");
		
		System.out.println("date of headers:"+response.getHeader("Date"));
		System.out.println("========================");
		System.out.println("========================");
		
		System.out.println("server :"+response.getHeader("Server"));
		
	}
	
	
	
	
	
	
	
	
	
	
}
