package Day5;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class fileupload {

    @Test
    public void testFileUpload() {

        File fileToUpload = new File("C:\\Users\\HP\\Desktop\\Testing\\json\\New.json");

        given()
            .multiPart("file", fileToUpload)

        .when()
            .post("https://httpbin.io/post")

        .then()
            .statusCode(200)
            .body("files", notNullValue());
    }
}