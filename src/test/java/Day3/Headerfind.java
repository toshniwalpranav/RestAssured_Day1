package Day3;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Headerfind {

    @Test
    void extractheader() {

        Response res = given()
                .when()
                .get("https://www.google.com");

        Headers myheaders = res.getHeaders(); // all headers stored in variable

        for (Header hd : myheaders) // loop to print each header
        {
            System.out.println(hd.getName() + "   " + hd.getValue());
        }

    }

}