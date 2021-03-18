package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestAPILocal {

	//@Test
	public void testGet() {

		baseURI = "http://localhost:3000";

		given().get("/users").then().statusCode(200).log().all();

	}

	//@Test
	public void testPost() {

		JSONObject request = new JSONObject();

		request.put("FirstName", "Ishaan");
		request.put("lastName", "Raj");
		request.put("subjectId", 4);

		baseURI = "http://localhost:3000";

		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("/users").
		then().
		statusCode(201);

	}

	//@Test
	public void testPut() {

		JSONObject request = new JSONObject();

		request.put("firstName", "Ishu");
		request.put("lastName", "sanu");
		request.put("subjectId", 4);

		baseURI = "http://localhost:3000";

		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("/users/4")
		.then().
			statusCode(200);

	}
	//@Test
	public void testPatch() {

		JSONObject request = new JSONObject();

		request.put("firstName", "Achu");
		request.put("lastName", "Deepu");
		request.put("subjectId", 5);

		baseURI = "http://localhost:3000";

		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.patch("/users/5")
		.then().
			statusCode(200);

	}
	
	@Test
	public void testDelete() {
		
		baseURI = "http://localhost:3000";
		
		when()
			.delete("/users/6")
		.then()
			.statusCode(200);
	}

}
