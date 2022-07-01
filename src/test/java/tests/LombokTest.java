package tests;

import models.UserLombok;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Spec.request;
import static specs.Spec.responseSpec;

public class LombokTest {
    static String UserEmail = "janet.weaver@reqres.in",
            UserFirstName = "Janet",
            UserLastName = "Weaver";


    @Test
    void testUser() {
        UserLombok data = given()
                .spec(request)
                .when()
                .get("/users/2")
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(UserLombok.class);


        assertEquals(2, data.getUser().getId());
        assertEquals(UserEmail, data.getUser().getEmail());
        assertEquals(UserFirstName, data.getUser().getFirstName());
        assertEquals(UserLastName, data.getUser().getLastName());

    }
}
