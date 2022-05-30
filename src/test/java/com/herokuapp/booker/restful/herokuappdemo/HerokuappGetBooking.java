package com.herokuapp.booker.restful.herokuappdemo;

import com.herokuapp.booker.restful.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HerokuappGetBooking extends Testbase {
    @Test
    public void test001() {
        Response response = given()
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void test002() {
        Response response = given()
                .pathParam("id",1873)
                .when()
                .get("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
