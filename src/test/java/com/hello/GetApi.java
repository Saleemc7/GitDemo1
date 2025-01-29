package com.hello;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class GetApi {
//	public static void main(String[] args) {
//		getusers();
//	}
	@Test(priority =0)
	void getusers() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
		System.out.println("hello");
	}

}
