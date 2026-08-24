package Day6;

import org.testng.annotations.Test;
import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;

public class xmlvalidation {

    @Test
    void xmlxvalidation() {

        given()
        .when()
            .get("https://httpbin.org/xml")
        .then()
            .assertThat()
            .body(RestAssuredMatchers.matchesXsdInClasspath("travel.xsd"));
    }
}