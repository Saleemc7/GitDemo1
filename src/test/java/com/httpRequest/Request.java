package com.httpRequest;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class Request {
	int id;
	
	//1. get request
	
	@Test(priority =0)
	void getusers() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
	}
	
//	//2. post request
	@Test(priority =1)
	void creatUser() {
		HashMap data = new HashMap();
		data.put("name", "Saleem");
		data.put("job", "Tester");
		
		id=given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
	
	}
//		
//	@Test(priority =2, dependsOnMethods= {"creatUser"}) 
//	void updateuser() {
//		
//		HashMap data = new HashMap();
//		data.put("name", "Sam");
//		data.put("job", "Developer");
//		
//		given()
//		.contentType("application/json")
//		.body(data)
//		.when()
//		.put("https://reqres.in/api/users/2")
//		.then()
//		.statusCode(200)
//		.log().all();
//		
//	}
//	@Test(priority =3)
//	void delete() {
//		
//		given()
//		.when().delete("https://reqres.in/api/users/2")
//		.then()
//		.statusCode(204)
//		.log().all();
//			
//	}
//	

}
