package com.techproed2.javaapi03;

import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Data;
import testBaseClassess.PostRequestBaseUrl;

public class PostRequest01 extends PostRequestBaseUrl{

	/*
 	POST Request is used to create new data in database.
 	
 	For POST Request we need;
 	1)POST Method
 	2)URL
 	3)Request body
*/

/*
 	When
 	  	I send a POST Request to the Url http://dummy.restapiexample.com/api/v1/create
 	  	by using the following Request Body {
											    "name":"bill",
											    "salary":1000,
											    "age":35,
											    "department": "it"
											}
 	 Then 
 	  	Status code is 200
 	  	And response body should be like { "status": "success",
 "data": {
 "name": "bill",
 "salary": "1000",
 "age": "33",
 "department": "it"
										    },
 "message": "Successfully! Record has been added."
										 }
*/
    @Test
	public void post01() {
		
		
		spec.pathParams("api","api","version","v1","create","create");
		
//		Data data=new Data();
//		
//		data.setName("bill");
//		data.setAge(35);
//		data.setDepertmant("it");
//		data.setSalary(1000);
		
		//Data data=new Data(0,"Bill",1000,"it",35);
		
		HashMap<String,Object> data=new HashMap<String, Object>();
		
		data.put("name","Bill");
		data.put("salary",1000);
		data.put("age", 35);
		data.put("depertmant", "it");
		
		Response response=given().contentType(ContentType.JSON).spec(spec)
			.auth().basic("admin", "password123")
				.body(data)
				.when().post("/{api}/{version}/{create}");
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200)
		.body("data.name",Matchers.equalTo("Bill"),"data.age",Matchers.equalTo(35)
				,"data.salary",Matchers.equalTo(1000)
				,"data.depertmant",Matchers.equalTo("it"));
		
	}
	
    
    
    
    
    
    
    
    
    
	
	
}
