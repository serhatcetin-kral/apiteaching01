package com.techproed2.javaapi03;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import testBaseClassess.TestBaseHerOkuApp;

public class GetRequest07 extends TestBaseHerOkuApp {
	/*
	  When 
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/5 
	  Then 
		  HTTP Status Code should be 200
		  And response content type is “application/JSON” 
		  And response body should be like; 
		  { 
		  	"firstname": "Susan", 
		    "lastname": "Smith", 
		    "totalprice": 254,
		    "depositpaid": false, 
		    "bookingdates": { "checkin": "2019-07-21", 
		                      "checkout":"2020-02-02" }
		  }
	 */

	@Test
	public void get07() {
		
		spec.pathParams("bookingName","booking","id","5");
		Response response=given().spec(spec).when().get("/{bookingName}/{id}");
		response.prettyPrint();
		
//		response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
//		.body("firstname", equalTo("Jim"),
//				"lastname",equalTo("Wilson"),
//				"totalprice",equalTo(242),
//				"depositpaid",equalTo(true),
//				 "bookingdates.checkin",equalTo("2017-01-08"),
//				 "bookingdates.checkout",equalTo("2019-11-26") );
		
		
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
		
		JsonPath json=response.jsonPath();
		
//	assertEquals("Mark",json.getString("firstname"));
//	assertEquals("Smith",json.getString("lastname"));
//	assertEquals(827,json.getInt("totalprice"));
//	
//	assertEquals(true,json.getBoolean("depositpaid"));
//	assertEquals("2016-09-21",json.getString("bookingdates.checkin"));
//	assertEquals("2019-07-04",json.getString("bookingdates.checkout"));
	
	
	SoftAssert softAssert=new SoftAssert();
	
	
	
	softAssert.assertEquals(json.getString("firstname"), "Sally");
	
	softAssert.assertEquals(json.getString("lastname"),"Jones");
	
	softAssert.assertEquals(json.getInt("totalprice"),763);
	softAssert.assertEquals(json.getBoolean("depositpaid"), true);
	
	
	softAssert.assertEquals(json.getString("bookingdates.checkin"),"2016-11-16" );
	
	softAssert.assertEquals(json.getString("bookingdates.checkout"),"2018-12-12" );
	}
	
	
	
}
