package tests;

import static io.restassured.RestAssured.*;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDeleteExample {

	@Test
	public void testPut() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Archana");
		request.put("job", "quality analyst");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
		
		given().
		 header("Content-Type", "application/json").
		 body(request.toJSONString()).
		when().
		 put("/api/users/2").
		then().
		 statusCode(200).log().all();
		
	}
	
	@Test
	public void testPatch() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Archana");
		request.put("job", "senior quality analyst");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
		
		given().
		 header("Content-Type", "application/json").
		 body(request.toJSONString()).
		when().
		 patch("/api/users/2").
		then().
		 statusCode(200).log().all();
		
	}
	
	@Test
	public void Delete() {
		
	
		
		baseURI = "https://reqres.in";
		
		
		when().
		 delete("/api/users/2").
		then().
		 statusCode(204).
		 log().all();
		
	}
	
	
}
