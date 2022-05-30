package com.herokuapp.booker.restful.herokuappdemo;

import com.herokuapp.booker.restful.model.BookingPojo;
import com.herokuapp.booker.restful.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class HeroKuapaaPostBooking extends Testbase {
    @Test
    public void createbooking() {
        HashMap<Object, Object> dates = new HashMap<>();
        dates.put("checkin", "2018-01-01");
        dates.put("checkout", "2019-01-01");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Jim");
        bookingPojo.setLastname("Brown");
        bookingPojo.setTotalprice(111);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(dates);
        bookingPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Content-Type","application/json")
                .auth().preemptive().basic("admin","password123")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void bookingToken(){
        BookingPojo bookingPojo=new BookingPojo();
        bookingPojo.setUsername("admin");
        bookingPojo.setPassword("password123");
        Response response = given()
                .header("Content-Type","application/json")
                .body(bookingPojo)
                .when()
                .post("/auth");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
