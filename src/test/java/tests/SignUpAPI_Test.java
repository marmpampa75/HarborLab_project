package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SignUpAPI_Test {

    @Test
    public void LoginSuccessfulWhenCreateNewAccount_API() {

        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

        String random = String.valueOf(System.currentTimeMillis());;
        String firstName = "user-" + random;
        String lastName = "user-" + random;
        String email = "user-" + random + "@gmail.com";
        String password = random + "!";
        System.out.println(firstName + "--" + lastName + "--" + email + "--" + password);

        Map<String, Object> body = new HashMap<>();
        body.put("firstName", firstName);
        body.put("lastName", lastName);
        body.put("email", email);
        body.put("password", password);

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)

                .when()
                .post("/users")

                .then()
                .log().all()
                .statusCode(201);


        Map<String, Object> loginBody = new HashMap<>();
        loginBody.put("email", email);
        loginBody.put("password", password);

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(loginBody)

                .when()
                .post("/users/login")

                .then()
                .log().all()
                .statusCode(200);
    }
}