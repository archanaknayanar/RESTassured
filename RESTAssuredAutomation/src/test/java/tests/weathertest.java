package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class weathertest {
	
	@Test
	public void test_1() {
		baseURI = "https://demoqa.com/utilities/weather/city";
		Response response = given().get("/Hyderabad");
		//Print the body of the message 
		String responseBody = response.getBody().asString();
		System.out.println("Response body is" + responseBody);
		
		
		
		
	}
	

}
