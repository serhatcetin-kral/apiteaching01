package com.techproed2.javaapi03;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import testBaseClassess.BaseUrlDelete;

public class DeleteRequest01 extends BaseUrlDelete {
	/*
 	When
 		I send DELETE Request to the Url http://dummy.restapiexample.com/api/v1/delete/2	 		
 	Then 
	 	Status code is 200
	 	And Response body is {
							    "status": "success",
							    "data": "2",
							    "message": "message"
							 }	
 */

	@Test
	public void delete01() {
		
		spec.pathParams("api","api","version","v1","delete","delete","id","2");
		
		Response response=given().spec(spec).when().delete("/{api}/{version}/{delete}/{id}");
		response.prettyPrint();
		
		
		
	}
	
	
}
