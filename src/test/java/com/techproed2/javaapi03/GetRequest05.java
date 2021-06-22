package com.techproed2.javaapi03;

import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import testBaseClassess.TestBasePlaceHolder;

public class GetRequest05 extends TestBasePlaceHolder{

	/*
 	When 
   		I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos/123
    Then 
   		HTTP Status Code should be 200
	    And "Server" in Headers should be "cloudflare"
	    And response content type is “application/JSON”
	    And "userId" should be 7,
	    And "title" should be "esse et quis iste est earum aut impedit"
		And "completed" should be false
 */

	@Test
	public void get05() {
		//set url
		
		
		spec.pathParams("todosName","todos","id","123");
		//spec.pathParam("todosName", "todos").pathParam("id","123");
		//send url
		Response response=given().spec(spec).when().get("/{todosName}/{id}");
		
		response.prettyPrint();		
		
		
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.header("Server", "cloudflare")
		.body("userId", Matchers.equalTo(7),"title",Matchers.equalTo("esse et quis iste est earum aut impedit"));
		
		
		
		
		
		
	}
	
	
	
	
	
}
