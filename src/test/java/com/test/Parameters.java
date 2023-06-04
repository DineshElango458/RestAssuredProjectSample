package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Parameters {
	
	
	@Test
    void pathParam() {
	 Response response = RestAssured.given().pathParam("key", "users").queryParam("page", 2).when().get("https://reqres.in/api/{key}");
	// int id = response.jsonPath().getInt("id");
	// System.out.println("id valuse is "+id);
	 int statusCode = response.getStatusCode();
	 System.out.println(statusCode);
	 
	 String string = response.jsonPath().get("data[1].id").toString();
	 System.out.println("string id value"+ string);
	 
	 
//	 JSONObject js = new JSONObject();
 }
	
	
	

}




