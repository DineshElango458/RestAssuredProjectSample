package com.test;

import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.endpoints.Endpoints;
import com.pojo.UserPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class User {
  
 
	
	@Test
	public  void postUser()
	{
		
		UserPojo data = new UserPojo();
		data.setId(1);
		data.setUsername("dinesh");
		data.setFirstName("john");
		data.setLastName("cena");
		data.setEmail("abc@gmail.com");
		data.setPhone("3435363737");
		data.setPassword("abc");
		data.setUserStatus(2);
		
		
		
		Response post = RestAssured.given().header("accept", "application/json").header("Content-Type","application/json")
		.body(data).when().post(Endpoints.Post);
		
		int statusCode = post.getStatusCode();
		System.out.println("status is "+ statusCode);
		Assert.assertEquals(statusCode, 200);
		//int id = post.jsonPath().getInt("id");
		//System.out.println("id value is "+ id);
		String asPrettyString = post.getBody().asPrettyString();
		System.out.println(asPrettyString);
	//	ResponseBody body = post.body();
		//String asString = body.asString();
	//System.out.println(asString);	
		
  //  Assert.assertEquals(asPrettyString.contains("unknown"), true , "Code is present");
		
	  String string = post.jsonPath().get("type").toString();
	  
	  Assert.assertEquals(string.equals("unknown"), true);

		
		
		
		
		
		
	}
	
	

}
