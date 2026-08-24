package Day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.Map;

import io.restassured.response.Response;

public class cookies {

    @Test
    void extractcookies() {

        Response res = given()

                .when()

                .get("https://www.google.com");

       // String cookie_value = res.getCookie("AEC");

        //System.out.println("value of cookies is " + cookie_value);

        Map<String,String>cookies_values=res.getCookies();

        for(String k : cookies_values.keySet()) {

            String cookie_value=res.getCookie(k);

            System.out.println(k + "          " + cookie_value);

        }

    }

}