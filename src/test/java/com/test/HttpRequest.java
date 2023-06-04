package com.test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HttpRequest {

	int id;
	
	@Test(priority=1)
	public void  getUser() {

		Response response = RestAssured.given().when().get("https://reqres.in/api/users/2");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

	}
	@Test(priority=2)
	void getlistUser() {

		Response response = RestAssured.given().when().get("https://reqres.in/api/users?page=2");
		String asPrettyString = response.getBody().asPrettyString();
		System.out.println(asPrettyString);
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

	}
	@Test(priority=3)
	void postUser() {

		HashMap mp = new HashMap();
		mp.put("name", "morpheus");
		mp.put("job", "leader");


		Response post = RestAssured.given().contentType("application/json").body(mp)
				.when().post("https://reqres.in/api/users");
		int statusCode = post.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 201);
		 id = post.jsonPath().getInt("id");
		 String asPrettyString = post.getBody().asPrettyString();
		 System.out.println(asPrettyString);
		
	}
	@Test(priority=4,dependsOnMethods= {"postUser"})
	void updateUser() {

		HashMap mp = new HashMap();
		mp.put("name", "morpheus");
		mp.put("job", "it");


		Response post = RestAssured.given().contentType("application/json").body(mp)
				.when().put("https://reqres.in/api/users/"+id);
		int statusCode = post.getStatusCode();
		System.out.println(statusCode);
		String asPrettyString = post.getBody().asPrettyString();
		System.out.println(asPrettyString);
		Assert.assertEquals(statusCode, 200);

	}
	@Test(priority=5)
	void deleteUser()
	{
		Response post = RestAssured.given().when().delete("https://reqres.in/api/users/"+id);
		int statusCode = post.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 204);
	
	}

}
