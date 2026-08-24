package Day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.List;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class Postrequestbodyusingjson {
	
	@Test
	void testPostusinglibrary() {
		JSONObject data = new JSONObject();
		  data.put("name", "Ajay");
	        data.put("phone", "1234567");
	        data.put("location", "latur");
	        data.put("couses", List.of("java", "selenium"));

    given()
        .contentType("application/json")
        .body(data.toString())
    .when()
        .post("http://localhost:3000/students")
    .then()
        .log().all()
        .statusCode(201)
        .body("name", equalTo("Ajay"))
        .body("location", equalTo("latur"))
        .body("couses", hasItems("java", "selenium"));

}
}