package com.otelrezervasyonu.tests;

import com.otelrezervasyonu.models.Booking;
import com.otelrezervasyonu.models.BookingDates;
import com.otelrezervasyonu.models.BookingResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


public class CreateBookingTests extends BaseTest {
    @Test
    public void createBookingTest(){
        //Çağrıyı gerçekleştir
        Response response = createBooking();
    }

    @Test
    public void createBookingWithPojo(){
        BookingDates bookingDates= new BookingDates("2023-03-02","2023-03-05");
        Booking booking = new Booking("Udemy","Kurs",455,false,bookingDates,"Tesekkurler");
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post("/booking");

        response
                .then()
                .statusCode(200);

        BookingResponse bookingResponse = response.as(BookingResponse.class);
        System.out.println(bookingResponse+" Booking response kaydedildi");

        Assertions.assertEquals("Udemy",bookingResponse.getBooking().getFirstname());
        Assertions.assertEquals("Kurs",bookingResponse.getBooking().getLastname());
        Assertions.assertEquals("Tesekkurler",bookingResponse.getBooking().getAdditionalneeds());

    }
}
