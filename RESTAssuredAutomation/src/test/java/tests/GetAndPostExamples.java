package tests;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {
	
	//@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
		given().
		 get("/users?page=2").
		then().
		 statusCode(200).
		 body("data[4].first_name", equalTo("George")).
		 body("data.first_name", hasItems("Lindsay", "Byron"));
		
	}
	
	@Test
	public void testPost() {
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("name", "Archana");
		//map.put("job", "engineer");
		
		//To convert to json body
		JSONObject request = new JSONObject();
		request.put("name", "Archana");
		request.put("job", "quality analyst");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		//for POST inform the content type
		given().
		 header("Content-Type", "application/json").
		 body(request.toJSONString()).
		when().
		 post("/users").
		then().
		 statusCode(201).log().all();
		
	}

}
