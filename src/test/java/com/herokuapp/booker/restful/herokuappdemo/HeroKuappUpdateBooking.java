package com.herokuapp.booker.restful.herokuappdemo;

import com.herokuapp.booker.restful.model.BookingPojo;
import com.herokuapp.booker.restful.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class HeroKuappUpdateBooking extends Testbase {

    @Test
    public void updatebooking(){
        HashMap<Object, Object> dates = new HashMap<>();
        dates.put("checkin", "2018-01-01");
        dates.put("checkout", "2019-01-01");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Jim");
        bookingPojo.setLastname("Brow");
        bookingPojo.setTotalprice(111);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(dates);
        bookingPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Content-Type","application/json")
                .auth().preemptive().basic("admin","password123")
                .pathParam("id",2839)
                .body(bookingPojo)
                .when()
                .put("/booking/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
