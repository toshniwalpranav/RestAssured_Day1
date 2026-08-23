package Day6;

import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class deserilization {

    @Test
    void convertjsontopojo() throws Exception {

        String jsondata = "{\r\n"
                + "  \"name\" : \"Peter\",\r\n"
                + "  \"location\" : \"France\",\r\n"
                + "  \"phone\" : \"888888888\",\r\n"
                + "  \"courses\" : \"Hindi\"\r\n"
                + "}";

        // Convert JSON data to POJO object
        ObjectMapper objMapper = new ObjectMapper();

        Student stupojo = objMapper.readValue(jsondata, Student.class);

        System.out.println("Name: " + stupojo.getName());
        System.out.println("Location: " + stupojo.getLocation());
        System.out.println("Phone: " + stupojo.getPhone());
        System.out.println("Course: " + stupojo.getCourses());
    }
}