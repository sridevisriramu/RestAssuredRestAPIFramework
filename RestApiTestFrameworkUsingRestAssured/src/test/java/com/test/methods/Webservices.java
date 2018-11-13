package com.test.methods;

import com.test.utils.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Webservices extends TestBase {

	public static Response Post(String uRI, String stringJSON) {
		RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(uRI);
		return response;

	}

	public static Response Get(String uRI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(uRI);
		return response;

	}

	public static Response Put(String uRI, String stringJSON) {
		RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(uRI);
		return response;

	}

	public static Response Delete(String uRI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(uRI);
		return response;

	}

	public static Response Get2(String baseURI, String endPoint) {
		RestAssured.baseURI = baseURI;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(endPoint);
		return response;

	}

}
