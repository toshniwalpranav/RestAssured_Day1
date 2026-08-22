package Day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



import org.testng.annotations.Test;

public class Postrequestforpojo2 {

	@Test
	void testpostusingpojo() {
		 Postrequestforpojo data = new  Postrequestforpojo();
		data.setName("Peter");
		data.setLocation("France");
		data.setPhone("888888888");
		data.setCourses("Hindi");

    given()
        .contentType("application/json")
        .body(data)
    .when()
        .post("http://localhost:3000/students")
    .then()
        .log().all()
        .statusCode(201)
        .body("name", equalTo("Peter"))
        .body("location", equalTo("France"))
        .body("courses", equalTo("Hindi"));

	}
}
