package com.herokuapp.booker.restful.herokuappdemo;

import com.herokuapp.booker.restful.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HeroKuappDelateBooking extends Testbase {
    @Test
    public void delateuser(){
        Response response=given()
                .header("Content-Type","application/json")
                .auth().preemptive().basic("admin","password123")
                .pathParam("id", 2877)
                .when()
                .delete("/booking/{id}");
        response.then().statusCode(201);
        System.out.println("Data is delated");
        response.prettyPrint();
    }
}
