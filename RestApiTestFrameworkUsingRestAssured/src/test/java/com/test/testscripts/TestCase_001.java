package com.test.testscripts;

import java.net.URI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.methods.Webservices;
import com.test.utils.EndPointURL;
import com.test.utils.TestBase;
import com.test.utils.URL;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase_001 extends TestBase {

	Response response;

	@BeforeClass
	public void setup() {

	}

	@Test
	public void verifyGetCountryResponseCode() {
		logger = extent.startTest("Response code test started");
		response = Webservices.Get2(URL.baseURL_2, EndPointURL.GET_COUNTRY_2.getResourcepath());
		Assert.assertEquals(response.getStatusCode(), 200);

		System.out.println(response.body().asString());
		logger.log(LogStatus.PASS, "Response code test passed");
	}

	@Test
	public void verifyGetCountry_ContainsString() {

		logger = extent.startTest("Response string test started");
		response = Webservices.Get2(URL.baseURL_2, EndPointURL.GET_COUNTRY_2.getResourcepath());
		Assert.assertEquals(response.getBody().asString().contains("249"), true);
		logger.log(LogStatus.PASS, "Response String test passed");

	}

	@Test
	public void VerifyJsonPathEvaluatorTest() {

		logger = extent.startTest("REST API test JSON path evluator started");
		response = Webservices.Get2(URL.baseURL_3, EndPointURL.GET_CITY.getResourcepath());
		JsonPath jsonPathEvaluator = response.jsonPath();
		Assert.assertEquals(jsonPathEvaluator.get("City"), "Hyderabad", "Correct city name received in the Response");

		logger.log(LogStatus.PASS, "jsonPathEvaluator test passed");
	}

	@Test
	public void test_get_parseJsonArrayTest() throws JSONException, ParseException {
		logger = extent.startTest("REST API test parseJSONArrayTest started");

		JSONObject jSONResponseBody = null;
		response = Webservices.Get2(URL.baseURL_2, EndPointURL.GET_COUNTRY_2.getResourcepath());

		jSONResponseBody = new JSONObject(response.body().asString());
		JSONObject allKeys = new JSONObject(jSONResponseBody.getString("RestResponse"));
		String resultKey = allKeys.getString("result");
		JSONArray ja = new JSONArray(resultKey);
		JSONObject firstArrayListItem = new JSONObject(ja.get(0).toString());

		Assert.assertEquals("Afghanistan", firstArrayListItem.getString("name"), "name key value is matched");
		Assert.assertEquals("AFG", firstArrayListItem.getString("alpha3_code"), "alpha3_code key value is matched");
		Assert.assertEquals("AF", firstArrayListItem.getString("alpha2_code"), "alpha3_code key value is matched");

		logger.log(LogStatus.PASS, "Parse JSON array test passed");

	}

}
