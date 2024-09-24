package com.otelrezervasyonu.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class DeleteBookingTests extends BaseTest {

    @Test
    public void deleteBookingTest(){
        //Token oluştur

        //Rezervasyon oluşturma

        //Delete çağrısı

        /*
        curl -X DELETE \
    https://restful-booker.herokuapp.com/booking/1 \
    -H 'Content-Type: application/json' \
     -H 'Cookie: token=abc123'
         */
        Response response = createBooking();
        int bookingID = response.jsonPath().getJsonObject("bookingid");

        Response response5 = given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie","token="+createToken())
                .when()
                .delete("/booking/"+bookingID);


    }
}
