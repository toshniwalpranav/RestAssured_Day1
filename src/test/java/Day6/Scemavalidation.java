package Day6;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class Scemavalidation {

    @Test
    public void validation() {

        given()

        .when()
            .get("http://localhost:3000/books")   

        .then()
            .assertThat()
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema1.json"));  
    }
}