package com.herokuapp.booker.restful.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class Testbase {
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        //RestAssured.basePath="/booking";
    }
}
