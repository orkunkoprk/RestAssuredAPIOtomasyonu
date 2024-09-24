package com.otelrezervasyonu.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingByIdTests extends BaseTest{

    @Test
    public void getBookingById(){
        //Çağırıyı oluştur
        //Response kontrolleri

        /*
        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/203")
                .then()
                .log().all()
                .statusCode(200);
         */
        Response newBooking =  createBooking();
        int reserveId=newBooking.jsonPath().getJsonObject("bookingid");



        Response response = given(spec)
                .when()
                .get("/booking/"+reserveId);
        response
                .then()
                .statusCode(200);

        String firstName = response.jsonPath().getJsonObject("firstname");
        String lastName = response.jsonPath().getJsonObject("lastname");
        int totalPrice = response.jsonPath().getJsonObject("totalprice");
/*

        Assertions.assertEquals("Orkun",firstName);
        Assertions.assertEquals("Köprek",lastName);
        Assertions.assertEquals(200,totalPrice);
*/


    }
}
