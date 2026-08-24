package Day8;

import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class CreateBook {

    public static String bookId;

    @Test(priority=1)
    void testCreateBook()
    {
        String requestBody = "{ \"title\": \"The Alchemist\", \"author\": \"Paulo Coelho\", "
                            + "\"genre\": \"fiction\", \"yearPublished\": 1988 }";

        Response response =
            given()
                .header("api-key","postmanrulz")
                .header("Content-Type","application/json")
                .body(requestBody)

            .when()
                .post("https://library-api.postmanlabs.com/books")

            .then()
                .statusCode(201)   // <-- changed from 200 to 201
                .log().all()
                .extract().response();

        bookId = response.jsonPath().getString("id");
        System.out.println("Created Book ID: " + bookId);
    }

    @AfterClass
    void runRemainingChain()
    {
        System.out.println("\n--- Auto-triggering chained tests ---\n");

        TestNG runner = new TestNG();
        runner.setTestClasses(new Class[] {
            UpdateBook.class,
            GetBook.class,
            DeleteBook.class
        });
        runner.setVerbose(0);
        runner.run();
    }
}