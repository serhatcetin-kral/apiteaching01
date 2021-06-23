package com.techproed2.javaapi03;

import java.util.HashMap;
import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import testBaseClassess.PutRequestBaseClass01;

public class PatchRequest01 extends PutRequestBaseClass01 {
	/*
	   When
	 		I send PATCH Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    "title": "Tidy your room"
										   }
	   Then 
	   	   Status code is 200
	   	   And response body is like  {
									    "userId": 10,
									    "title": "Tidy your room",
									    "completed": true,
									    "id": 198
									  }
	 */

	
	@Test
	public void patch01() {
		
		spec.pathParams("todos","todos","id","198");
HashMap<String,Object> data=new HashMap<String, Object>();
		
		data.put("title","Tidy your room");
		
		Response response=given().contentType(ContentType.JSON).spec(spec)
				.body(data).when().patch("/{todos}/{id}");
		
		response.prettyPrint();	
		
		response.then().assertThat().statusCode(200)
		.body("userId", Matchers.equalTo(10),"id",Matchers.equalTo(198),
				"title",Matchers.equalTo("Tidy your room"),
				"completed",Matchers.equalTo(true));
		
		
		
		
	}
	
	
	
}
