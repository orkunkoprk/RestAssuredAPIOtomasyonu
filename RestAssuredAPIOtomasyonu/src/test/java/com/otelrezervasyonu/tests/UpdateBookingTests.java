package com.otelrezervasyonu.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateBookingTests extends BaseTest{

    @Test
    public void updateBookingTest() {

 //Token oluştur

        String token= createToken();



        //Rezervasyon oluştur
        Response response = createBooking();
        int bookingID = response.jsonPath().getJsonObject("bookingid");


 //Request yap
        Response response1 = given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .body(bookingObject("Orkun","Mahmut",111,false))
                .put("/booking/" + bookingID);

/*
 //Asserion/Test yaz
        String firstName = response1.jsonPath().getJsonObject("firstname");
        String lastName = response1.jsonPath().getJsonObject("lastname");
        int totalPrice = response1.jsonPath().getJsonObject("totalprice");
        boolean depositpaid = response1.jsonPath().getJsonObject("depositpaid");

        Assertions.assertEquals("Orkun",firstName);
        Assertions.assertEquals("Mahmut",lastName);
        Assertions.assertEquals(111,totalPrice);
        Assertions.assertEquals(false,depositpaid);

*/
    }
    
}
