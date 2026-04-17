import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Main{
    public static void main(String[] args) {
        //GET API
        {
            Response response = given()
                    .baseUri("https://jsonplaceholder.typicode.com")
                    .when()
                    .get("/users/1")
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();

            System.out.println(response.asString());
        }
        //POST API
        {
            String requestBody = "{\n" +
                    "  \"title\":  \"My Post\",\n" +
                    "  \"body\": \" This is my first post\",\n" +
                    "  \"userId\": 1\n" +
                    "}";


            Response PostAPI = given()
                    .baseUri("https://jsonplaceholder.typicode.com")
                    .header("Content-Type", "application/json") // ✅ important
                    .body(requestBody) // ✅ sending data
                    .when()
                    .post("/posts") // ✅ POST request
                    .then()
                    .statusCode(201) // ✅ POST returns 2012k2
                    .extract()
                    .response();
            System.out.println(PostAPI.asString());
        }
        {
            String requestBody = "{\n" +
                    "  \"id\": 1,\n" +
                    "  \"title\": \"Updated Title\",\n" +
                    "  \"body\": \"This is updated post\",\n" +
                    "  \"userId\": 1\n" +
                    "}";

            Response response = given()
                    .baseUri("https://jsonplaceholder.typicode.com")
                    .header("Content-Type", "application/json") // ✅ important
                    .body(requestBody) // ✅ updated data
                    .when()
                    .put("/posts/1") // ✅ PUT request
                    .then()
                    .statusCode(200) // ✅ PUT returns 200
                    .extract()
                    .response();
            System.out.println(response.asString());
        }
        {
            // DELETE API
            Response response = given()
                    .baseUri("https://jsonplaceholder.typicode.com")
                    .when()
                    .delete("/posts/1") // ✅ DELETE request
                    .then()
                    .statusCode(200) // ✅ DELETE returns 200
                    .extract()
                    .response();

            System.out.println("Response: " + response.asString());
        }

    }
}
