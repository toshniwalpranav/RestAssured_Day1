package Day2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRequestBody {

    @Test
    void testpostusingHashMap() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "vijay");
        data.put("phone", "123456");
        data.put("location", "mumbai");
        data.put("couses", List.of("java", "selenium"));

        given()
            .contentType("application/json")
            .body(data)
        .when()
            .post("http://localhost:3000/students")
        .then()
            .log().all()
            .statusCode(201)
            .body("name", equalTo("vijay"))
            .body("location", equalTo("mumbai"))
            .body("couses", hasItems("java", "selenium"));
    }
}