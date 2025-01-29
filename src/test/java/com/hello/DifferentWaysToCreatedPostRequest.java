package com.hello;


import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.internal.support.FileReader;

public class DifferentWaysToCreatedPostRequest extends Pojo_PostRequest{
	
	//using hashmap we can created request body
//	@Test
//	void testPostusingHashmap() {
//		HashMap data = new HashMap();
//		data.put("name","saleem");
//		data.put("location","chennai");
//		data.put("phone","1234");
//		String courseArr[]= {"c","c++"};
//		data.put("Courses", courseArr);
//		
//		given()
//		.contentType("application/json")
//		.body(data)
//		.when()
//		.post("https://reqres.in/api/users")
//		.then()
//		.statusCode(201)
//		.body("name", equalTo("saleem"))
//		.body("location",equalTo("chennai"))
//		.body("phone",equalTo("1234"))
//		.body("Courses[0]",equalTo("c"))
//		.body("Courses[1]",equalTo("c++"))
//		.log().all();
//		
//	}
	
	//2.By using org.json
	
//	@Test(priority = 0)
//	void TestPostusingJsonLib() {
//		JSONObject data = new JSONObject();
//		data.put("name","saleem");
//		data.put("location","chennai");
//		data.put("phone","1234");
//		String courseArr[]= {"c","c++"};
//		data.put("Courses", courseArr);
//		
//		given()
//		.contentType("application/json")
//		.body(data.toString())
//		.when()
//		.post("https://reqres.in/api/users")
//		.then()
//		.statusCode(201)
//		.body("name", equalTo("saleem"))
//		.body("location",equalTo("chennai"))
//		.body("phone",equalTo("1234"))
//		.body("Courses[0]",equalTo("c"))
//		.body("Courses[1]",equalTo("c++"))
//		.log().all();		
//		
//	}
	
	//3. By using pojo class(plan old java object)
//	@Test
//	void testPostusingPojo() {
//		Pojo_PostRequest data= new Pojo_PostRequest();
//		
//		
//		data.setName("saleem");
//		data.setLocation("chennai");
//		data.setPhone("12345");
//		String courseArr[]= {"c","c++"};
//		data.setCourse(courseArr);
//		
//		given()
//		.contentType("application/json")
//		.body(data)
//		.when()
//		.post("https://reqres.in/api/users")
//		.then()
//		.statusCode(201)
//		.body("name", equalTo("saleem"))
//		.body("location",equalTo("chennai"))
//		.body("phone",equalTo("12345"))
//		.body("course[0]",equalTo("c"))
//		.body("course[1]",equalTo("c++"))
//		.log().all();
		
	}
	
	//4. using an external json 
	@Test 
	void testUsingExternalJsonFile() throws FileNotFoundException {
		
		File f= new File(".\\body.json");
		
		FileReader fr= new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.body("name", equalTo("saleem"))
		.body("location",equalTo("chennai"))
		.body("phone",equalTo("12345"))
		.body("courses[0]",equalTo("c"))
		.body("courses[1]",equalTo("c++"))
		.log().all();
	}
	
	
	

}
