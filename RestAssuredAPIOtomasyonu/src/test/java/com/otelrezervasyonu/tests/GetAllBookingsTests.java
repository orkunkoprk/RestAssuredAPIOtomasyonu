package com.otelrezervasyonu.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllBookingsTests extends BaseTest {
    //Çağrı oluştur
    //Response kontrol
    //curl -i https://restful-booker.herokuapp.com/booking

    @Test
    public void getallBookingsTest(){
        given(spec)
                .when()
                .get("/booking")
                .then()
                .statusCode(200);
    }

    @Test
    public void getBookings_with_firstname_filter_test(){

        //Yeni Rezervasyon oluştur
        int bookingID = createBookingId();

        //Çağrımızı Query Parametresi ekle
        spec.queryParam("firstname","Burki");
        spec.queryParam("lastname","Konka");

        //Çağrıyı gerçekleştir
        Response response = given(spec)
                .when()
                .get("/booking");

        //Assertion Test et
        response
                .then()
                .statusCode(200);

        List<Integer> list = response.jsonPath().getList("bookingid");
        System.out.println(list);

        Assertions.assertTrue(list.contains(bookingID));

    }
}
